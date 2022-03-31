package com.example.userfyp;

import android.widget.EditText;

public class registeredUser {

    public String fullname, age, email;

    public registeredUser(EditText fullname, EditText age, EditText email){

    }

    public registeredUser(String fullname, String age, String email){
        this.fullname = fullname;
        this.age = age;
        this.email = email;
    }

}
