package com.nfa.stunect;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.*;
public class ConSQL {
Connection con;
@SuppressLint("NewApi")
public Connection connect2DB ()
{
    String ip ="192.168.1.46",port="1433",db="StunectDB",username ="",pass="";
    StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(a);
    String ConnectURL = null,cnURL="jdbc:jtds:sqlserver://localhost:1433;databasename=StunectDB;";
    try {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ConnectURL = "jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databasename="+db+";";//+"integratedSecurity=true;";//+//"username="+username+";"+"password="+pass+";";
        con = DriverManager.getConnection(ConnectURL,"nfa78","secret123");
    }
    catch (Exception e)
    {
        Log.e("error is : ",e.getMessage());
    }
    return con;
}

}
