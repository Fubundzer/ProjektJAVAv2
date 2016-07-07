package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
import java.util.Scanner;


public class Piosenka {
    String tytulp;
    int min, sek;

    public Piosenka()
    {
        tytulp="";
        min=0;
        sek=0;
    };

    public Piosenka(String tp, int m, int s)
    {
        tytulp = tp;
        min = m;
        sek = s;
    };

    public Piosenka(Piosenka piosenka)
    {
        tytulp = piosenka.tytulp;
        min = piosenka.min;
        sek = piosenka.sek;
    };

    public void disp()
    {
        System.out.println("Tytul piosenki: " +tytulp);
        System.out.println("Dlugosc piosenki: " +min+"m "+sek+"s");
    };

    public int getDl()
    {
        return min * 60 + sek;
    };

    public String getTytulp()
    {
        return tytulp;
    };

    public Piosenka modyfikacja() {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Piosenka a = this;
        int i = 1, m, s;
        String t;
        while (i != 0) {
            System.out.println("Co chcesz zmienic?");
            System.out.println("1. Tytul piosenki.");
            System.out.println("2. Czas trwania piosenki.");
            System.out.println("0. Zakoncz modyfikacje.");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            i = input.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("Wprowadz nowy tytul: ");
                        t = input2.nextLine();
                        a.tytulp = t;
                        System.out.println("Zmieniono tytul.");
                        break;
                    case 2:
                        System.out.println("Wprowadz nowy czas trwania: ");
                        System.out.println("MIN: ");
                        while (!input.hasNextInt())
                        {
                            System.out.println("Wprowadz liczbe!");
                            input.next();
                        }
                        m = input.nextInt();
                        while (m > 60 || m < 0) {
                            System.out.println("Sprobuj jeszcze raz");
                            System.out.println("MIN: ");
                            while (!input.hasNextInt())
                            {
                                System.out.println("Wprowadz liczbe!");
                                input.next();
                            }
                            m = input.nextInt();
                        }
                        System.out.println("SEK: ");
                        s = input.nextInt();
                        while (s > 60 || s < 0) {
                            System.out.println("Sprobuj jeszcze raz");
                            System.out.println("SEK: ");
                            while (!input.hasNextInt())
                            {
                                System.out.println("Wprowadz liczbe!");
                                input.next();
                            }
                            s = input.nextInt();
                        }
                        a.min = m;
                        a.sek = s;
                        System.out.println("Zmieniono czas trwania piosenki.");
                        break;
                    case 0:
                        System.out.println("Zakonczono modyfikacje piosenki");
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji!");
                        break;
                }
        }
        return a;
    }
}

