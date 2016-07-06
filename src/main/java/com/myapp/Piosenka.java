package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
import java.util.Scanner;


public class Piosenka {
    String tytulp;
    int min, sek;
    Piosenka()
    {
        tytulp="";
        min=0;
        sek=0;
    };
    Piosenka(String tp, int m, int s)
    {
        tytulp = tp;
        min = m;
        sek = s;
    };
    Piosenka(Piosenka piosenka)
    {
        tytulp = piosenka.tytulp;
        min = piosenka.min;
        sek = piosenka.sek;
    };
    //bool operator ==(const Piosenka &p);
    void disp()
    {
        System.out.println("Tytul piosenki: " +tytulp);
        System.out.println("Dlugosc piosenki: " +min+"m "+sek+"s");
    };
    int getDl()
    {
        return min * 60 + sek;
    };
    String getTytulp()
    {
        return tytulp;
    };
    Piosenka modyfikacja()
    {
        Scanner input=new Scanner(System.in);
        Piosenka a = this;
        int i=1,m,s;
        String t;
        while (i != 0)
        {
            System.out.println("Co chcesz zmienic?");
            System.out.println("1. Tytul piosenki.");
            System.out.println("2. Czas trwania piosenki.");
            System.out.println("0. Zakoncz modyfikacje.");
            i=input.nextInt();
		/*	if (cin.fail())
			{
				getZnakError();
				Sleep(1000);
				cin.clear();
				cin.sync();*/
        }
        //	else
        //	{
        switch (i)
        {
            case 1:
                System.out.println("Wprowadz nowy tytul: ");
                //cin.sync();
                //getline(cin, t);
                t=input.nextLine();
                a.tytulp = t;
                System.out.println("Zmieniono tytul.");
                //Sleep(1000);
                //system("cls");
                break;

            case 2:
                System.out.println("Wprowadz nowy czas trwania: ");
                System.out.println("MIN: ");
                m=input.nextInt();
                while(m>60||m<0)
                {
                    //getZnakDlpError();
                    //Sleep(1000);
                    //cin.clear();
                    //cin.sync();
                    System.out.println("MIN: ");
                    m=input.nextInt();
                }
                System.out.println("SEK: ");
                s=input.nextInt();
                while (s>60||s<0)
                {
                    //getZnakDlpError();
                    //Sleep(1000);
                    //cin.clear();
                    //cin.sync();
                    System.out.println("SEK: ");
                    s=input.nextInt();
                }
                a.min = m;
                a.sek = s;
                System.out.println("Zmieniono czas trwania piosenki.");
                //Sleep(1000);
                //system("cls");
                break;

            case 0:
                System.out.println("Zakonczono modyfikacje piosenki");
                //Sleep(1000);
                //system("cls");
                break;

            default:
                //getZlaOpcja();
                //system("cls");
                break;
        }
        //}
        //}
        return a;
    }
}

