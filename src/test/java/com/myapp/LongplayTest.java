package com.myapp;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Michał on 06.07.2016.
 */
public class LongplayTest {

    @org.junit.Test
    public void testSetValue()
    {
        Plyta a = new Longplay();
        a.setAutor("autor");
        a.setTytul("tytul");
        a.setGatunek("gatunek");
        a.setIlosc_p(10);
        a.setData(2000);
        Assert.assertEquals("autor",a.getAutor());
        Assert.assertEquals("tytul",a.getTytul());
        Assert.assertEquals("gatunek",a.getGatunek());
        Assert.assertEquals(10,a.getIloscp());
        Assert.assertEquals(2000,a.getRok());
    }

}