package com.example.macx.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView trueFalse = (TextView) findViewById(R.id.true_false_text_view);
        TextView singleChoice = (TextView) findViewById(R.id.single_choice_text_view);
        TextView fillIn = (TextView) findViewById(R.id.fill_in_text_view);


        trueFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // create new intent to open quiz activity
                Intent typeOfQuizIntent = new Intent(MainActivity.this, TrueFalseActivity.class);
                startActivity(typeOfQuizIntent);
            }
        });

        singleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create new intent to open quiz activity
                Intent typeOfQuizIntent = new Intent(MainActivity.this, SingleAnswerActivity.class);

                startActivity(typeOfQuizIntent);
            }
        });

        fillIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create new intent to open FillIn activity
                Intent typeOfQuizIntent = new Intent(MainActivity.this, FillInActivity.class);
                startActivity(typeOfQuizIntent);
            }
        });
    }
}
