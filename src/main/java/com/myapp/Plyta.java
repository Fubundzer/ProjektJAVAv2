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
    //public:
    /*Plyta(String a, String t,String g, int ip, int d) //throws InterruptedException
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
    }*/

    Piosenka dodawanie()
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
            //Thread.sleep(1000); //throws interruptedexception
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
    abstract String getRodzaj();
    abstract void setLista(int i);
    abstract void dlPlytyBlad(int i);

    /*Plyta modyfikacja()
    {
        Plyta b = this;
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
			{
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
					}
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
    }*/

}
