package com.example.userfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private EditText fullname, email, age, password;
    private TextView header;
    private ImageView logo;
    private Button regBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        password = findViewById(R.id.password);

        regBtn = findViewById(R.id.regBtn);
        regBtn.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.regBtn:
                regUser();
        }



    }

    private void regUser() {
        String regEmail = email.getText().toString().trim();
        String regName = fullname.getText().toString().trim();
        String regPassword = password.getText().toString().trim();
        String regAge = age.getText().toString().trim();
        if (regName.isEmpty()){
            fullname.setError("This field cannot be empty");
            fullname.requestFocus();
        }else if( regEmail.isEmpty() ){
            email.setError("This field cannot be empty");
            email.requestFocus();
        }else if ( regAge.isEmpty()){
            age.setError("Please specify your age");
            age.requestFocus();
        }else if( regPassword.isEmpty()){
            password.setError("Password has to be 6-character long");
            password.requestFocus();
        }else{


        }
    }
}