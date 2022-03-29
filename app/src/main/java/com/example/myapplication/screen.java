package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class screen extends AppCompatActivity implements View.OnClickListener {

    CardView viewEvent, viewImage, viewMaterial, viewFaculty, about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        viewEvent = findViewById(R.id.viewEvent);
        viewImage = findViewById(R.id.viewImage);
        viewFaculty = findViewById(R.id.viewFaculty);
        viewMaterial = findViewById(R.id.viewMaterial);
        about = findViewById(R.id.about);

    }


    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()){
            case R.id.viewEvent:
                intent = new Intent(screen.this, com.example.myapplication.ui.notice.noticeFragment.class);
                startActivity(intent);
                break;
            case R.id.viewImage:
                intent = new Intent(screen.this, com.example.myapplication.ui.gallery.galleryFragment.class);
                startActivity(intent);
                break;
//            case R.id.viewMaterial:
//                intent = new Intent(screen.this, com.example.myapplication.ui.)
        }



    }
}