package com.myapp;

/**
 * Created by Michał on 05.07.2016.
 */
import java.awt.*;
import javax.swing.*;

public class catalogMain extends JFrame{

    public static void main(String[] args) {
        System.out.println("Hello world");

        //new KatalogMain();
        Piosenka p1 = new Piosenka("lol",1,1);
        Piosenka p2 = new Piosenka("lol",1,1);
        //test
        if(p1==p2)
            System.out.println("takie same");
        else
            System.out.println("rozne");
    }
    public catalogMain(){

        this.setSize(400,400);
        this.setVisible(true);

    }

}