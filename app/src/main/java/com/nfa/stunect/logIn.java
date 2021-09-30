package com.nfa.stunect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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

                SQLHelpers.initConnection();

                    String name = "", lastName = "", email = "", password = "";
                    String inputtedPass = "";
                    String sqlStatement;

                        email = ((EditText)findViewById(R.id.set_email)).getText().toString();

                        //Name.setText(set.getString(1));

                        sqlStatement = "SELECT password from Users WHERE Email = '" + email + "';";
                        System.out.println(sqlStatement);
                        password = SQLHelpers.getColumn(sqlStatement);

                        inputtedPass = ((EditText) findViewById(R.id.set_password)).getText().toString();
                        Context context = getApplicationContext();
                        System.out.println(password +email +" " + inputtedPass);

                        if (StringHelpers.String_Cmp_filter_spaces(password,inputtedPass)) {

                            Toast.makeText(context, "Login Successfull", Toast.LENGTH_SHORT).show();
                            sqlStatement = "SELECT Name,Last_Name from Users WHERE Email = '" + email + "';";

                            String con = "" , city = "";

                             List<String> list = SQLHelpers.getRow_Columns(sqlStatement);
                            name = list.get(0);
                            lastName = list.get(1);

                            currentUser = new User(email,name,lastName,email,password,con,city);
                            Intent intentMain = new Intent(logIn.this ,
                                    Profile.class);
                            logIn.this.startActivity(intentMain);

                        } else {
                            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
                        }




            }
        });
    }
}

