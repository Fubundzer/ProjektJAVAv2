package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
import java.util.Vector;
import java.util.Scanner;

public class Longplay extends Plyta{

    String r = "Longplay";
    //Longplay(){};

    Longplay(String a, String t,String g, int ip, int d) //throws InterruptedException
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

    Longplay(String a, String t,String g, int ip, int d, Vector <Piosenka> v)
    {
        autor = a;
        tytul = t;
        gatunek = g;
        ilosc_p = ip;
        data = d;
        lista=v;
    }

    Longplay(Longplay longplay)
    {
        autor = longplay.autor;
        tytul = longplay.tytul;
        gatunek = longplay.gatunek;
        ilosc_p = longplay.ilosc_p;
        data = longplay.data;
        lista = longplay.lista;
    }

    //virtual void disp();

    void disp()
    {
        System.out.println("Autor plyty: "+autor);
        System.out.println("Tytul plyty: "+tytul);
        System.out.println("Rok wydania: "+data);
        System.out.println("Gatunek: "+gatunek);
        System.out.println("Rodzaj: "+r);
        System.out.println("Ilosc piosenek: "+ilosc_p);
        dlugosc();
    }

    Longplay modyfikacja()
    {
        Longplay b = this;
        String a;
        Scanner input = new Scanner(System.in);
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
            i=input.nextInt();
			/*if (cin.fail())
			{
				getZnakError();
				Sleep(1000);
				cin.clear();
				cin.sync();
			}
			else
			{*/
            switch (i){
                case 1:
                    System.out.println("Wprowadz nowego autora plyty:");
                    //cin.sync();
                    //getline(cin, a);
                    a=input.nextLine();
                    b.autor = a;
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 2:
                    System.out.println("Wprowadz nowy tytul plyty:");
                    //cin.sync();
                    //getline(cin, tytul);
                    tytul=input.nextLine();
                    b.tytul = tytul;
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 3:
                    System.out.println("Wprowadz nowy rok wydania plyty:");
                    data=input.nextInt();
					/*while (cin.fail())
					{
						getZnakError();
						Sleep(1000);
						cin.clear();
						cin.sync();
						cout << "Wprowadz nowy rok wydania plyty:" << endl;
						cin >> data;
					}*/
                    b.data = data;
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 4:
                    System.out.println("Wprowadz nowy gatunek plyty:");
                    //cin.sync();
                    //getline(cin, a);
                    a=input.nextLine();
                    b.gatunek = a;
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 5:
                    b.lista = modyfikacjalisty();
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 0:
                    System.out.println("Powrot do menu.");
                    //Sleep(1000);
                    //system("cls");
                    break;
                default:
                    //getZlaOpcja();
                    //Sleep(1000);
                    //system("cls");
                    break;
            }
        }

        return b;
    }

    String get_r()
    {
        return r;
    }

    //bool operator ==(const Longplay &l);

    Vector<Piosenka> modyfikacjalisty()
    {
        Piosenka a;
        int i = 1, j = 0;
        Scanner input = new Scanner(System.in);
        while (i != 0)
        {
            //system("cls");
            System.out.println("Co chcesz zrobic?");
            System.out.println("1. Dodac piosenke.");
            System.out.println("2. Usunac piosenke.");
            System.out.println("3. Zmodyfikowac piosenke.");
            System.out.println("0. Zakonczyc modyfikacje.");
            i=input.nextInt();
			/*if (cin.fail())
			{
				getZnakError();
				Sleep(1000);
				cin.clear();
				cin.sync();
			}
			else
			{*/
            switch (i)
            {
                case 1:
                    //this->lista.push_back(dodawanie());
                    try
                    {
                        lista.addElement(dodawanie());
                    }
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                    ilosc_p++;
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 2:
                    if (ilosc_p == 0)
                    {
                        //getBrakPzError();
                        //Sleep(1000);
                    }
                    else
                    {
                        System.out.println("Ktora piosenke chcesz usunac?");
                        wypisywaniep();
                        j=input.nextInt();
                        while (j > ilosc_p || j < 1)
                        {
                            //getZnakDlError();
                            //Sleep(1000);
                            //cin.clear();
                            //cin.sync();
                            System.out.println("Ktora piosenke chcesz usunac?");
                            j=input.nextInt();
                        }
                        //this->lista.erase(lista.begin() + j - 1);
                        //this->ilosc_p--;
                        lista.remove(j-1);
                        ilosc_p--;
                    }
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 3:
                    System.out.println("Ktora piosenke chcesz zmodyfikowac?");
                    wypisywaniep();
                    j=input.nextInt();
                    while (j>ilosc_p||j<1)
                    {
                        //getZnakDlError();
                        //Sleep(1000);
                        //cin.clear();
                        //cin.sync();
                        System.out.println("Ktora piosenke chcesz zmodyfikowac?");
                        j=input.nextInt();
                    }
                    a = lista.get(j-1).modyfikacja();
                    modl(j - 1, a);
                    //Sleep(1000);
                    //system("cls");
                    break;
                case 0:
                    System.out.println("Zakonczono modyfikacje");
                    //Sleep(1000);
                    //system("cls");
                    break;
                default:
                    //getZlaOpcja();
                    //Sleep(1000);
                    //system("cls");
                    break;
            }
        }
        //}
        return lista;
    }

    //bool iloscp(int i){ return true; };

    Boolean dlplyty()
    {
        return true;
    }

    void typmenu()
    {
        System.out.println("Katalog plyt typu Longplay. Co chcesz zrobic?");
    }
}
