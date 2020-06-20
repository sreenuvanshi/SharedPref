package com.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //create objects
        final EditText emailObj = findViewById(R.id.editEmail);
        final EditText passwordObj = findViewById(R.id.editPassword);
        Button btnLoginObj = findViewById(R.id.btnLogin);
        final CheckBox checkRememberMeObj = findViewById(R.id.checkRememberMe);

        //button click
        btnLoginObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get content
                String email = emailObj.getText().toString();
                String password = passwordObj.getText().toString();
                boolean checkState = checkRememberMeObj.isChecked();
                //validations
                if (email.isEmpty()) {
                    emailObj.setError("Enter email id");
                    emailObj.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    passwordObj.setError("Enter your password");
                    passwordObj.requestFocus();
                    return;
                }
                if (checkState) {
                    //shared pre storage
                    //crete a file
                    SharedPreferences sharedPreferences = PrefenceManager.getDefaultPref(getApplicationContext());
                    //open file
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    //add our data
                    editor.putString("email", email);
                    editor.putString("password", password);
                    editor.putBoolean("remember_me", checkState);
                    //save file
                    editor.apply();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                intent.putExtra("requestFrom",true);
                startActivity(intent);
                finish();

            }
        });


    }
}
