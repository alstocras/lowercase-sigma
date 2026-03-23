package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.viewport.*;

public class InfoPanel{
    public static Stage stage;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/cmunrm.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    BitmapFont font;

    public InfoPanel(ScreenViewport screenViewport){
        this.stage = new Stage(screenViewport);
        parameter.size = 20;
        parameter.mono = false;
        parameter.kerning = true;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void draw(){
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);
        Window.WindowStyle windowStyle = new Window.WindowStyle();
        windowStyle.titleFont = font;
        windowStyle.background = new BaseDrawable();
        Window window = new Window("Properties", windowStyle);
        window.add(new Label("some text", style));
        window.row();
        window.pad(16);
        window.add(new Label("more text", style));
        stage.addActor(window);
        stage.act();
        stage.draw();
    }
}
