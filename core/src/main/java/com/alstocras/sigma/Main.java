package com.alstocras.sigma;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private ShapeRenderer shape;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        shape = new ShapeRenderer();
    }

    private Vector2 makeHexagon(Vector2 centre, double radius, int iterator, Color colour){
        double angle = ((Math.PI / 3) * iterator) - (Math.PI / 6);
        float newCentreX = (float)(centre.x + radius * Math.cos(angle));
        float newCentreY = (float)(centre.y + radius * Math.sin(angle));
        return new Vector2(newCentreX, newCentreY);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        shape.begin(ShapeType.Line);

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
