package com.alstocras.sigma;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;

/**
 * Base class for all interstellar objects in game.
 */
public class InterstellarObject{
    private double mass = 0;
    private double density = 0;
    private ShapeType shape = ShapeType.Point;
    private double x = 0;
    private double y = 0;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private double gravity = 0;

    public double getMass(){
        return mass;
    }

    public void setMass(double mass){
        this.mass = mass;
    }

    public double getDensity(){
        return density;
    }

    public void setDensity(double density){
        this.density = density;
    }

    public ShapeType getShape(){
        return shape;
    }

    public void setShape(ShapeType shape){
        this.shape = shape;
    }

    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setBatch(SpriteBatch batch){
        this.batch = batch;
    }

    public SpriteBatch getBatch(){
        return batch;
    }

    public ShapeRenderer getShapeRenderer(){
        return shapeRenderer;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    public double getGravity(){
        return gravity;
    }

    public void setGravity(double gravity){
        this.gravity = gravity;
    }
    //TODO make gravity do something
}
