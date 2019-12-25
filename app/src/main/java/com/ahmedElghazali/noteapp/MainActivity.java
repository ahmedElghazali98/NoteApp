package com.ahmedElghazali.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button logout;
    FirebaseAuth mAuth;
    ImageView createNoteBookimageView;
    TextView main_showAll_Tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        logout= (Button)findViewById(R.id.logout);

        createNoteBookimageView=(ImageView)findViewById(R.id.createNoteBookimageView);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this , silder1.class);
                startActivity(intent);
            }
        });
        main_showAll_Tv=(TextView) findViewById(R.id.main_showAll_Tv);

        main_showAll_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Notebooks.class);
                startActivity(intent);
            }
        });

        createNoteBookimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this , createCategory.class);
                startActivity(intent);
            }
        });
    }
}
