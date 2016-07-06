package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
import java.util.Vector;
import java.util.Scanner;

public class Plyta {
    String autor, tytul, gatunek;
    int ilosc_p, data;
    Vector<Piosenka> lista = new Vector<Piosenka>();
    //public:
    Plyta(String a, String t,String g, int ip, int d) //throws InterruptedException
    {
        autor = a;
        tytul = t;
        gatunek = g;
        ilosc_p = ip;
        data = d;
        for (int i = 0; i < ip; i++)
        {
            //lista.push_back(dodawanie());
            try {
                lista.addElement(dodawanie());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    Piosenka dodawanie() throws InterruptedException
    {
        Scanner input=new Scanner(System.in);
        Scanner input2=new Scanner(System.in);
        String t;
        int m, s;
        System.out.print("Wprowadz tytul piosenki: ");
        //cin.sync();
        //getline(cin, t);
        t=input2.nextLine();
        System.out.println("Wprowadz czas trwania piosenki: ");
        System.out.print("MIN: ");
        m=input.nextInt();
        while (m>60||m<0)
        {
            //getZnakDlpError();
            Thread.sleep(1000); //throws interruptedexception
            //cin.clear();
            //cin.sync();
            System.out.print("MIN: ");
            m=input.nextInt();
        }
        System.out.print("SEK: ");
        s=input.nextInt();
        while (s>60||s<0)
        {
            //getZnakDlpError();
            //Sleep(1000);
            //cin.clear();
            //cin.sync();
            System.out.print("SEK: ");
            s=input.nextInt();
        }
        Piosenka a= new Piosenka(t, m, s);
        return a;
    };
    int dlugosc()
    {
        int czas = 0;
        for (int i = 0; i < ilosc_p; i++)
        {
            czas += lista.get(i).getDl();
        }
        return czas;
    };
    int get_dlugosc()
    {
        int czas = 0;
        for (int i = 0; i < ilosc_p; i++)
        {
            czas += lista.get(i).getDl();
        }
        System.out.println("Dlugosc plyty to: "+czas / 60+"MIN "+czas % 60+"SEK");
        return czas;
    };
    void disp()
    {

    };
    Vector<Piosenka> modyfikacjalisty()
    {
        return lista;
    };
    void modl(int i, Piosenka a)
    {
        //	lista[i] = a;
        lista.set(i, a);
    }
    void wypisywaniep()
    {
        for (int i = 0; i < ilosc_p; i++)
        {
            System.out.print(i + 1+". ");
            //lista[i].disp();
            lista.get(i).disp();
        }
    };
    String get_lista()
    {
        String a = "";
        for (int i = 0; i < ilosc_p; i++)
        {
            a += lista.get(i).getTytulp() + "\n";
            //a += to_string(lista.get(i).getDl() / 60) + "\n";
            //a += to_string(lista.get(i).getDl() % 60) + "\n";
            a += (lista.get(i).getDl() / 60) + "\n";
            a += (lista.get(i).getDl() % 60) + "\n";
            //przetestowac
        }
        return a;
    };
    String get_autor()
    {
        return autor;
    };
    String get_tytul()
    {
        return tytul;
    };
    String get_gatunek()
    {
        return gatunek;
    };
    int get_rok()
    {
        return data;
    };
    int get_iloscp()
    {
        return ilosc_p;
    }

    void typmenu()
    {
        System.out.println("");
    };
	/*int wyszukiwanie()
	{
		int i=1;
		Scanner input=new Scanner(System.in);
		while (i != 0)
		{
			//system("cls");
			System.out.println("Wybierz kategorie wyszukiwania.");
			System.out.println("1. Autor.");
			System.out.println("2. Tytul.");
			System.out.println("3. Gatunek.");
			System.out.println("4. Rok wydania.");
			System.out.println("5. Ilosc piosenek.");
			System.out.println("6. Minimalna dlugosc.");
			System.out.println("0. Zakoncz wyszukiwanie.");
			i=input.nextInt();
			return i;
			/*if (cin.fail())
			{
				getZnakError();
				Sleep(1000);
				cin.clear();
				cin.sync();
			}*/
    //else
			/*
				switch (i)
				{
				case 1:
					return i;
					//break;
				case 2:
					return i;
					//break;
				case 3:
					return i;
					//break;
				case 4:
					return i;
					//break;
				case 5:
					return i;
					//break;
				case 6:
					return i;
					//break;
				case 0:
					return i;
					//break;
				default:
					//getZlaOpcja();
					//Sleep(1000);
					break;
				}

		}
	};*/
}
