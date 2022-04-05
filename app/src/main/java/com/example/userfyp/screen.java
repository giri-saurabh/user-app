package com.example.userfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class screen extends AppCompatActivity implements View.OnClickListener{

    CardView viewEvent, viewImage, viewFaculty, viewMaterial, about;
    private Button logoutBtn;
    private String name, email, age;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        viewEvent = findViewById(R.id.viewEvent);
        viewFaculty = findViewById(R.id.viewFaculty);
        viewImage = findViewById(R.id.viewImage);
        viewMaterial = findViewById(R.id.viewMaterial);
        about = findViewById(R.id.about);
        logoutBtn = findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(screen.this, MainActivity.class));
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user == null){

            startActivity(new Intent(this, MainActivity.class));
            finish();

        }
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