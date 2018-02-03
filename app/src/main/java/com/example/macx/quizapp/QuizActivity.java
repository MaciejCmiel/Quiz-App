package com.example.macx.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by MacX on 2018-02-02.
 */

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String jsonResponse = getIntent().getStringExtra("TYPE");

        ArrayList<Question> questions = new ArrayList<Question>();

        if (jsonResponse == "trueFalse") {
            questions.add(new Question("Stive Jobs is the founder of Microsoft", "no"));
            questions.add(new Question("Albert Einstein failed every subject in school that wasn't math or physics.", "yes"));
            questions.add(new Question("Bill Gates is the founder of Microsoft.", "yes"));
            questions.add(new Question("Tea has more caffeine than soda and coffee", "no"));


        } else if (jsonResponse == "singleChoice") {
            questions.add(new Question("Who developed the theory of relativity?", "Albert Einstein"));
            questions.add(new Question("Who was leading Spartans in Thermopylae battle?", "Leonidas"));
            questions.add(new Question("Who is Poland president?", "Andrzej Duda"));
            questions.add(new Question(
                    "Who has invented the long-lasting, practical electric light bulb?", "Thomas Edison"));

        } else if (jsonResponse == "fillIn") {
            questions.add(new Question("How many is 12 to the power of 2?", "144"));
            questions.add(new Question("How many is 13 to the power of 2?", "169"));
            questions.add(new Question("How many is 14 to the power of 2?", "196"));
            questions.add(new Question("How many is 15 to the power of 2?", "255"));

        }
    }

}
