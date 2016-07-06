package com.myapp;

/**
 * Created by Michał on 05.07.2016.
 */
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class catalogMain extends JFrame{

    public static void main(String[] args) {
        Katalog dane = new Katalog("L");
        Katalog dane2 = new Katalog("E");
        Katalog dane3 = new Katalog("S");

        Scanner input = new Scanner(System.in);

        int a = 1;
        while (a != 0)
        {
            //system("cls");
            System.out.println("1. Katalog plyt typu Longplay.");
            System.out.println("2. Katalog plyt typu Extendedplay.");
            System.out.println("3. Katalog plyt typu Single.");
            System.out.println("4. Wyswietl zawartosc calego katalogu.");
            System.out.println( "0. Zakonczenie programu.");
            a=input.nextInt();
            /*if (cin.fail())
            {
                getZnakError();
                Sleep(1000);
                cin.clear();
                cin.sync();
            }
            else
            {*/
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
                        //system("cls");
                        System.out.println("Zawartosc calego katalogu: ");
                        dane.display();
                        dane2.display();
                        dane3.display();
                        //system("pause");
                        break;
                    case 0:
                        break;
                    default:
                        //getZlaOpcja();
                        //Sleep(1000);
                        break;
                }

        }
    }

}