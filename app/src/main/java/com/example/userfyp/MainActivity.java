package com.example.userfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        register.setOnClickListener(this);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.register:
                intent = new Intent(MainActivity.this, registration.class);
                startActivity(intent);
                break;
            case R.id.login:
                intent = new Intent(MainActivity.this, screen.class);
                startActivity(intent);
                break;
        }

    }


}