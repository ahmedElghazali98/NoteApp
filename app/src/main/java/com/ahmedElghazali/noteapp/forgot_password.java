package com.ahmedElghazali.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class forgot_password extends AppCompatActivity {


    EditText emailEt;
    Button forgotPasswordBtn;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        setContentView(R.layout.activity_forgot_password);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
       if (user!=null)
        {
            Intent intent = new Intent(forgot_password.this , MainActivity.class);
            startActivity(intent);
        }

        ImageView forgot_password_back_img = (ImageView) findViewById(R.id.forgot_password_back_img);

         forgotPasswordBtn = (Button) findViewById(R.id.forgorpassword_recoverPass_btn);
        emailEt = findViewById(R.id.forgor_password_email_Et);


        forgot_password_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(getApplicationContext(),singin.class);
                startActivity(n);
            }
        });


        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.sendPasswordResetEmail(emailEt.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent n = new Intent(forgot_password.this,confirmation_msg.class);
                                    startActivity(n);
                                   // Toast.makeText(forgot_password.this, "Check email to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(forgot_password.this, "Fail to send reset password email!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }
        });

    }
}


