package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Pixmap.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.viewport.*;

public class InfoPanel{
    public static Stage stage;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/cmunrm.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    BitmapFont font;
    Label mass;
    Label radius;
    Label age;
    Label bodies;
    Window window;
    Label.LabelStyle style;

    public InfoPanel(ScreenViewport screenViewport){
        this.stage = new Stage(screenViewport);
        parameter.size = 30;
        parameter.mono = false;
        parameter.kerning = true;
        font = generator.generateFont(parameter);
        generator.dispose();
        style = new Label.LabelStyle(font, RenderConstants.LIGHT_CERN_BLUE);
        Window.WindowStyle windowStyle = new Window.WindowStyle();
        windowStyle.titleFont = font;
        windowStyle.background = new BaseDrawable();
        windowStyle.titleFontColor = RenderConstants.LIGHT_CERN_BLUE;
        window = new Window("Properties:", windowStyle);
        window.row();
        mass = new Label("mass = 0 kg", style);
        window.add(mass);
        window.row();
        radius = new Label("radius = 0 m", style);
        window.add(radius);
        window.row();
        age = new Label("age = 0 s", style);
        window.add(age);
        window.row();
        bodies = new Label("0 satellites", style);
        window.add(bodies);
        window.pad(16);
        stage.addActor(window);
    }

    public void draw(){
        stage.act();
        stage.draw();
        getHexValues();
    }

    public void getHexValues(){
        Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        Vector2 unprojectedMousePos = new Vector2(Main.camera.unproject(mousePos).x, Main.camera.unproject(mousePos).y);
        AxialCoordinate selectedHex = HexGridGenerator.cartesianToAxial(unprojectedMousePos, Main.hexRadius);
        System.out.println("selected: " + selectedHex.q + ", " + selectedHex.r);
        System.out.println("map: " + Main.gridHashMap);
        System.out.println(Main.gridHashMap.containsKey(selectedHex));
        System.out.println(HexGridGenerator.axialToCartesian(new AxialCoordinate(0, 0), Main.hexRadius));
        if(Main.gridHashMap.containsKey(selectedHex)){
            window.setVisible(true);
            window.setPosition(mousePos.x + Main.hexRadius, mousePos.y - Main.hexRadius);
            double selectedMass = Main.gridHashMap.get(selectedHex).massKilograms;
            double selectedRadius = Main.gridHashMap.get(selectedHex).radiusMetres;
            double selectedAge = Main.gridHashMap.get(selectedHex).ageSeconds;
            double selectedBodies = Main.gridHashMap.get(selectedHex).orbitingBodies;
            mass.setText("mass = " + String.format("%.2e", selectedMass) + " kg");
            radius.setText("radius = " + String.format("%.2e", selectedRadius) + " m");
            age.setText("age = " + String.format("%.2e", selectedAge) + " s");
            bodies.setText(String.format("%.2e", selectedBodies) + " satellites");
            window.pack();
        }else{
            window.setVisible(false);
        }
    }
}
