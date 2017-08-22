package com.example.ajmal.project1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.Set;


public class QuizActivity extends AppCompatActivity {
    private static final String TAG ="QuizActivity";
    TextView question;
    DataHandler db;
    FirebaseDatabase mDatabase;
    Button start,next,previous;
    Spinner spinner;
    ArrayMap<String,String> map =  new ArrayMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        start=(Button)findViewById(R.id.btn_start);
        question=(TextView)findViewById(R.id.Question);
        db = db.getsInstance();

         mDatabase = FirebaseDatabase.getInstance();
    }
    public void Start(View view){
        Intent i=getIntent();
        Cursor cursor=db.getDefnBySet(i.getExtras().getString("TAG"));
        cursor.moveToFirst();
        if(cursor.moveToFirst()) {
            do {
                map.put(cursor.getString(cursor.getColumnIndex("term")),cursor.getString(cursor.getColumnIndex("defn")));
            }while(cursor.moveToNext());
            Random rand = new Random();
            int n;
          if(!map.isEmpty()){
               n = rand.nextInt(cursor.getCount());
              String qu=map.keyAt(n);
              question.setText(qu);

          }
        }

    }

}
