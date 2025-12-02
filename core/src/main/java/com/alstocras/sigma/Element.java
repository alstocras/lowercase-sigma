package com.alstocras.sigma;

public class Element{
    private double atomicMass = 0;
    private double atomicNumber = 0;
    private String name = null;
    private double isotope = 0;

    public double getAtomicMass(){
        return atomicMass;
    }

    public void setAtomicMass(double atomicMass){
        this.atomicMass = atomicMass;
    }

    public double getAtomicNumber(){
        return atomicNumber;
    }

    public void setAtomicNumber(double atomicNumber){
        this.atomicNumber = atomicNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getIsotope(){
        return isotope;
    }

    public void setIsotope(double isotope){
        this.isotope = isotope;
    }
    //TODO make elements useful
}
