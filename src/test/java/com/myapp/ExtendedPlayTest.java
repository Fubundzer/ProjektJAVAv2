package com.myapp;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Michał on 06.07.2016.
 */
public class ExtendedPlayTest {

    @org.junit.Test
    public void testdlplyty()
    {
        Plyta a = new ExtendedPlay();
        Assert.assertTrue(a.dlplyty(11));
    }

}