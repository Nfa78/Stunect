package com.nfa.stunect;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLHelpers {

    public static Boolean initialized;
    private static Connection connection;
    public static  Boolean initConnection ()
    {
        ConSQL c = new ConSQL();
        connection = null;
        connection = c.connect2DB();
        initialized = connection !=null;
        return  initialized;

    }
    static  void checkCon (){
        if(connection == null)
            initConnection();

    }


    // Checkers
    public static int checkPassword(String email) {
        checkCon ();
        return 1;
    }

    public static Boolean checkIfExists (String statement){
        checkCon ();
       String temp = getColumn(statement);
       return temp == null ? false : true;
    }



    // Getters

    public static List<String> getRow_Columns (String statement) {
        List<String> strings = new ArrayList<String>();
        try {
           strings = getRow_Strings_prvt(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  strings;
    }
    private static List<String> getRow_Strings_prvt (String statement) throws SQLException {
        checkCon ();
        Statement smt = create_Statement();
        ResultSet set =  executeQuery(smt,statement);
        List<String> strings = new ArrayList<String>();
        int i=1;
        while (set.next()) {
            try {
                while (set.getString(i) != null) {
                    strings.add(set.getString(i));
                    i++;
                }
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        }
      return strings;
    }
    public static String getColumn (String statement)  {
        checkCon ();
        Statement smt = create_Statement();
        ResultSet set =  executeQuery(smt,statement);
      String col = null;
      try {
          while (set.next()) {
              col = set.getString(1);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
        return col;
    }

    public static int getCountOfDB (String tableName){
        checkCon ();
        Statement smt = create_Statement();
        String sttmnt = "SELECT COUNT(*) FROM " + tableName +";";
        int count =0;
        String res = getColumn(sttmnt);
        count = Integer.parseInt(res);
        return count;
    }

    // Setters

    // only strings
    public static int insertIntoDB (String tableName,Object... values)
    {
        checkCon ();
        Statement smt = create_Statement();
        String sttmnt = "INSERT INTO " + tableName + " VALUES (";
        for (Object o : values) {
            if(o instanceof String)
           sttmnt = sttmnt.concat("'").concat(o.toString()).concat("'").concat(",");
            else
                sttmnt = sttmnt.concat(o.toString()).concat(",");
        }
        StringBuffer b = new StringBuffer(sttmnt);
        b.deleteCharAt(b.length()-1);
        sttmnt = b.toString();
        sttmnt = sttmnt.concat(");");
        System.out.println(sttmnt);
        int res = 0;
        try {
             res = smt.executeUpdate(sttmnt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  res;
    }

    // Methods executions

    public static void closeConnection ()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement create_Statement (){
        checkCon ();
        Statement smt = null;
        try {
            smt = connection.createStatement();
        } catch (Exception e) {
            Log.e("Error ",e.getMessage());
        }
        return smt;
    }

    public static ResultSet executeQuery (Statement smt,String statement){
        checkCon ();
        ResultSet set = null;
        try {
            set = smt.executeQuery(statement);
        } catch (Exception e) {
            Log.e("Error",e.getMessage());
        }
        return set;
    }


}
