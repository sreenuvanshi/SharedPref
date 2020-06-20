package com.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvEmailObj = findViewById(R.id.tvEmail);
        TextView tvPasswordObj = findViewById(R.id.tvPassword);
        Button btnClearPrefObj = findViewById(R.id.btnClearPref);

        boolean requestFrom = getIntent().getBooleanExtra("requestFrom", false);
        String email = "";
        String password = "";
        if (requestFrom) {
            //get intent info
            email = getIntent().getStringExtra("email");
            password = getIntent().getStringExtra("password");
        } else {
            //get shared info
            SharedPreferences sharedPreferences = PrefenceManager.getDefaultPref(getApplicationContext());
            email = sharedPreferences.getString("email", "");
            password = sharedPreferences.getString("password", "");
        }

        tvEmailObj.setText(email);
        tvPasswordObj.setText(password);

        btnClearPrefObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PrefenceManager.getDefaultPref(getApplicationContext());
                sharedPreferences.edit().clear().apply();
                finish();
            }
        });

    }
}
