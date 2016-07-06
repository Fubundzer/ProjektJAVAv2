package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
public class PlytaFactory {

    public Plyta makePlyta(String newType)
    {
        if (newType.equals("L"))
        {
            return new Longplay();
        }else
        if(newType.equals("E"))
        {
            return new ExtendedPlay();
        }else
        if(newType.equals("S"))
        {
            return new Single();
        }
        else
            return null;
    }

}
