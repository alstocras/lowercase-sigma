package com.alstocras.sigma;

public class Element{
    int atomicNumber = 1;
    int atomicMass = 1;
    String symbol = "H";

    public Element(int atomicMass, int atomicNumber, String symbol){
        this.atomicMass = atomicMass;
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
    }
}
