package com.ahmedElghazali.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class silder2 extends AppCompatActivity {

    TextView silder2_skip_Tv;
    Button  silder2_next_btn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_silder2);
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user!=null)
        {
            Intent intent = new Intent(silder2.this , MainActivity.class);
            startActivity(intent);
        }

        silder2_skip_Tv= (TextView)findViewById(R.id.silder2_skip_Tv);
        silder2_next_btn= (Button)findViewById(R.id.silder2_next_btn);

        silder2_skip_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(silder2.this , Splash.class);
                startActivity(intent);
            }
        });

        silder2_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(silder2.this , Splash.class);
                startActivity(intent);
            }
        });
    }
}
