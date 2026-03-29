package com.alstocras.sigma;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.math.*;

import java.lang.reflect.*;
import java.util.*;

public abstract class HexGridGenerator{

    static int screenCentreX = Gdx.graphics.getWidth() / 2;
    static int screenCentreY = Gdx.graphics.getHeight() / 2;
    static ShapeRenderer shape = new ShapeRenderer();

    public static ArrayList<Vector2> hexagonPoints(Vector2 centre, double radius){
        double angle;
        float newX = 0;
        float newY = 0;
        Vector2 currentPoint;
        ArrayList<Vector2> points = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            angle = ((Math.PI / 3) * i) - (Math.PI / 6);
            newX = (float)(centre.x + radius * Math.cos(angle));
            newY = (float)(centre.y + radius * Math.sin(angle));
            currentPoint =  new Vector2(newX, newY);
            points.add(currentPoint);
        }
        return points;
    }

    public static void makeHexagon(ArrayList<Vector2> points, Color colour, OrthographicCamera camera){
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeType.Line);
        shape.setColor(colour);
        for(int i = 0; i < 5; i++){
            shape.line(points.get(i), points.get(i + 1));
        }
        shape.line(points.get(5), points.get(0));
        shape.end();
    }

    public static Vector2 axialToCartesian(AxialCoordinate coord, float hexRadius){
        float x = (float)((Math.sqrt(3) * coord.q) + ((Math.sqrt(3) / 2) * coord.r));
        float y = (float)(1.5 * coord.r);
        x = (x * hexRadius) + screenCentreX;
        y = (y * hexRadius) + screenCentreY;
        return new Vector2(x, y);
    }

    public static AxialCoordinate cartesianToAxial(Vector2 cartesian, float hexRadius){
        cartesian.x = (cartesian.x - screenCentreX) / hexRadius;
        cartesian.y = (cartesian.y - screenCentreY) / hexRadius;
        int temp = (int)Math.floor(cartesian.x + Math.sqrt(3) * cartesian.y + 1);
        int q = (int)Math.floor((Math.floor(2 * cartesian.x + 1) + temp) / 3);
        int r = (int)Math.floor((temp + Math.floor(-cartesian.x + Math.sqrt(3) * cartesian.y + 1)) / 3);
        return new AxialCoordinate(q, r);
    }

    public static void makeHexGrid(int rows, int cols, float radius, OrthographicCamera camera){
        for(int i = -rows; i < rows; i++){
            for(int j = -cols; j < cols; j++){
                makeHexagon(hexagonPoints(new Vector2(axialToCartesian(new AxialCoordinate(i, j), radius)), radius), Color.DARK_GRAY, camera);
            }
        }
    }

    public static void makeFilledHexagon(ArrayList<Vector2> points, Color colour, OrthographicCamera camera, Vector2 centre){
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeType.Filled);
        shape.setColor(colour);
        for(int i = 0; i < 6; i++){
            shape.triangle(points.get(i).x, points.get(i).y, points.get((i + 1) % 6).x, points.get((i + 1) % 6).y, centre.x, centre.y);
        }
        shape.end();
    }

    public static void resize(int width, int height){
        HexGridGenerator.screenCentreX = width / 2;
        HexGridGenerator.screenCentreY = height / 2;
    }
}
