package com.lau.newsdisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity2 extends AppCompatActivity {
    SharedPreferences shared;
    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences shared = this.getSharedPreferences("com.lau.shared", Context.MODE_PRIVATE);

    }

    public void submit(View v){
        username =findViewById(R.id.name);

        shared.edit().putString("username", username.getText().toString()).apply();

        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(intent);


    }

}

