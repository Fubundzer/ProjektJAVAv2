package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Katalog {

    Vector <Plyta> dane=new Vector<Plyta>();
    String typ;
    PlytaFactory factory = new PlytaFactory();
    Clear c=new Clear();

    Katalog(String typ)
    {
        this.typ=typ;
    };

    Katalog(Vector <Plyta> dane,String typ)
    {
        this.dane=dane;
        this.typ=typ;
    }
    Katalog(Katalog katalog)
    {
        dane = katalog.dane;
        typ=katalog.typ;
    }

    void doBazy(Plyta a)
    {
        dane.addElement(a);
    }

    Vector <Plyta> getDane()
    {
        return dane;
    }

    Katalog usuwanie()
    {
        Scanner input = new Scanner(System.in);
        int i;
        char a = 'a';
        if (dane.size() == 0)
        {
            System.out.println("Katalog jest już pusty.");
        }
        else
        {
            System.out.print("Podaj numer albumu, ktory chcesz usunac: ");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            i=input.nextInt();
            while (i > dane.size() || i < 1)
            {
                System.out.print("Podaj numer albumu, ktory chcesz usunac: ");
                while (!input.hasNextInt())
                {
                    System.out.println("Wprowadz liczbe!");
                    input.next();
                }
                i=input.nextInt();
            }
            while (a != 'y' && a != 'Y' && a != 'n' && a != 'N')
            {
                System.out.println("Jestes pewna/y? Y/N");
                a=input.next().charAt(0);
                switch (a){
                    case 'y':
                        dane.remove(i-1);
                        System.out.println("Album usuniety.");
                        break;
                    case 'Y':
                        dane.remove(i-1);
                        System.out.println("Album usuniety.");
                        break;
                    case 'n':
                        System.out.println("Nie usunieto albumu.");
                        break;
                    case 'N':
                        System.out.println("Nie usunieto albumu.");
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji!");
                        break;
                }
            }
        }
        return this;
    }

    Katalog czyszczenie()
    {
        Scanner input=new Scanner(System.in);
        char a = 'a';
        while (a != 'y'&&a != 'Y'&&a != 'n'&&a != 'N')
        {
            System.out.print("Jestes pewna/y? Y/N");
            a=input.next().charAt(0);
            switch (a){
                case 'y':
                    dane.clear();
                    System.out.println("Katalog wyczyszczony.");
                    break;
                case 'Y':
                    dane.clear();
                    System.out.println("Katalog wyczyszczony.");
                    break;
                case 'n':
                    System.out.println("Nie wyczyszczono katalogu.");
                    break;
                case 'N':
                    System.out.println("Nie wyczyszczono katalogu.");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }

        return this;
    }

    Katalog wstawianie()
    {
        Scanner input = new Scanner(System.in);
        int i;
        System.out.println("W ktore miejsce chcesz wstawic nowy album?");
        while (!input.hasNextInt())
        {
            System.out.println("Wprowadz liczbe!");
            input.next();
        }
        i=input.nextInt();
        while (i>dane.size()+1||i<1)
        {
            System.out.println("W ktore miejsce chcesz wstawic nowy album?");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            i=input.nextInt();
        }
        if (i == dane.size() + 1)
        {
            dane.addElement(dodawaniavec());
        }
        else
            dane.insertElementAt(dodawaniavec(), i-1);
        return this;
    }

    Katalog wstawianietab()
    {
        Scanner input = new Scanner(System.in);
        int i, j;
        Plyta tab[];
        System.out.println("Ile albumow chcesz wstawic?");
        while (!input.hasNextInt())
        {
            System.out.println("Wprowadz liczbe!");
            input.next();
        }
        i=input.nextInt();
        tab = new Plyta[i];
        for (j = 0; j < i; j++)
        {
            tab[j] = dodawaniavec();
        }
        for (j = 0; j < i; j++)
        {
            dane.add(tab[j]);
        }
        return this;
    }

    Plyta get_value(int i)
    {
        return dane.get(i);
    }

    void mod(Plyta d, int a)
    {
        dane.set(a,d);
    }

    int dlugosc()
    {
        return dane.size();
    }

    void display()
    {
        for (int i = 0; i < dane.size(); i++)
        {
            System.out.print((i + 1)+". ");
            dane.get(i).disp();
            System.out.println();
        }
    }

    void wszysukiwaniek()
    {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String a;
        int r, j,i=1;
        while(i!=0) {
            System.out.println("Wybierz kategorie wyszukiwania.");
            System.out.println("1. Autor.");
            System.out.println("2. Tytul.");
            System.out.println("3. Gatunek.");
            System.out.println("4. Rok wydania.");
            System.out.println("5. Ilosc piosenek.");
            System.out.println("6. Minimalna dlugosc.");
            System.out.println("0. Zakoncz wyszukiwanie.");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            i=input.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Wprowadz autora.");
                    a=input2.nextLine();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getAutor().equals(a)) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Wprowadz tytul.");
                    a=input2.nextLine();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getTytul().equals(a)) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Wprowadz gatunek.");
                    a=input2.nextLine();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getGatunek().equals(a)) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Wprowadz rok.");
                    while (!input.hasNextInt())
                    {
                        System.out.println("Wprowadz liczbe!");
                        input.next();
                    }
                    r=input.nextInt();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getRok() == r) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Wprowadz ilosc piosenek.");
                    while (!input.hasNextInt())
                    {
                        System.out.println("Wprowadz liczbe!");
                        input.next();
                    }
                    r=input.nextInt();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getIloscp() == r) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                            System.out.println();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Wprowadz minimalna dlugosc plyty (MIN).");
                    while (!input.hasNextInt())
                    {
                        System.out.println("Wprowadz liczbe!");
                        input.next();
                    }
                    r=input.nextInt();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getDlugosc() >= r * 60) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                            System.out.println();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Zakonczono wyszukiwanie.");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }
    }

    Plyta dodawaniavec()
    {
        Plyta a= factory.makePlyta(typ);
        int k=1;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String autor, tytul,gatunek;
        int ilosc_p, data,i=0;
        System.out.println("Podaj autora plyty: ");
        autor=input.nextLine();
        System.out.println("Podaj tytul plyty: ");
        tytul=input.nextLine();
        System.out.println("Podaj gatunek plyty: ");
        gatunek=input.nextLine();
        System.out.println("Podaj nosnik plyty: ");
        while(k!=0)
        {
            System.out.println("1. Winyl. ");
            System.out.println("2. CD.");
            while (!input2.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input2.next();
            }
            k=input2.nextInt();
            switch(k)
            {
                case 1:
                    a.wstawTyp("w");
                    k=0;
                    break;
                case 2:
                    a.wstawTyp("c");
                    k=0;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }
        System.out.println("Podaj ilosc piosenek: ");
        while (!input.hasNextInt())
        {
            System.out.println("Wprowadz liczbe!");
            input.next();
        }
        ilosc_p = input.nextInt();
        if(a.dlplyty(ilosc_p))
        {
            a.dlPlytyBlad(1);
            a.setAutor(autor);
            a.setTytul(tytul);
            a.setGatunek(gatunek);
            a.setIlosc_p(ilosc_p);
            a.setData(0);
            return a;
        }
        System.out.println("Podaj rok wydania plyty: ");
        while (!input.hasNextInt())
        {
            System.out.println("Wprowadz liczbe!");
            input.next();
        }
        data=input.nextInt();
        a.setAutor(autor);
        a.setTytul(tytul);
        a.setGatunek(gatunek);
        a.setLista(ilosc_p);
        a.setData(data);
        return a;
    }

    void domenu()
    {
        Plyta a = factory.makePlyta(typ);
        a.typmenu();
    }

    Katalog menu(Katalog catalog)
    {
        Scanner input=new Scanner(System.in);
        int a = 1;
        int b = 1;
        while (a != 0)
        {

            domenu();
            System.out.println("1. Dodaj plyte.");
            System.out.println("2. Usun plyte.");
            System.out.println("3. Wyczysc katalog.");
            System.out.println("4. Zmien informacje na temat plyty.");
            System.out.println("5. Wstaw plyte w konretne miejsce.");
            System.out.println("6. Wstaw dwie lub wiecej plyt.");
            System.out.println("7. Wyszukiwanie plyt.");
            System.out.println("8. Wyswietl informacje o plytach.");
            System.out.println("0. Powrot do menu.");
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
                        catalog.dane.addElement(dodawaniavec());
                        if(catalog.dane.get(dane.size()-1).dlplyty(catalog.dane.get(dane.size()-1).getIloscp()))
                        {
                            dane.remove(dane.size()-1);
                        }
                        break;
                    case 2:
                        c.clr();
                        catalog.display();
                        catalog=catalog.usuwanie();
                        break;
                    case 3:
                        c.clr();
                        catalog=catalog.czyszczenie();
                        break;
                    case 4:
                        c.clr();
                        catalog.display();
                        System.out.println("Ktory album chcesz modyfikowac?");
                        while (!input.hasNextInt())
                        {
                            System.out.println("Wprowadz liczbe!");
                            input.next();
                        }
                        b=input.nextInt();
                        while (b>catalog.dlugosc()||b<1)
                        {
                            System.out.println("Ktory album chcesz modyfikowac?");
                            while (!input.hasNextInt())
                            {
                                System.out.println("Wprowadz liczbe!");
                                input.next();
                            }
                            b=input.nextInt();
                        }
                        c.clr();
                        catalog.mod(catalog.get_value(b - 1).modyfikacja(), b-1);
                        break;
                    case 5:
                        c.clr();
                        catalog.display();
                        catalog.wstawianie();
                        break;
                    case 6:
                        c.clr();
                        catalog.wstawianietab();
                        break;
                    case 7:
                        c.clr();
                        catalog.wszysukiwaniek();
                        break;
                    case 8:
                        c.clr();
                        catalog.display();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji!");
                        break;
                }
            }
        return catalog;
        }
}


