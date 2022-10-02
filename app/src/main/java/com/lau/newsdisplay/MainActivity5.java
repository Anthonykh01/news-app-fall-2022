package com.lau.newsdisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {
    EditText title;    EditText author;    EditText description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void add(View v){
        title =findViewById(R.id.title);
        author =findViewById(R.id.author);
        description =findViewById(R.id.description);
try{
        SQLiteDatabase sql = this.openOrCreateDatabase("newsdb", MODE_PRIVATE, null);
        sql.execSQL("CREATE Table IF NOT EXISTS news ( author VARCHAR, title TEXT, description TEXT)");
        String author1=author.getText().toString();
        String title1=title.getText().toString();
        String description1=description.getText().toString();
        sql.execSQL("INSERT INTO news(author,title,description) VALUES ('"+author1+"','"+title1+"','"+description1+"')");

    }catch(Exception e){
        e.printStackTrace();
    }

    Intent i= new Intent(getApplicationContext(),MainActivity3.class);
    startActivity(i);


    }
}