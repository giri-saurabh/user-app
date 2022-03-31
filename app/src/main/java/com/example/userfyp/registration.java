package com.example.userfyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.regex.Pattern;

public class registration extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private EditText fullname, email, age, password;
    private TextView header;
    private ImageView logo;
    private Button regBtn;
    ProgressBar pd;
    private DatabaseReference reference;
    private StorageReference storageReference;



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
            password.setError("Password cannot be empty");
            password.requestFocus();
        }else if (Patterns.EMAIL_ADDRESS.matcher(regEmail).matches()){
            email.setError("Email already in use");
            email.requestFocus();
        }else if (password.length() < 6){
            password.setError("Password must be minimum 6-characters long");
            password.requestFocus();
            return;
        }

        pd.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(regEmail,regPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            registeredUser user = new registeredUser(fullname, age, email);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }
}