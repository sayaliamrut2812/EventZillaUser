package com.example.eventzillauser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Browse_Category extends AppCompatActivity {
ImageButton b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse__category);

        b1=(ImageButton)findViewById(R.id.tech);
        b2=(ImageButton)findViewById(R.id.culture);
        b3=(ImageButton)findViewById(R.id.business);
        b4=(ImageButton)findViewById(R.id.Music);
        b5=(ImageButton)findViewById(R.id.Social);
        b6=(ImageButton)findViewById(R.id.photo);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Browse_Category.this,showevent.class);
                startActivity(i1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Browse_Category.this,showevent.class);
                startActivity(i2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Browse_Category.this,showevent.class);
                startActivity(i3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(Browse_Category.this,showevent.class);
                startActivity(i4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Browse_Category.this,showevent.class);
                startActivity(i5);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(Browse_Category.this,showevent.class);
                startActivity(i6);
            }
        });
    }
}
