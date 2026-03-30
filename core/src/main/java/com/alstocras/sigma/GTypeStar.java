package com.alstocras.sigma;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.math.*;

import java.util.*;

public class GTypeStar extends MainSequenceStar{
    final double MAX_AGE_SECONDS = 3.154e18;
    final boolean CAN_BLACK_HOLE = false;
    Color starColour;
    Sprite sprite;
    SpriteBatch batch;
    Random random;

    public GTypeStar(double mass, double radius, AxialCoordinate coord, Sprite sprite, SpriteBatch batch) {
        super(coord);
        this.massKilograms = mass;
        this.radiusMetres = radius;
        this.coordinate = coord;
        this.sprite = sprite;
        this.batch = batch;
        random = new Random();
        float r = 0.9f + random.nextFloat() * 0.1f;
        float g = 0.96f + random.nextFloat() * 0.04f;
        float b = 0.78f + random.nextFloat() * 0.1f;
        starColour = new Color(r, g, b, 1f);
    }

    @Override
    public void draw(float hexRadius, ShapeRenderer shape){
        ++ageSeconds;
        sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        batch.setProjectionMatrix(Main.camera.combined);
        batch.begin();
        sprite.setColor(starColour);
        sprite.setPosition((HexGridGenerator.axialToCartesian(this.coordinate, hexRadius)).x - sprite.getOriginX(), (HexGridGenerator.axialToCartesian(this.coordinate, hexRadius)).y - sprite.getOriginY());
        sprite.draw(batch);
        batch.end();
    }
}
