package com.myapp;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Michał on 07.07.2016.
 */
public class PiosenkaTest {

    @org.junit.Test
    public void TestgetDl()
    {
        Piosenka a = new Piosenka("piosenka",5,20);
        Assert.assertEquals(320,a.getDl());
    }

}