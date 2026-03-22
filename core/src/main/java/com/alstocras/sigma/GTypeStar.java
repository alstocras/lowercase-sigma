package com.alstocras.sigma;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.math.*;

import java.util.*;

public class GTypeStar extends MainSequenceStar{
    final double MAX_AGE_SECONDS = 3.154e18;
    final boolean CAN_BLACK_HOLE = false;
    final Color STAR_COLOUR = Color.valueOf("fffdd4ff");

    public GTypeStar(double mass, double radius){
        this.massKilograms = mass;
        this.radiusMetres = radius;
    }

    public void create(int q, int r, ShapeRenderer shape, float hexRadius){
        ArrayList<Vector2> points = HexGridGenerator.hexagonPoints(HexGridGenerator.axialToCartesian(q, r, hexRadius), hexRadius);
        HexGridGenerator.makeFilledHexagon(points, STAR_COLOUR, Main.camera, HexGridGenerator.axialToCartesian(q, r, hexRadius));
        System.out.println("centre: " + HexGridGenerator.axialToCartesian(q, r, 40));
        System.out.println("points: " + points);
    }
}
