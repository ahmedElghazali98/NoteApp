package com.ahmedElghazali.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class createCategory extends AppCompatActivity {

    TextView createCategory_cancel_Tv;
    Button createCategory_save_btn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_create_category);
        mAuth = FirebaseAuth.getInstance();

        final FirebaseUser user = mAuth.getCurrentUser();

        createCategory_cancel_Tv=(TextView)findViewById(R.id.createCategory_cancel_Tv);
        createCategory_save_btn=(Button)findViewById(R.id.createCategory_save_btn);

        createCategory_cancel_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createCategory.this , MainActivity.class);
                startActivity(intent);
            }
        });

        createCategory_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText title=(EditText) findViewById(R.id.createCategory_title_Et);
                category c = new category();
               c.setTitle(title.getText().toString());
                String id = FirebaseDatabase.getInstance().getReference().child(user.getUid()).child(user.getUid()).child("category").push().getKey();
               c.setId(id);
                FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("category").child(id).setValue(c);
                Toast.makeText(createCategory.this, "Added successfully", Toast.LENGTH_SHORT).show();





            }
        });






    }
}
