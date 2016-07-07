package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
import java.util.Vector;
import java.util.Scanner;

public abstract class Plyta {
    String autor, tytul, gatunek,rodzaj;
    int ilosc_p, data;
    Vector<Piosenka> lista = new Vector<Piosenka>();

    Piosenka dodawanie()
    {
        Scanner input=new Scanner(System.in);
        Scanner input2=new Scanner(System.in);
        String t;
        int m, s;
        System.out.print("Wprowadz tytul piosenki: ");
        t=input2.nextLine();
        System.out.println("Wprowadz czas trwania piosenki: ");
        System.out.print("MIN: ");
        while (!input.hasNextInt())
        {
            System.out.println("Wprowadz liczbe!");
            input.next();
        }
        m=input.nextInt();
        while (m>60||m<0)
        {
            System.out.println("Sprobuj jeszcze raz");
            System.out.print("MIN: ");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            m=input.nextInt();
        }
        System.out.print("SEK: ");
        while (!input.hasNextInt())
        {
            System.out.println("Wprowadz liczbe!");
            input.next();
        }
        s=input.nextInt();
        while (s>60||s<0)
        {
            System.out.println("Sprobuj jeszcze raz");
            System.out.print("SEK: ");
            while (!input.hasNextInt())
            {
                System.out.println("Wprowadz liczbe!");
                input.next();
            }
            s=input.nextInt();
        }
        Piosenka a= new Piosenka(t, m, s);
        return a;
    }

    int dlugosc()
    {
        int czas = 0;
        for (int i = 0; i < ilosc_p; i++)
        {
            czas += lista.get(i).getDl();
        }
        return czas;
    }

    int getDlugosc()
    {
        int czas = 0;
        for (int i = 0; i < ilosc_p; i++)
        {
            czas += lista.get(i).getDl();
        }
        System.out.println("Dlugosc plyty to: "+czas / 60+"MIN "+czas % 60+"SEK");
        return czas;
    }

    void modl(int i, Piosenka a)
    {
        lista.set(i, a);
    }

    void wypisywaniep()
    {
        for (int i = 0; i < ilosc_p; i++)
        {
            System.out.print((i + 1)+". ");
            lista.get(i).disp();
        }
    }

    String get_lista()
    {
        String a = "";
        for (int i = 0; i < ilosc_p; i++)
        {
            a += lista.get(i).getTytulp() + "\n";
            a += (lista.get(i).getDl() / 60) + "\n";
            a += (lista.get(i).getDl() % 60) + "\n";
        }
        return a;
    }

    String getAutor()
    {
        return autor;
    }

    String getTytul()
    {
        return tytul;
    }

    String getGatunek()
    {
        return gatunek;
    }

    int getRok()
    {
        return data;
    }

    int getIloscp()
    {
        return ilosc_p;
    }

    void setAutor(String a)
    {
        this.autor=a;
    }

    void setTytul(String t)
    {
        this.tytul=t;
    }

    void setGatunek(String g)
    {
        this.gatunek=g;
    }

    void setIlosc_p(int ip)
    {
        this.ilosc_p=ip;
    }

    void setData(int d)
    {
        this.data=d;
    }

    void disp()
    {
        System.out.println("Autor plyty: "+autor);
        System.out.println("Tytul plyty: "+tytul);
        System.out.println("Rok wydania: "+data);
        System.out.println("Gatunek: "+gatunek);
        System.out.println("Rodzaj: "+rodzaj);
        System.out.println("Ilosc piosenek: "+ilosc_p);
        dlugosc();
    }

    abstract Plyta modyfikacja();
    abstract Boolean dlplyty(int i);
    abstract void typmenu();
    abstract Vector<Piosenka> modyfikacjalisty();
    String getRodzaj()
    {
        System.out.println(rodzaj) ;
        return rodzaj;
    }
    abstract void setLista(int i);
    abstract void dlPlytyBlad(int i);

    public void dodajP(Piosenka a)
    {
        lista.addElement(a);
    }

    public Vector<Piosenka> getLista()
    {
        return lista;
    }
}
