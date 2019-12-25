package com.ahmedElghazali.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class createNote extends AppCompatActivity {
    FirebaseAuth mAuth;

    EditText createNore_desc_Et,createNote_title_Et;
    Button createNore_save_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_create_note);
        mAuth = FirebaseAuth.getInstance();

        final FirebaseUser user = mAuth.getCurrentUser();


        createNote_title_Et=(EditText)findViewById(R.id.createNote_title_Et);
        createNore_desc_Et=(EditText)findViewById(R.id.createNore_desc_Et);

        createNore_save_btn=(Button) findViewById(R.id.createNore_save_btn);

        createNore_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note();
                note.setCreatedAt(new Date().getTime());
                note.setLastUpdate(new Date().getTime());
                note.setTitle(createNote_title_Et.getText().toString());
                note.setDesc(createNore_desc_Et.getText().toString());
                String id = FirebaseDatabase.getInstance().getReference().child(user.getUid()).child(user.getUid()).child("category").child(getIntent().getStringExtra("id")).push().getKey();
                note.setId(id);
                FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("category").child(getIntent().getStringExtra("id")).child("Note").child(id).setValue(note);
                Toast.makeText(createNote.this, "Added successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
