package com.ahmedElghazali.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class listNotes extends AppCompatActivity {
    FirebaseAuth mAuth   = FirebaseAuth.getInstance();

    ImageView listNotes_create_btn;
    RecyclerView notesList_rv;
    NoteAdapter noteAdapter;
    FirebaseUser user= mAuth.getCurrentUser();

    List<Note> noteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_list_notes);

        listNotes_create_btn=(ImageView)findViewById(R.id.listNotes_create_btn);
        initData();


        notesList_rv = findViewById(R.id.notesList_rv);
        notesList_rv.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(this ,noteList);
        notesList_rv.setAdapter(noteAdapter);
        listNotes_create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = getIntent().getStringExtra("id");
                String title = getIntent().getStringExtra("title");
                Intent intent = new Intent(listNotes.this,createNote.class);
                intent.putExtra("id", id);
                intent.putExtra("Title", title);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("category").child(getIntent().getStringExtra("id")).child("Note")
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        noteList.clear();
                      //  ca();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren() ){

                            Note c = snapshot.getValue(Note.class);
                            noteList.add(c);

                        }
                        noteAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }



    void ca(){
        noteList.add(new Note("a","title","d",33333,333));
        noteList.add(new Note("a","title","d",33333,333));
        noteList.add(new Note("a","title","d",33333,333));
        noteList.add(new Note("a","title","d",33333,333));
    }
}
