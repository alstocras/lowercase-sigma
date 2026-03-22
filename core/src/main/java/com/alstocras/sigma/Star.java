package com.alstocras.sigma;

public abstract class Star extends InterstellarObject{
    public int currentFuelAtomicNumber = 1;

    public double getDensityKilogramsPerCubicMetreWithMassKilogramsAndRadiusMetres(){
        return this.massKilograms / ((4 * Math.PI * Math.pow(this.radiusMetres, 3)) / 3);
    }

    public double getTemperatureKelvinsWithRadiusMetresAndLuminosityWatts(double luminosityWatts){
        return
    }
    public abstract double getLuminosityWattsWithSurfaceAreaSquareMetresAndMassKilograms();

}
