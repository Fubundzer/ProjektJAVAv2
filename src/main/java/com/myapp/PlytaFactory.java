package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
public class PlytaFactory {

    public Plyta makePlyta(String newType)
    {
        Plyta nowaPlyta=null;

        if (newType.equals("L"))
        {
            return new Longplay();
        }else
        if(newType.equals("E"))
        {
           // return new ExtendedPlay(String a, String t,String g, int ip, int d);
            return new Longplay();
        }else
        if(newType.equals("S"))
        {
            //return new Single(String a, String t,String g, int ip, int d);
            return new Longplay();
        }
        else return null;
    }

}
