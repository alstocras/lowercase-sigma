package com.alstocras.sigma;

import com.badlogic.gdx.graphics.glutils.*;

public abstract class InterstellarObject{
    double massKilograms = 1;
    double radiusMetres = 1;
    double ageSeconds = 1;
    AxialCoordinate coordinate = new AxialCoordinate(0, 0);

    public double getSchwarzschildRadiusMetres(){
        return (2 * PhysicsConstants.GRAVITATIONAL_CONSTANT_CUBIC_METRES_PER_KILOGRAM_PER_SQUARE_SECONDS * this.massKilograms) / Math.pow(PhysicsConstants.SPEED_OF_LIGHT_METRES_PER_SECOND, 2);
    }

    public double getGravitationalForceNewtonsWithAnotherObjectAtDistanceMetres(double distanceMetres, double secondMassKilograms){
        return PhysicsConstants.GRAVITATIONAL_CONSTANT_CUBIC_METRES_PER_KILOGRAM_PER_SQUARE_SECONDS * ((this.massKilograms * secondMassKilograms) / Math.pow(distanceMetres, 2));
    }

    public InterstellarObject(AxialCoordinate coord){
        Main.gridHashMap.put(coord, this);
        System.out.println(Main.gridHashMap);
    }

    public abstract void draw(float hexRadius, ShapeRenderer shape);
}
