package com.alstocras.sigma;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.math.*;

import java.util.*;

public class HexGridGenerator{
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

    public static Vector2 axialToCartesian(float q, float r, float hexRadius){
        float x = (float)((Math.sqrt(3) * q) + ((Math.sqrt(3) / 2) * r));
        float y = (float)(1.5 * r);
        x = x * hexRadius;
        y = y * hexRadius;
        return new Vector2(x, y);
    }

    public static void makeHexGrid(int rows, int cols, float radius, int zeroHexQ, int zeroHexR, OrthographicCamera camera){
        for(int i = -rows; i < rows; i++){
            for(int j = -cols; j < cols; j++){
                makeHexagon(hexagonPoints((new Vector2(axialToCartesian(i, j, radius).x += zeroHexQ, axialToCartesian(i, j, radius).y += zeroHexR)), radius), Color.DARK_GRAY, camera);
            }
        }
    }
}
