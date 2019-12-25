package com.ahmedElghazali.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class silder1 extends AppCompatActivity {

    TextView silder1_skip_Tv;
    Button  silder1_next_btn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_silder1);
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
       if (user!=null)
        {
            Intent intent = new Intent(silder1.this , MainActivity.class);
            startActivity(intent);
        }

        silder1_skip_Tv= (TextView)findViewById(R.id.silder1_skip_Tv);
        silder1_next_btn= (Button)findViewById(R.id.silder1_next_btn);

        silder1_skip_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(silder1.this , Splash.class);
                startActivity(intent);
            }
        });

        silder1_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(silder1.this , silder2.class);
                startActivity(intent);
            }
        });


    }
}
