package com.nfa.stunect;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.nfa.stunect.logIn;
public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ((TextView)findViewById(R.id.p_name)).setText("Welcome to Stunect "+logIn.currentUser.getName() + " " + logIn.currentUser.getLastName() + " !");
        ((TextView)findViewById(R.id.p_lastName)).setText("We are honored to have you here :).");
        ((TextView)findViewById(R.id.p_email)).setText("Email :  "+logIn.currentUser.getEmail());
        ((TextView)findViewById(R.id.p_pass)).setText("Password :  "+logIn.currentUser.getPassword());
        ((TextView)findViewById(R.id.p_Country)).setText("Country :  "+logIn.currentUser.getCountry());
        ((TextView)findViewById(R.id.p_City)).setText("City :  "+logIn.currentUser.getCity());

    }

}
