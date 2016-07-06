package com.myapp;

/**
 * Created by Michał on 06.07.2016.
 */
import java.util.Scanner;
import java.util.Vector;

public class Katalog {

    Vector <Plyta> dane=new Vector<Plyta>();
    String typ;
    PlytaFactory factory = new PlytaFactory();

    Katalog(String typ)
    {
        this.typ=typ;
    };

    Katalog(Vector <Plyta> dane,String typ)
    {
        this.dane=dane;
        this.typ=typ;
    };
    Katalog(Katalog katalog)
    {
        dane = katalog.dane;
        typ=katalog.typ;
    }
    //Katalog operator +(const TYP &d);
    //Katalog operator +(const Katalog<TYP> &d);
    //	Katalog usuwanie();
    //	Katalog czyszczenie();
    //	Katalog wstawianie();
    //	Katalog wstawianietab();
    //	TYP get_value(int i);
    //	void mod(TYP d, int a);
    //	int dlugosc();
    //	void display();
    //	void wszysukiwaniek();
    //	void zapis();
    //	void odczyt();

	/*template <class T> T dodawaniavec();
	template <class T> T dodawaniavec(T a);
	template <class T> Katalog<T> menu(Katalog <T> dane);
	template <class T> void domenu();

	template <class TYP>
	Katalog<TYP> Katalog<TYP>::operator +(const TYP & d)
	{
		dane.push_back(d);
		return *this;
	}*/

    Katalog usuwanie()
    {
        Scanner input = new Scanner(System.in);
        int i;
        char a = 'a';
        if (dane.size() == 0)
        {
            //getBrakPzError();
            //Sleep(1000);
        }
        else
        {
            System.out.print("Podaj numer albumu, ktory chcesz usunac: ");
            i=input.nextInt();
            while (i > dane.size() || i < 1)
            {
                //	getZnakDlError();
                //Sleep(1000);
                //	cin.clear();
                //cin.sync();
                System.out.print("Podaj numer albumu, ktory chcesz usunac: ");
                i=input.nextInt();
            }
            while (a != 'y' && a != 'Y' && a != 'n' && a != 'N')
            {
                System.out.println("Jestes pewna/y? Y/N");
                a=input.next().charAt(0);
                switch (a){
                    case 'y':
                        //dane.erase(dane.begin() + i - 1);
                        dane.remove(i-1);
                        System.out.println("Album usuniety.");
                        //Sleep(1000);
                        break;
                    case 'Y':
                        //dane.erase(dane.begin() + i - 1);
                        dane.remove(i-1);
                        System.out.println("Album usuniety.");
                        //Sleep(1000);
                        break;
                    case 'n':
                        System.out.println("Nie usunieto albumu.");
                        //Sleep(1000);
                        break;
                    case 'N':
                        System.out.println("Nie usunieto albumu.");
                        //Sleep(1000);
                        break;
                    default:
                        //getZlaOpcja();
                        //Sleep(1000);
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
                    //Sleep(1000);
                    break;
                case 'Y':
                    dane.clear();
                    System.out.println("Katalog wyczyszczony.");
                    //Sleep(1000);
                    break;
                case 'n':
                    System.out.println("Nie wyczyszczono katalogu.");
                    //Sleep(1000);
                    break;
                case 'N':
                    System.out.println("Nie wyczyszczono katalogu.");
                    //Sleep(1000);
                    break;
                default:
                    //getZlaOpcja();
                    //Sleep(1000);
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
        i=input.nextInt();
        while (i>dane.size()+1||i<1)
        {
            //getZnakDlError();
            //Sleep(1000);
            //cin.clear();
            //cin.sync();
            System.out.println("W ktore miejsce chcesz wstawic nowy album?");
            i=input.nextInt();
        }
        if (i == dane.size() + 1)
        {
            //dane.push_back(dodawaniavec<TYP>());
            dane.addElement(dodawaniavec());
        }
        else
            //dane.insert(dane.begin() + i - 1, dodawaniavec<TYP>());
            dane.insertElementAt(dodawaniavec(), i-1);
        return this;
    }

    //template <class TYP>
    Katalog wstawianietab()
    {
        Scanner input = new Scanner(System.in);
        int i, j;
        Plyta tab[];
        System.out.println("Ile albumow chcesz wstawic?");
        i=input.nextInt();
        /*while (cin.fail())
        {
            getZnakError();
            Sleep(1000);
            cin.clear();
            cin.sync();
            cout << "Ile albumow chcesz wstawic?" << endl;
            cin >> i;
        }*/
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


    //	template <class TYP>
    Plyta get_value(int i)
    {
        return dane.get(i);
    }

    //	template <class TYP>
    void mod(Plyta d, int a)
    {
        //dane[a - 1] = d;
        dane.set(a,d);
    }

    //	template <class TYP>
    int dlugosc()
    {
        return dane.size();
    }

    //	template <class TYP>
    void display()
    {
        for (int i = 0; i < dane.size(); i++)
        {
            System.out.print((i + 1)+". ");
            dane.get(i).disp();
        }
    }

    //	template <class TYP>
    /*Katalog<TYP> Katalog<TYP>::operator +(const Katalog<TYP> & d)
    {
        for (int i = 0; i < d.dlugosc(); i++)
        {
            dane[i] = dodawaniavec<TYP>(d.get_value(i));
        }
        return *this;
    }*/

    //	template <class TYP>
   /* void Katalog<TYP>::zapis()
    {
        string nazwa = dane[0].get_r() + ".txt";
        string nazwa2 = dane[0].get_r() + "listap.txt";
        ofstream f(nazwa);
        ofstream f2(nazwa2);
        for (int i = 0; i <dane.size(); i++)
        {
            f<<"Plyta\n" <<dane[i].get_autor() << "\n" << dane[i].get_tytul() << "\n" <<dane[i].get_gatunek()<< "\n" << dane[i].get_rok() << "\n" << dane[i].get_iloscp() << '\n';
            f2<<"Lista\n" << dane[i].get_lista();
        }

    }

    //	template <class TYP>
    void Katalog<TYP>::odczyt()
    {
        TYP a;
        string linia;
        string nazwa = a.get_r() + ".txt";
        string nazwa2 = a.get_r() + "listap.txt";
        ifstream dat(nazwa);
        ifstream dat2(nazwa2);
        string autor;
        string tytul;
        string gatunek,r,ipp,min,sek;
        int rok;
        int ip;
        string n;
        int m, s, x = 0, y;
        vector<Piosenka> lista;
        dane.clear();
        while (getline(dat,linia))
        {
            if (linia == "Plyta")
            {
                getline(dat, autor);
                getline(dat, tytul);
                getline(dat, gatunek);
                getline(dat, r);
                rok = stoi(r, nullptr);
                getline(dat, ipp);
                ip = stoi(ipp, nullptr);
                while (getline(dat2,linia))
                {
                    if (linia == "Lista")
                    {
                        for (y = 0; y < ip * 3; y++)
                        {
                            getline(dat2, n);
                            getline(dat2, min);
                            m = stoi(min, nullptr);
                            getline(dat2, sek);
                            s = stoi(sek, nullptr);
                            Piosenka a(n, m, s);
                            lista.push_back(a);
                        }
                    }
                }
                TYP b(autor, tytul, gatunek, ip, rok, lista);
                dane.push_back(b);
            }
        }
    }*/

    //	template <class TYP>
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
            i=input.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Wprowadz autora.");
                    a=input2.nextLine();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getAutor().equals(a)) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                        }
                    }
                    //Sleep(1000);
                    break;
                case 2:
                    System.out.println("Wprowadz tytul.");
                    a=input2.nextLine();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getTytul().equals(a)) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                        }
                    }
                    //Sleep(1000);
                    break;
                case 3:
                    System.out.println("Wprowadz gatunek.");
                    a=input2.nextLine();
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getGatunek().equals(a)) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                        }
                    }
                    //Sleep(1000);
                    break;
                case 4:
                    System.out.println("Wprowadz rok.");
                    r=input.nextInt();
                    /*while (cin.fail()) {
                        getZnakError();
                        Sleep(1000);
                        cin.clear();
                        cin.sync();
                        cout << "Wprowadz rok." << endl;
                        cin >> r;
                    }*/
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getRok() == r) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                        }
                    }
                    //Sleep(1000);
                    break;
                case 5:
                    System.out.println("Wprowadz ilosc piosenek.");
                    r=input.nextInt();
                    /*while (cin.fail()) {
                        getZnakError();
                        Sleep(1000);
                        cin.clear();
                        cin.sync();
                        cout << "Wprowadz ilosc piosenek." << endl;
                        cin >> r;
                    }*/
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getIloscp() == r) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                        }
                    }
                    //Sleep(1000);
                    break;
                case 6:
                    System.out.println("Wprowadz minimalna dlugosc plyty (MIN).");
                    r=input.nextInt();
                    /*while (cin.fail()) {
                        getZnakError();
                        Sleep(1000);
                        cin.clear();
                        cin.sync();
                        cout << "Wprowadz minimalna dlugosc plyty (MIN)." << endl;
                        cin >> r;
                    }*/
                    for (j = 0; j < dane.size(); j++) {
                        if (dane.get(j).getDlugosc() >= r * 60) {
                            System.out.print((j + 1)+". ");
                            dane.get(j).disp();
                        }
                    }
                    //Sleep(1000);
                    break;
                case 0:
                    System.out.println("Zakonczono wyszukiwanie.");
                    //Sleep(1000);
                    break;
                default:
                    //getZlaOpcja();
                    //Sleep(1000);
                    break;
            }
        }
    }

    //template <class T> T dodawaniavec()
    Plyta dodawaniavec()
    {
        Plyta a= factory.makePlyta(typ);
        a.getRodzaj();
        Scanner input = new Scanner(System.in);
        String autor, tytul,gatunek;
        int ilosc_p, data,i=0;
        System.out.println("Podaj autora plyty: ");
        //cin.sync();
        //getline(cin, autor);
        autor=input.nextLine();
        System.out.println("Podaj tytul plyty: ");
        //cin.sync();
        //getline(cin, tytul);
        tytul=input.nextLine();
        System.out.println("Podaj gatunek plyty: ");
        //cin.sync();
        //getline(cin, gatunek);
        gatunek=input.nextLine();
        System.out.println("Podaj ilosc piosenek: ");
        ilosc_p=input.nextInt();
        if(a.dlplyty(ilosc_p))
        {
            a.dlPlytyBlad(1);
            return null;
        }
		/*while (cin.fail())
		{
			getZnakError();
			Sleep(1000);
			cin.clear();
			cin.sync();
			cout << "Wprowadz ilosc piosenek." << endl;
			cin >> ilosc_p;
		}*/
        System.out.println("Podaj rok wydania plyty: ");
        data=input.nextInt();
		/*while (cin.fail())
		{
			getZnakError();
			Sleep(1000);
			cin.clear();
			cin.sync();
			cout << "Wprowadz rok wydania plyty." << endl;
			cin >> data;
		}*/
        a.setAutor(autor);
        a.setTytul(tytul);
        a.setGatunek(gatunek);
        a.setLista(ilosc_p);
        a.setData(data);
        return a;
    }

   /* template <class T> T dodawaniavec(T a)
    {
        return a;
    }*/

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
        Plyta x;
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
            System.out.println("8. Zapisz baze katalogu.");
            System.out.println("9. Wczytaj baze katalogu.");
            System.out.println("10. Wyswietl informacje o plytach.");
            System.out.println("0. Powrot do menu.");

            a=input.nextInt();
            /*if (cin.fail())
            {
                getZnakError();
                Sleep(1000);
                cin.clear();
                cin.sync();
            }
            else
            {
                system("cls");*/
                switch (a)
                {
                    case 1:
                        //dane + dodawaniavec<T>();
                        //dane.add(dodawaniavec());
                      //  Plyta cos = dodawaniavec();
                        catalog.dane.addElement(dodawaniavec());
                        if(catalog.dane.get(dane.size()-1).dlplyty(catalog.dane.get(dane.size()-1).getIloscp()))
                        {
                            dane.remove(dane.size()-1);
                        }
                        //Sleep(1000);
                        //system("cls");
                        break;
                    case 2:
                        catalog.display();
                        catalog=catalog.usuwanie();
                        //dane = dane.usuwanie();
                        //this=this.usuwanie();
                        //system("cls");
                        break;
                    case 3:
                        //dane = dane.czyszczenie();
                        catalog=catalog.czyszczenie();
                        //system("cls");
                        break;
                    case 4:
                        catalog.display();
                        System.out.println("Ktory album chcesz modyfikowac?");
                        b=input.nextInt();
                        while (b>catalog.dlugosc()||b<1)
                        {
                            //getZnakDlError();
                            //Sleep(1000);
                            //cin.clear();
                            //cin.sync();
                            System.out.println("Ktory album chcesz modyfikowac?");
                            b=input.nextInt();
                        }
                        catalog.mod(catalog.get_value(b - 1).modyfikacja(), b-1);
                        //Sleep(1000);
                        //system("cls");
                        break;
                    case 5:
                        catalog.display();
                        catalog.wstawianie();
                        //Sleep(1000);
                        //system("cls");
                        break;
                    case 6:
                        catalog.wstawianietab();
                        //Sleep(1000);
                        //system("cls");
                        break;
                    case 7:
                        catalog.wszysukiwaniek();
                        //Sleep(1000);
                        //system("cls");
                        break;
                    /*case 8:
                        dane.zapis();
                        Sleep(1000);
                        system("cls");
                        break;
                    case 9:
                        dane.odczyt();
                        Sleep(3000);
                        system("cls");
                        break;*/
                    case 10:
                        catalog.display();
                        //Sleep(3000);
                        //system("cls");
                        break;
                    case 0:
                        break;
                    default:
                        //getZlaOpcja();
                        //Sleep(1000);
                        //system("cls");
                        break;
                }
            }
            //system("cls");
        return catalog;
        }
}


