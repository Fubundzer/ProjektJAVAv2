package com.myapp;

/**
 * Created by Michał on 05.07.2016.
 */

import javax.swing.*;
import java.util.Scanner;


public class catalogMain extends JFrame{

    public static void main(String[] args) throws InterruptedException {
        Katalog dane = new Katalog("L");
        Katalog dane2 = new Katalog("E");
        Katalog dane3 = new Katalog("S");

        Scanner input = new Scanner(System.in);

        int a = 1;
        Clear c=new Clear();

        LongplayDAO b = LongplayDAO.getInstance();


        while (a != 0)
        {
            System.out.println("1. Katalog plyt typu Longplay.");
            System.out.println("2. Katalog plyt typu Extendedplay.");
            System.out.println("3. Katalog plyt typu Single.");
            System.out.println("4. Wczytaj zawartosc katalogów z bazy danych.");
            System.out.println("5. Zapisz zawartosc katalogów do bazy danych.");
            System.out.println("6. Wyswietl zawartosc calego katalogu.");
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
                        c.clr();
                        dane.menu(dane);
                        break;
                    case 2:
                        c.clr();
                        dane2.menu(dane2);
                        break;
                    case 3:
                        c.clr();
                        dane3.menu(dane3);
                        break;
                    case 4:
                        c.clr();
                        b.load(dane,dane2,dane3);
                        break;
                    case 5:
                        c.clr();
                        b.save(dane,dane2,dane3);
                        break;
                    case 6:
                        c.clr();
                        System.out.println("Zawartosc calego katalogu: ");
                        System.out.println();
                        dane.display();
                        System.out.println();
                        dane2.display();
                        System.out.println();
                        dane3.display();
                        System.out.println("-----------------------------------------------");
                        Thread.sleep(5000);
                        break;
                    case 0:
                        break;
                    default:
                        c.clr();
                        System.out.println("Nie ma takiej opcji!");
                        break;
                }

        }
    }


}