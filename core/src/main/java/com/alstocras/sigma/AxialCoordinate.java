package com.alstocras.sigma;

import com.badlogic.gdx.utils.*;

public class AxialCoordinate{
    int q = 0;
    int r = 0;

    public AxialCoordinate(int q, int r){
        this.q = q;
        this.r = r;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof AxialCoordinate)){
            return false;
        }
        else{
            AxialCoordinate axialCoord = (AxialCoordinate)obj;
            return this.q == axialCoord.q && this.r == axialCoord.r;
        }
    }

    @Override
    public int hashCode(){
        return 31 * this.q + this.r;
    }

}
