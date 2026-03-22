package com.alstocras.sigma;

public class InterstellarObject{
    double massKilograms = 1;
    double radiusMetres = 1;
    double ageSeconds = 1;

    public double getSchwarzschildRadiusMetres(){
        return (2 * PhysicsConstants.GRAVITATIONAL_CONSTANT_CUBIC_METRES_PER_KILOGRAM_PER_SQUARE_SECONDS * this.massKilograms) / Math.pow(PhysicsConstants.SPEED_OF_LIGHT_METRES_PER_SECOND, 2);
    }

    public double getGravitationalForceNewtonsWithAnotherObjectAtDistanceMetres(double distanceMetres, double secondMassKilograms){
        return PhysicsConstants.GRAVITATIONAL_CONSTANT_CUBIC_METRES_PER_KILOGRAM_PER_SQUARE_SECONDS * ((this.massKilograms * secondMassKilograms) / Math.pow(distanceMetres, 2));
    }
}
