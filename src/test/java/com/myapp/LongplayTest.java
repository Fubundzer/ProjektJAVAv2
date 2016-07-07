package com.myapp;

import org.junit.Assert;
import java.util.Vector;

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

    @org.junit.Test
    public void testDlugosc()
    {
        Vector<Piosenka> vec =new Vector<Piosenka>();
        vec.addElement(new Piosenka("Tytul1",3,45));
        vec.addElement(new Piosenka("Tytul2",4,35));
        Plyta plyta = new Longplay("Autor","Tytul","Gatunek",2,2001,vec);
        Assert.assertEquals(500,plyta.dlugosc());
    }

    @org.junit.Test
    public void testmodl()
    {
        Vector<Piosenka> vec =new Vector<Piosenka>();
        vec.addElement(new Piosenka("Tytul1",3,45));
        vec.addElement(new Piosenka("Tytul2",4,35));
        Plyta plyta = new Longplay("Autor","Tytul","Gatunek",2,2001,vec);
        Assert.assertEquals("Tytul1",vec.get(0).getTytulp());
        plyta.modl(0,new Piosenka("Tytul3",3,45));
        Assert.assertEquals("Tytul3",vec.get(0).getTytulp());
    }

}