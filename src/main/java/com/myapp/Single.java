package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */

        import java.util.Scanner;
        import java.util.Vector;


public class Single extends Plyta{

    Single()
    {
        autor="";
        tytul="";
        gatunek="";
        ilosc_p=0;
        data=0;
        rodzaj="Single";
    };

    Single(String a, String t, String g, int ip, int d) //throws InterruptedException
    {
        autor = a;
        tytul = t;
        gatunek = g;
        data = d;
        rodzaj="Single";
        setLista(ip);
    }

    Single(String a, String t, String g, int ip, int d, Vector<Piosenka> v)
    {
        autor = a;
        tytul = t;
        gatunek = g;
        ilosc_p = ip;
        data = d;
        lista=v;
        rodzaj="Single";
    }

    Single(Single s)
    {
        autor = s.autor;
        tytul = s.tytul;
        gatunek = s.gatunek;
        ilosc_p = s.ilosc_p;
        data = s.data;
        lista = s.lista;
        rodzaj="Single";
    }

    Single modyfikacja()
    {
        String a;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int i = 1;
        while (i != 0)
        {
            //system("cls");
            System.out.println("Modyfikowanie albumu. Wybierz jedna z ponizszych opcji.");
            System.out.println("1. Modyfikacja autora plyty.");
            System.out.println("2. Modyfikacja tytulu plyty.");
            System.out.println("3. Modyfikacja roku wydania plyty.");
            System.out.println("4. Modyfikacja gatunku plyty.");
            System.out.println("5. Modyfikacja listy piosenek.");
            System.out.println("0. Zakoncz modyfikacje.");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            i=input.nextInt();
            switch (i){
                case 1:
                    System.out.println("Wprowadz nowego autora plyty:");
                    a=input2.nextLine();
                    this.autor = a;
                    break;
                case 2:
                    System.out.println("Wprowadz nowy tytul plyty:");
                    tytul=input2.nextLine();
                    break;
                case 3:
                    System.out.println("Wprowadz nowy rok wydania plyty:");
                    while (!input.hasNextInt())
                    {
                        System.out.println("Wprowadz liczbe!");
                        input.next();
                    }
                    this.data=input.nextInt();
                    break;
                case 4:
                    System.out.println("Wprowadz nowy gatunek plyty:");
                    a=input2.nextLine();
                    this.gatunek = a;
                    break;
                case 5:
                    this.lista = modyfikacjalisty();
                    break;
                case 0:
                    System.out.println("Powrot do menu.");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }

        return this;
    }

    String getRodzaj()
    {
        return rodzaj;
    }


    Vector<Piosenka> modyfikacjalisty()
    {
        Piosenka a;
        int i = 1, j = 0;
        Scanner input = new Scanner(System.in);
        while (i != 0)
        {
            System.out.println("Co chcesz zrobic?");
            System.out.println("1. Dodac piosenke.");
            System.out.println("2. Usunac piosenke.");
            System.out.println("3. Zmodyfikowac piosenke.");
            System.out.println("0. Zakonczyc modyfikacje.");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            i=input.nextInt();
            switch (i)
            {
                case 1:
                    lista.addElement(dodawanie());
                    ilosc_p++;
                    break;
                case 2:
                    if (ilosc_p == 0)
                    {
                        System.out.println("Lista piosenek jest pusta");
                    }
                    else
                    {
                        System.out.println("Ktora piosenke chcesz usunac?");
                        wypisywaniep();
                        while (!input.hasNextInt())
                        {
                            System.out.println("Wprowadz liczbe!");
                            input.next();
                        }
                        j=input.nextInt();
                        while (j > ilosc_p || j < 1)
                        {
                            System.out.println("Nie ma piosenki o takim numerze, sprobuj jeszcze raz.");
                            while (!input.hasNextInt())
                            {
                                System.out.println("Wprowadz liczbe!");
                                input.next();
                            }
                            j=input.nextInt();
                        }
                        lista.remove(j-1);
                        ilosc_p--;
                    }
                    break;
                case 3:
                    System.out.println("Ktora piosenke chcesz zmodyfikowac?");
                    wypisywaniep();
                    while (!input.hasNextInt())
                    {
                        System.out.println("Wprowadz liczbe!");
                        input.next();
                    }
                    j=input.nextInt();
                    while (j>ilosc_p||j<1)
                    {
                        System.out.println("Nie ma piosenki o takim numerze, sprobuj jeszcze raz.");
                        while (!input.hasNextInt())
                        {
                            System.out.println("Wprowadz liczbe!");
                            input.next();
                        }
                        j=input.nextInt();
                    }
                    a = lista.get(j-1).modyfikacja();
                    modl(j - 1, a);
                    break;
                case 0:
                    System.out.println("Zakonczono modyfikacje");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        }
        return lista;
    }

    Boolean dlplyty(int i)
    {
        if(i>5||dlugosc()>900)
        {
            return true;
        }
        else
            return false;
    }

    void typmenu()
    {
        System.out.println("Katalog plyt typu Single. Co chcesz zrobic?");
    }

    void setLista(int i)
    {
        int j;
        if(dlplyty(i))
        {
            System.out.println("Ten rodzaj plyty moze zawierac maksymalnie 5 piosenek i trwać 15 min.");
        }
        else
        {
            for(j=0;j<i;j++)
            {
                ilosc_p++;
                lista.addElement(dodawanie());
                if(dlplyty(i))
                {
                    dlplyty(2);
                    break;
                }
            }
        }
    }

    void dlPlytyBlad(int i)
    {
        switch(i)
        {
            case 1:
                System.out.println("Ten rodzaj plyty moze zawierac maksymalnie 5 piosenek. Sprobuj dodac ten album uzywajac typu ExtendedPlay lub Longplay.");
            case 2:
                System.out.println("Ten rodzaj plyty moze trwac maksymalnie 15min. Sprobuj dodac ten album uzywajac typu ExtendedPlay lub Longplay.");
        }
    }
}

