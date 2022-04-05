package com.example.userfyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText logEmail, logPass;
    private Button login, register;
    private String email, pass;

    FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logEmail = findViewById(R.id.logEmail);
        logPass = findViewById(R.id.logPass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);


        auth = FirebaseAuth.getInstance();

        login.setOnClickListener((view)-> {
            validateUser();
        });

        register.setOnClickListener((view) -> {
            startActivity(new Intent(MainActivity.this, registration.class));
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() != null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    private void validateUser() {

        email = logEmail.getText().toString();
        pass = logPass.getText().toString();

        if (email.isEmpty() || pass.isEmpty()){

            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();

        }else{

            loginUser();

        }

    }

    private void loginUser() {

        auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, screen.class));
                            finish();
                        }else {
                            Toast.makeText(MainActivity.this, "Error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}

