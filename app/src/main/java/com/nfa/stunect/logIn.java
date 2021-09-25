package com.nfa.stunect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class logIn extends AppCompatActivity {
    public static User currentUser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        Button btnconnect = (Button) findViewById(R.id.Log_in_Button);
        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConSQL c = new ConSQL();
                Connection connection = null;
                connection = c.conClass();
                if (c != null) {
                    String n = "", ls = "", em = "", pas = "";
                    String inputtedPass = "";
                    int id = 0;
                    String sqlGetID = "SELECT uID FROM Person WHERE email = "  +"'"+em+"'" + ";";
                    String sqlStatement = "SELECT password from Person WHERE uID = " + id + ";";
                    Statement smt = null;
                    try {
                        smt = connection.createStatement();
                    } catch (Exception e) {
                        Log.e("Error ", e.getMessage());
                    }
                    try {
                        em = ((EditText)findViewById(R.id.set_email)).getText().toString();
                        sqlGetID = "SELECT uID FROM Person WHERE email = "  +"'"+em+"'" + ";";
                        ResultSet set = smt.executeQuery(sqlGetID);
                        //Name.setText(set.getString(1));
                        //id = Integer.parseInt(set.getString(1));
                        while (set.next()) {
                            id = Integer.parseInt(set.getString(1));
                        }
                        sqlStatement = "SELECT password from Person WHERE uID = " + Integer.toString(id) + ";";
                        System.out.println(sqlStatement);
                        smt = connection.createStatement();
                        set = smt.executeQuery(sqlStatement);
                        //pas = (set.getString(4));
                        while (set.next()) {
                            pas = (set.getString(1));
                        }
                        inputtedPass = ((EditText) findViewById(R.id.set_password)).getText().toString();
                        Context context = getApplicationContext();
                        System.out.println(pas +id +" " + inputtedPass);
                        if (pas.trim().replaceAll("\\s+", " ").equalsIgnoreCase(inputtedPass.trim().replaceAll("\\s+", " "))) {
                            Toast.makeText(context, "Login Successfull", Toast.LENGTH_SHORT).show();
                            sqlStatement = "SELECT firstName,lastName,Country,City from Person WHERE uID = " + Integer.toString(id) + ";";
                            smt = connection.createStatement();
                            set = smt.executeQuery(sqlStatement);
                            String con="",cit="";
                            while (set.next()) {
                                n = (set.getString(1));
                                ls = (set.getString(2));
                                con = (set.getString(3));
                                cit = (set.getString(4));
                            }
                            currentUser = new User(id,n,ls,em,pas,con,cit);
                            Intent intentMain = new Intent(logIn.this ,
                                    Profile.class);
                            logIn.this.startActivity(intentMain);
                        } else {
                            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                        smt.close();

                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }

                }
            }
        });
    }
}

