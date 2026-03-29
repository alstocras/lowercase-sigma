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

    public GTypeStar(double mass, double radius, AxialCoordinate coord) {
        super(coord);
        this.massKilograms = mass;
        this.radiusMetres = radius;
        this.coordinate = coord;
    }

    @Override
    public void draw(float hexRadius, ShapeRenderer shape){
        ArrayList<Vector2> points = HexGridGenerator.hexagonPoints(HexGridGenerator.axialToCartesian(this.coordinate, hexRadius), hexRadius);
        HexGridGenerator.makeFilledHexagon(points, STAR_COLOUR, Main.camera, HexGridGenerator.axialToCartesian(this.coordinate, hexRadius));
        ++ageSeconds;
    }
}
