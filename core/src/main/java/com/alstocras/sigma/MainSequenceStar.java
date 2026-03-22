package com.alstocras.sigma;

public abstract class MainSequenceStar extends Star{

    public double getLuminosityWattsWithMassKilograms(){
        double luminosity;
        if(this.massKilograms < (0.43 * PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE)){
            luminosity = PhysicsConstants.LUMINOSITY_OF_SUN_WATTS_FOR_REFERENCE * Math.pow((this.massKilograms / PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE), 2.3);
        }else if(this.massKilograms > (0.43 * PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE) && this.massKilograms < (2 * PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE)){
            luminosity = PhysicsConstants.LUMINOSITY_OF_SUN_WATTS_FOR_REFERENCE * Math.pow((this.massKilograms / PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE), 4);
        }else if(this.massKilograms > (2 * PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE) && this.massKilograms < (55 * PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE)){
            luminosity = PhysicsConstants.LUMINOSITY_OF_SUN_WATTS_FOR_REFERENCE * Math.pow((this.massKilograms / PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE), 3.5);
        }else{
            luminosity = PhysicsConstants.LUMINOSITY_OF_SUN_WATTS_FOR_REFERENCE * (this.massKilograms / PhysicsConstants.MASS_OF_SUN_KILOGRAMS_FOR_REFERENCE);
        }
        return luminosity;
    }

    public void fusionCheck(){
        if(this.currentFuelAtomicNumber >= 26){
            System.out.println("A main-sequence star has died. :( ");
        }
    }

}
