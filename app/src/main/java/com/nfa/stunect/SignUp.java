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
                SQLHelpers.initConnection();

                    String name = "",lastName ="",email = "",password = "", connection = "", city = "";
                    String id = "";
                    
                        name = ((TextInputEditText)findViewById(R.id.getName)).getEditableText().toString();
                        lastName = ((TextInputEditText)findViewById(R.id.getLastName)).getEditableText().toString();
                        password =  ((EditText)findViewById(R.id.getPassword)).getText().toString();
                        email = ((EditText)findViewById(R.id.GetEmail)).getText().toString();
                        connection = ((Spinner)findViewById(R.id.Countries_Spinner)).getSelectedItem().toString();
                        city = ((EditText)findViewById(R.id.getCity)).getText().toString();
                        Context context = getApplicationContext();

                        if (SQLHelpers.checkIfExists("check email SQL")) { Toast.makeText(context,"email Exists,choose another one !", Toast.LENGTH_LONG).show();
                            SQLHelpers.closeConnection();
                            return;
                        }

                        int set = SQLHelpers.insertIntoDB("Users",id,name,lastName,password,email);
                        System.out.println(set);
                        //Name.setText(set.getString(1));
                        String s= set == 1 ? "Successfull" : "Failed";
                        Toast.makeText(context,"Result -> "+s, Toast.LENGTH_LONG).show();

                        SQLHelpers.closeConnection();
                        Intent intentMain = new Intent(SignUp.this ,
                                MainActivity.class);
                        SignUp.this.startActivity(intentMain);
                        Log.i("Content "," Main layout ");

                }

        });
    }
    }


