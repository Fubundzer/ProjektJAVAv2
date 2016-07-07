package com.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Michał on 07.07.2016.
 */
public class LongplayDAO {

    public void save()
    {
        try{

            Class.forName("com.mysql.jdbc.Driver");

            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/music-catalog","root","qazqwe1234");

            Statement myStmt = mycon.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from longplay");

            while(myRs.next())
            {
                System.out.println(myRs.getString("autor")+","+myRs.getString("tytul"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
