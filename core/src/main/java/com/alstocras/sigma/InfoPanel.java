package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
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
    Window window;

    public InfoPanel(ScreenViewport screenViewport){
        this.stage = new Stage(screenViewport);
        parameter.size = 20;
        parameter.mono = false;
        parameter.kerning = true;
        font = generator.generateFont(parameter);
        generator.dispose();
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);
        Window.WindowStyle windowStyle = new Window.WindowStyle();
        windowStyle.titleFont = font;
        windowStyle.background = new BaseDrawable();
        window = new Window("Properties", windowStyle);
        mass = new Label("234 kg", style);
        window.add(mass);
        window.row();
        window.pad(16);
        window.add(new Label("more text", style));
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
            window.setPosition(mousePos.x + Main.hexRadius, mousePos.y);
        }else{
            window.setVisible(false);
        }
    }
}
