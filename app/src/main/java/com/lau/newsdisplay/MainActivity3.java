package com.lau.newsdisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ListView news_list;
    ArrayList<String> the_list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i=getIntent();
        String username=i.getStringExtra("username");

        news_list= findViewById(R.id.news_list);
        the_list= new ArrayList<String>();

        try{

        SQLiteDatabase sql = this.openOrCreateDatabase("newsdb", MODE_PRIVATE, null);
        sql.execSQL("CREATE Table IF NOT EXISTS news ( author VARCHAR, title TEXT, description TEXT)");
            sql.execSQL("INSERT INTO news (author, title,description) VALUES ('John', 'Doe','hi')");
            sql.execSQL("INSERT INTO news (author, title,description) VALUES ('John', 'Doe','hi')");

        Cursor c = sql.rawQuery("Select * from news", null);
        int title_count = c.getColumnIndex("title");
        c.moveToFirst();
            while(c!= null){
                String titlee = c.getString(title_count) + " ";
                the_list.add(titlee);
                c.moveToNext();
            }

    }catch(Exception e){
        e.printStackTrace();
    }

    adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, the_list);
        news_list.setAdapter(adapter);
        news_list.setOnItemClickListener((adapterView, view, i1, l) -> {
           Intent intent= new Intent(getApplicationContext(),MainActivity4.class);
            intent.putExtra("title",the_list.get(i1));
            startActivity(intent);
       });
}

    public void addNews(View v){
        Intent intent= new Intent(getApplicationContext(),MainActivity5.class);
       startActivity(intent);
    }
}