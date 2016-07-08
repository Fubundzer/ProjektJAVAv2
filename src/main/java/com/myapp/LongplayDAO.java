package com.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Michał on 07.07.2016.
 */
public class LongplayDAO {

    private static LongplayDAO firstInstance=null;

    private LongplayDAO(){};

    public static LongplayDAO getInstance()
    {
        if (firstInstance==null)
        {
            firstInstance=new LongplayDAO();
        }
        return firstInstance;
    }

    public void load(Katalog k1,Katalog k2,Katalog k3)
    {
        try{

            Class.forName("com.mysql.jdbc.Driver");

            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/music-catalog?autoReconnect=true&useSSL=false","root","qazqwe1234");

            Statement myStmt = mycon.createStatement();
            Statement myStmt2 = mycon.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from longplay");

            int i;
            ResultSet myRs2;
            while(myRs.next())
            {
                Plyta a = new Longplay();
                a.setAutor(myRs.getString("autor"));
                a.setTytul(myRs.getString("tytul"));
                a.setGatunek(myRs.getString("gatunek"));
                a.setIlosc_p(myRs.getInt("ilosc_p"));
                a.setData(myRs.getInt("data"));
                a.wstawTyp(myRs.getString("typ"));
                i = myRs.getInt("idlongplay");
                myRs2 = myStmt2.executeQuery("SELECT longplay_p.* FROM longplay,longplay_p Where longplay.idlongplay=longplay_p.idlongplay AND longplay.idlongplay="+i);
                while(myRs2.next())
                {
                    Piosenka p = new Piosenka();
                    p.setTytulp(myRs2.getString("tytul"));
                    p.setMin(myRs2.getInt("min"));
                    p.setSek(myRs2.getInt("sek"));
                    a.dodajP(p);
                }
                k1.doBazy(a);
            }
            myRs = myStmt.executeQuery("select * from extendedplay");


            while(myRs.next())
            {
                Plyta a = new ExtendedPlay();
                a.setAutor(myRs.getString("autor"));
                a.setTytul(myRs.getString("tytul"));
                a.setGatunek(myRs.getString("gatunek"));
                a.setIlosc_p(myRs.getInt("ilosc_p"));
                a.setData(myRs.getInt("data"));
                a.wstawTyp(myRs.getString("typ"));
                i = myRs.getInt("idextendedplay");
                myRs2 = myStmt2.executeQuery("SELECT extendedplay_p.* FROM extendedplay,extendedplay_p Where extendedplay.idextendedplay=extendedplay_p.idextendedplay AND extendedplay.idextendedplay="+i);
                while(myRs2.next())
                {
                    Piosenka p = new Piosenka();
                    p.setTytulp(myRs2.getString("tytul"));
                    p.setMin(myRs2.getInt("min"));
                    p.setSek(myRs2.getInt("sek"));
                    a.dodajP(p);
                }
                k2.doBazy(a);
            }
            myRs = myStmt.executeQuery("select * from single");

            while(myRs.next())
            {
                Plyta a = new Single();
                a.setAutor(myRs.getString("autor"));
                a.setTytul(myRs.getString("tytul"));
                a.setGatunek(myRs.getString("gatunek"));
                a.setIlosc_p(myRs.getInt("ilosc_p"));
                a.setData(myRs.getInt("data"));
                a.wstawTyp(myRs.getString("typ"));
                i = myRs.getInt("idsingle");
                myRs2 = myStmt2.executeQuery("SELECT single_p.* FROM single,single_p Where single.idsingle=single_p.idsingle AND single.idsingle="+i);
                while(myRs2.next())
                {
                    Piosenka p = new Piosenka();
                    p.setTytulp(myRs2.getString("tytul"));
                    p.setMin(myRs2.getInt("min"));
                    p.setSek(myRs2.getInt("sek"));
                    a.dodajP(p);
                }
                k3.doBazy(a);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void save(Katalog k1,Katalog k2,Katalog k3)
    {
        try{

            Class.forName("com.mysql.jdbc.Driver");

            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/music-catalog?autoReconnect=true&useSSL=false","root","qazqwe1234");

            Statement myStmt = mycon.createStatement();
            Statement myStmt2 = mycon.createStatement();

            myStmt.executeUpdate("delete from longplay_p");
            myStmt.executeUpdate("delete from longplay");
            int i=k1.getDane().size();
            int k,m=0;
            String str,str2;
            for(int j=0;j<i;j++)
            {
                str="insert into longplay (idlongplay,autor,tytul,gatunek,ilosc_p,data,typ) values ('"+(j+1)+"','"+k1.getDane().get(j).getAutor()+
                        "','"+k1.getDane().get(j).getTytul()+"','"+k1.getDane().get(j).getGatunek()+"','"+k1.getDane().get(j).getIloscp()+
                        "','"+k1.getDane().get(j).getRok()+"','"+k1.getDane().get(j).getTyp()+"')";
                myStmt.executeUpdate(str);
                k=k1.getDane().get(j).getIloscp();
                for(int l=0;l<k;l++)
                {
                    m++;
                    str2="insert into longplay_p (idlongplay_p, idlongplay,tytul,min,sek) values ('"+m+"','"+(j+1)+"','"+
                            k1.getDane().get(j).getLista().get(l).getTytulp()+"','"+
                            k1.getDane().get(j).getLista().get(l).getMin()+"','"+
                            k1.getDane().get(j).getLista().get(l).getSek()+"')";
                    myStmt2.executeUpdate(str2);
                }
            }

            myStmt.executeUpdate("delete from extendedplay_p");
            myStmt.executeUpdate("delete from extendedplay");
            i=k2.getDane().size();
            m=0;
            for(int j=0;j<i;j++)
            {
                str="insert into extendedplay (idextendedplay,autor,tytul,gatunek,ilosc_p,data) values ('"+(j+1)+"','"+k2.getDane().get(j).getAutor()+
                        "','"+k2.getDane().get(j).getTytul()+"','"+k2.getDane().get(j).getGatunek()+"','"+k2.getDane().get(j).getIloscp()+
                        "','"+k2.getDane().get(j).getRok()+"')";
                myStmt.executeUpdate(str);
                k=k2.getDane().get(j).getIloscp();
                for(int l=0;l<k;l++)
                {
                    m++;
                    str2="insert into extendedplay_p (idextendedplay_p, idextendedplay,tytul,min,sek) values ('"+m+"','"+(j+1)+"','"+
                            k2.getDane().get(j).getLista().get(l).getTytulp()+"','"+
                            k2.getDane().get(j).getLista().get(l).getMin()+"','"+
                            k2.getDane().get(j).getLista().get(l).getSek()+"')";
                    myStmt2.executeUpdate(str2);
                }
            }

            myStmt.executeUpdate("delete from single_p");
            myStmt.executeUpdate("delete from single");
            i=k3.getDane().size();
            m=0;
            for(int j=0;j<i;j++)
            {
                str="insert into single (idsingle,autor,tytul,gatunek,ilosc_p,data) values ('"+(j+1)+"','"+k3.getDane().get(j).getAutor()+
                        "','"+k3.getDane().get(j).getTytul()+"','"+k3.getDane().get(j).getGatunek()+"','"+k3.getDane().get(j).getIloscp()+
                        "','"+k3.getDane().get(j).getRok()+"')";
                myStmt.executeUpdate(str);
                k=k3.getDane().get(j).getIloscp();
                for(int l=0;l<k;l++)
                {
                    m++;
                    str2="insert into single_p (idsingle_p, idsingle,tytul,min,sek) values ('"+m+"','"+(j+1)+"','"+
                            k3.getDane().get(j).getLista().get(l).getTytulp()+"','"+
                            k3.getDane().get(j).getLista().get(l).getMin()+"','"+
                            k3.getDane().get(j).getLista().get(l).getSek()+"')";
                    myStmt2.executeUpdate(str2);
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
