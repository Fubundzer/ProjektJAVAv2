package com.myapp;

/**
 * Created by Michał on 05.07.2016.
 */

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class catalogMain extends JFrame{

    public static void main(String[] args) {
        Katalog dane = new Katalog("L");
        Katalog dane2 = new Katalog("E");
        Katalog dane3 = new Katalog("S");

        Scanner input = new Scanner(System.in);

        int a = 1;
        //Plyta hehe=new Longplay("cos","cos","cos",2,2000);
        //hehe.getRodzaj();


        //LongplayDAO b = new LongplayDAO();
        //b.save();


        while (a != 0)
        {
            System.out.println("1. Katalog plyt typu Longplay.");
            System.out.println("2. Katalog plyt typu Extendedplay.");
            System.out.println("3. Katalog plyt typu Single.");
            System.out.println("4. Wyswietl zawartosc calego katalogu.");
            System.out.println( "0. Zakonczenie programu.");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            a=input.nextInt();
                switch (a)
                {
                    case 1:
                        dane.menu(dane);
                        break;
                    case 2:
                        dane2.menu(dane2);
                        break;
                    case 3:
                        dane3.menu(dane3);
                        break;
                    case 4:
                        System.out.println("Zawartosc calego katalogu: ");
                        dane.display();
                        dane2.display();
                        dane3.display();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji!");
                        break;
                }

        }
    }

}