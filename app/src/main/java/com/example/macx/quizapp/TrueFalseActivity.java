package com.example.macx.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by MacX on 2018-02-02.
 */

public class TrueFalseActivity extends AppCompatActivity {

    RadioGroup trueFalse;
    RadioButton radioButton;
    View singleChoice;
    View fillIn;

    String mCheckedAnswer;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ArrayList<Question> questions = new ArrayList<Question>();

        trueFalse = findViewById(R.id.true_false_option);
        singleChoice = findViewById(R.id.single_choice_option);
        fillIn = findViewById(R.id.fill_in_option);


        questions.add(new Question("Stive Jobs is the founder of Microsoft", "False"));
        questions.add(new Question("Albert Einstein failed every subject in school that wasn't math or physics.", "True"));
        questions.add(new Question("Bill Gates is the founder of Microsoft.", "True"));
        questions.add(new Question("Tea has more caffeine than soda and coffee", "False"));
        questions.add(new Question("Andrzej Duda is President of Poland", "True"));
        questions.add(new Question("Antoni Macierewicz is Polish Prime Minister", "False"));
        questions.add(new Question("Earth is the 3rd planet in solar system", "True"));


        singleChoice.setVisibility(View.GONE);
        fillIn.setVisibility(View.GONE);

        Random generator = new Random();
        int rand = generator.nextInt(questions.size());

        TextView questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(questions.get(rand).getQuestion());

        //Get the good answer from random selected question
        answer = questions.get(rand).getAnswer();


        Button backMenu = findViewById(R.id.back_to_menu);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent backIntent = new Intent(TrueFalseActivity.this, MainActivity.class);
                startActivity(backIntent);
            }
        });

        Button checkAnswer = findViewById(R.id.check_answer);

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView toastText = (TextView) view;

                int radioId = trueFalse.getCheckedRadioButtonId();
                Log.i(TrueFalseActivity.class.getName(), "TEST: " + radioId);

                radioButton = findViewById(radioId);

                mCheckedAnswer = radioButton.getText().toString();

                Log.i(TrueFalseActivity.class.getName(), "TEST: m: " + mCheckedAnswer + " answer: " + answer);

                if (mCheckedAnswer.equals(answer)) {
                    Toast.makeText(getApplicationContext(), "Good Answer!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Answer!", Toast.LENGTH_SHORT).show();
                }


                Intent typeOfQuizIntent = new Intent(TrueFalseActivity.this, TrueFalseActivity.class);
                startActivity(typeOfQuizIntent);
            }
        });
    }

    public void checkButton (View view){
        int radioId = trueFalse.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
    }


}
