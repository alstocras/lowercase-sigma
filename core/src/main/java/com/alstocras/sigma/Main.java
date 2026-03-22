package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;
import java.util.*;

/** {@link ApplicationListener} implementation shared by all platforms. */
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

    private ArrayList<Vector2> hexagonPoints(Vector2 centre, double radius){
        double angle;
        float newX = 0;
        float newY = 0;
        Vector2 currentPoint;
        ArrayList<Vector2> points = new ArrayList<Vector2>();
        for(int i = 1; i <= 6; i++){
            angle = ((Math.PI / 3) * i) - (Math.PI / 6);
            newX = (float)(centre.x + radius * Math.cos(angle));
            newY = (float)(centre.y + radius * Math.sin(angle));
            currentPoint =  new Vector2(newX, newY);
            points.add(currentPoint);
        }
        return points;
    }

    private void makeHexagon(ArrayList<Vector2> points, Color colour){
        shape.begin(ShapeType.Line);
        shape.setColor(colour);
        for(int i = 0; i < 5; i++){
            shape.line(points.get(i), points.get(i + 1));
        }
        shape.line(points.get(5), points.get(0));
        shape.end();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        ArrayList<Vector2> points = hexagonPoints(new Vector2(160, 160), 40);
        makeHexagon(points, Color.WHITE);
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        shape.dispose();
    }
}
