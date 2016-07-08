package com.myapp;

/**
 * Created by Michał on 08.07.2016.
 */
public interface TypPlyty {

    String typ();
}

class Winyl implements TypPlyty{

    public String typ()
    {
        return "Winyl";
    }
}

class CD implements TypPlyty{

    public String typ()
    {
        return "CD";
    }
}
