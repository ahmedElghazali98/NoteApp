package com.ahmedElghazali.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Notebooks extends AppCompatActivity {
    FirebaseAuth mAuth   = FirebaseAuth.getInstance();


    ImageView notebook_add_imageView;
    ImageView notebooks_back_imageView;
    RecyclerView recyclerViewCategory;
    GridLayoutManager gridLayoutManager;
    List<category> categoryList =new ArrayList<>();
    List<category> categorylist =new ArrayList<>();
    categoryAdapter cAdapter;
     FirebaseUser user= mAuth.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_notebooks);

        notebook_add_imageView=(ImageView) findViewById(R.id.notebook_add_imageView);
        notebooks_back_imageView=(ImageView) findViewById(R.id.notebooks_back_imageView);

        notebooks_back_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notebooks.this , MainActivity.class);
                startActivity(intent);
            }
        });

        notebook_add_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notebooks.this , createCategory.class);
                startActivity(intent);

            }
        });


        initData();

        recyclerViewCategory=(RecyclerView) findViewById(R.id.recyclerViewCategory);

        gridLayoutManager = new GridLayoutManager(Notebooks.this,3);
        recyclerViewCategory.setHasFixedSize(true);
        recyclerViewCategory.setLayoutManager(gridLayoutManager);

         cAdapter = new categoryAdapter(Notebooks.this,categoryList);
        recyclerViewCategory.setAdapter(cAdapter);

    }

    private void initData() {
        FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("category")
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        categoryList.clear();
                                                                                                                                                                            //  ca();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren() ){

                            category c = snapshot.getValue(category.class);
                            categoryList.add(c);

                        }
                        cAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }

  void  ca(){
      categoryList.add(new category("-LwyjwrBRUqHb1B-uU73","Home"));
      categoryList.add(new category("Lwwqn_x9Y28bjvWZHTy","Title"));
      categoryList.add(new category("f","Book"));
      categoryList.add(new category("1","HCI"));
      categoryList.add(new category("f","SD"));
    }
}
