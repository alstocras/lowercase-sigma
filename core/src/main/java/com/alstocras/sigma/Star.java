package com.alstocras.sigma;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;

/**
 * Class for a star that performs nuclear fusion and provides elements up to Fe.
 */
public class Star extends InterstellarObject{

    private Color starColour = Color.YELLOW;
    private double radius;
    private double hydrogenAmountKg = 0; //OK I know it's supposed to be 'kg' not 'Kg' but camelCase demands it
    private BitmapFont font;
    private String starText = "";

    /**
     * Constructor for the star.
     * @param mass the mass of the star, in kg.
     * @param density the density, in kg/m^3.
     * @param colour the colour.
     * @param batch SpriteBatch for drawing
     */
    public Star(double mass, double density, Color colour, SpriteBatch batch){
        this.setMass(mass);
        this.setDensity(density);
        this.setShape(ShapeType.Filled);
        this.setStarColour(colour);
        this.setBatch(batch);
        this.radius = 10 * (Math.cbrt((3 * mass)/(4 * density * 3.1415)));
        font = new BitmapFont();
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
        font.draw(this.getBatch(), starText, (float)x, (float)y);
        this.getBatch().end();
        this.getShapeRenderer().begin(this.getShape());
        this.getShapeRenderer().setColor(this.starColour);
        this.getShapeRenderer().circle((float)this.getX(), (float)this.getY(), (float)radius);
        this.getShapeRenderer().end();
    }
    public void update(float delta) {
        if (hydrogenAmountKg > 0) {
            hydrogenAmountKg--;
            starText = "Hydrogen: " + hydrogenAmountKg;
        }
    }


    public Color getStarColour(){
        return starColour;
    }

    public void setStarColour(Color starColour){
        this.starColour = starColour;
    }

    public double getHydrogenAmountKg(){
        return hydrogenAmountKg;
    }

    public void setHydrogenAmountKg(double hydrogenAmountKg){
        this.hydrogenAmountKg = hydrogenAmountKg;
    }

    public String getStarText(){
        return starText;
    }

    public void setStarText(String starText){
        this.starText = starText;
    }
    //TODO fusion and supernovae

}
