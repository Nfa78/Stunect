package com.nfa.stunect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class SQLHelpers {

    public static Boolean initialized;
    private static Connection connection;
    public static  int initConnection ()
    {
        ConSQL c = new ConSQL();
        connection = null;
        connection = c.connect2DB();
        initialized = connection !=null;
        return  0;

    }

    // Checkers
    public static int checkPassword(String email) {
        return 1;
    }

    // Getters

    public static List<String> getRow_Strings (String statement)
    {
      return null;
    }

    public static int getCountOfDB (String databaseName){
        return 0;
    }

    // Setters

    public static void insertIntoDB (String databaseName)
    {

    }

    // Methods executions

    public static Statement create_Statement (){
      return null;
    }

    public static ResultSet executeQuery (){
      return null;
    }


}
