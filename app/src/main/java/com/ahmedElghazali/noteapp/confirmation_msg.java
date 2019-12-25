package com.ahmedElghazali.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class confirmation_msg extends AppCompatActivity {

    Button confirmation_msg_Btn ;
    ImageView confirmation_msg_close_img ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_confirmation_msg);

        confirmation_msg_close_img=(ImageView) findViewById(R.id.confirmation_msg_close_img);
        confirmation_msg_Btn = (Button) findViewById(R.id.confirmation_msg_Btn);

        confirmation_msg_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });


        confirmation_msg_close_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirmation_msg.this , Splash.class);
                startActivity(intent);
            }
        });


    }
}
