package com.alstocras.sigma;

public abstract class Star extends InterstellarObject{
    public int currentFuelAtomicNumber = 1;

    public double getDensityKilogramsPerCubicMetreWithMassKilogramsAndRadiusMetres(){
        return this.massKilograms / ((4 * Math.PI * Math.pow(this.radiusMetres, 3)) / 3);
    }

    public double getTemperatureKelvinsWithRadiusMetresAndLuminosityWatts(double luminosityWatts){
        return Math.pow((luminosityWatts / (4 * Math.PI * Math.pow(this.radiusMetres, 2) * PhysicsConstants.STEFAN_BOLTZMANN_CONSTANT_WATTS_PER_SQUARE_METRE_PER_KELVIN_TO_THE_FOURTH_POWER)), 0.25);
    }

    public abstract double getLuminosityWattsWithMassKilograms();

}
