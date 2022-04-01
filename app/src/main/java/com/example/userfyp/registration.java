package com.example.userfyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.regex.Pattern;

public class registration extends AppCompatActivity{

    private EditText regName, regAge, regEmail, regPassword;
    private Button regBtn;
    private TextView header;
    private ImageView logo;

    private FirebaseAuth auth;

    private String name, age, email, pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        auth = FirebaseAuth.getInstance();

        regName = findViewById(R.id.regName);
        regAge = findViewById(R.id.regAge);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        regBtn = findViewById(R.id.regBtn);
        header = findViewById(R.id.header);
        regBtn.setOnClickListener((View.OnClickListener) this);

        regBtn.setOnClickListener((view) -> { validateUser(); });

        header.setOnClickListener((view) -> {
            startActivity(new Intent(registration.this, MainActivity.class));
            finish();
        });
    }

    private void validateUser() {
        
        name = regName.getText().toString();
        email = regEmail.getText().toString();
        age = regAge.getText().toString();
        pass = regPassword.getText().toString();
        
        if (name.isEmpty() || email.isEmpty() || age.isEmpty() || pass.isEmpty()){
            
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            
        }else{
            registerUser();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() != null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    private void registerUser() {

        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(registration.this, "User created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(registration.this, MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(registration.this, "Error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


}