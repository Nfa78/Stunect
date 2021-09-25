package com.nfa.stunect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.sign_up);
        Button btnconnect = (Button)findViewById(R.id.sign_up_button);
        Spinner spinner = (Spinner)findViewById(R.id.Countries_Spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(SignUp.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Countries));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConSQL c = new ConSQL();
                Connection connection = null;
                connection = c.conClass();
                if(c!=null)
                {
                    String n="",ls="",em="",pas="",Con="",Cit="";
                    int id=0;
                    String sqlGetID = "SELECT Max(uid) FROM Person;";
                    String sqlStatement = "INSERT INTO Person VALUES (";
                    Statement smt = null;
                    try {
                        smt = connection.createStatement();
                    } catch (Exception e) {
                        Log.e("Error ",e.getMessage());
                    }
                    try {
                        ResultSet set = smt.executeQuery(sqlGetID);
                        //Name.setText(set.getString(1));
                        while(set.next())
                        {
                            id = Integer.parseInt(set.getString(1))+1;
                        }
                    } catch (Exception e) {
                        Log.e("Error",e.getMessage());
                    }
                    // insert
                    try {
                        smt = connection.createStatement();
                    } catch (Exception e) {
                        Log.e("Error ",e.getMessage());
                    }
                    try {
                        n = ((TextInputEditText)findViewById(R.id.getName)).getEditableText().toString();
                        ls = ((TextInputEditText)findViewById(R.id.getLastName)).getEditableText().toString();
                        pas =  ((EditText)findViewById(R.id.getPassword)).getText().toString();
                        em = ((EditText)findViewById(R.id.GetEmail)).getText().toString();
                        Con = ((Spinner)findViewById(R.id.Countries_Spinner)).getSelectedItem().toString();
                        Cit = ((EditText)findViewById(R.id.getCity)).getText().toString();
                        Context context = getApplicationContext(); PreparedStatement ps = connection.prepareStatement("SELECT uId FROM Person WHERE email = '"+em+"';");
                        ps.execute();
                        if(ps.getResultSet().next()) { Toast.makeText(context,"email Exists,choose another one !", Toast.LENGTH_LONG).show();
                            connection.close();
                            return;}
                        sqlStatement += Integer.toString(id) + ","+"'" +n+"',"+"'"+ls+"',"+"'"+em+"',"+"'"+pas+"','"+Con+"',"+"'"+Cit+"');";
                        System.out.println(sqlStatement);
                        int set = smt.executeUpdate(sqlStatement);
                        System.out.println(set);
                        //Name.setText(set.getString(1));
                        String s= set == 1 ? "Successfull" : "Failed";
                        Toast.makeText(context,"Result -> "+s, Toast.LENGTH_LONG).show();

                        connection.close();
                        Intent intentMain = new Intent(SignUp.this ,
                                MainActivity.class);
                        SignUp.this.startActivity(intentMain);
                        Log.i("Content "," Main layout ");
                    } catch (Exception e) {
                        Log.e("Error",e.getMessage());
                    }

                }
            }
        });
    }
    }


