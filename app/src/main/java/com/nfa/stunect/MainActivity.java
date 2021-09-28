package com.nfa.stunect;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btnconnect = (ImageButton)findViewById(R.id.SignUp_Button);
        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(MainActivity.this ,
                        SignUp.class);
                MainActivity.this.startActivity(intentMain);
                Log.i("Content "," Main layout ");


            }
        });
        ImageButton btnconnect2 = (ImageButton)findViewById(R.id.LogIn_Button);
        btnconnect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(MainActivity.this ,
                        logIn.class);
                MainActivity.this.startActivity(intentMain);
                Log.i("Content "," Main layout ");


            }
        });
    }
}