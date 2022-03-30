package com.example.userfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class screen extends AppCompatActivity implements View.OnClickListener{

    CardView viewEvent, viewImage, viewFaculty, viewMaterial, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        viewEvent = findViewById(R.id.viewEvent);
        viewFaculty = findViewById(R.id.viewFaculty);
        viewImage = findViewById(R.id.viewImage);
        viewMaterial = findViewById(R.id.viewMaterial);
        about = findViewById(R.id.about);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.viewEvent:
                intent = new Intent(screen.this, com.example.userfyp.ui.notice.noticeFragment.class);
                startActivity(intent);
                break;
            case R.id.viewImage:
                intent = new Intent(screen.this, com.example.userfyp.ui.gallery.galleryFragment.class);
                startActivity(intent);
                break;
            case R.id.viewMaterial:
                intent = new Intent(screen.this, com.example.userfyp.ui.about.aboutFragment.class);
                startActivity(intent);
                break;
            case R.id.viewFaculty:
                intent = new Intent(screen.this, com.example.userfyp.ui.faculty.facultyFragment.class);
                startActivity(intent);
                break;
            case R.id.about:
                intent = new Intent(screen.this, com.example.userfyp.ui.about.aboutFragment.class);
                startActivity(intent);
                break;

        }



    }
}