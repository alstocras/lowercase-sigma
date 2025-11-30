package com.alstocras.sigma;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import java.util.stream.*;

/**
 * Class for a star that performs nuclear fusion and provides elements up to Fe.
 */
public class Star extends InterstellarObject{

    private Color starColour = Color.YELLOW;
    private double radius;

    /**
     * Constructor for the star.
     * @param mass the mass of the star, in kg.
     * @param volume the volume, in m^3.
     * @param colour the colour.
     * @param batch SpriteBatch for drawing
     * @param radius radius, to be used with the ShapeRenderer.
     * @param gravity the gravitational acceleration of the star, in m/s^2.
     */
    public Star(double mass, double volume, Color colour, SpriteBatch batch, double radius, double gravity){
        this.setMass(mass);
        this.setVolume(volume);
        this.setShape(ShapeType.Filled);
        this.setStarColour(colour);
        this.setBatch(batch);
        this.radius = radius;
        this.setGravity(gravity);
        //TODO make some actually good sprites
    }

    /**
     * Draws the star, at the specified location.
     * @param x x position
     * @param y y position
     */
    public void draw(double x, double y){
        this.setX(x);
        this.setY(y);
        this.getBatch().begin();
        this.getShapeRenderer().begin(this.getShape());
        this.getShapeRenderer().setColor(this.starColour);
        this.getShapeRenderer().circle((float)this.getX(), (float)this.getY(), (float)radius);
        this.getShapeRenderer().end();
        this.getBatch().end();
    }

    public Color getStarColour(){
        return starColour;
    }

    public void setStarColour(Color starColour){
        this.starColour = starColour;
    }
    //TODO add logic for the star like fusion and stuff
}
