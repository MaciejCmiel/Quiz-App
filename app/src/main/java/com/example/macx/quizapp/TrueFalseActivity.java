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

    //variable to store user answer
    private String mCheckedAnswer;
    // variable to store correct answer
    private String mAnswer;
    // variable to store number of good answers
    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mCounter = getIntent().getIntExtra("COUNTER", 0);

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
        mAnswer = questions.get(rand).getAnswer();


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

                //get the id of checked radio button
                int radioId = trueFalse.getCheckedRadioButtonId();

                if (radioId == -1) {
                    Toast.makeText(getApplicationContext(), "You must pick answer!", Toast.LENGTH_SHORT).show();
                } else {

                    radioButton = findViewById(radioId);
                    mCheckedAnswer = radioButton.getText().toString();

                    Log.i(TrueFalseActivity.class.getName(), "TEST: m: " + mCheckedAnswer + " answer: " + mAnswer);

                    // check if user answer is equal to correct answer and inform about it by Toast message
                    if (mCheckedAnswer.equals(mAnswer)) {
                        mCounter++;
                        Toast.makeText(getApplicationContext(), mCounter + " good Answer!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    }

                    // Create a new intent to open again TrueFalseActivity with another question
                    Intent typeOfQuizIntent = new Intent(TrueFalseActivity.this, TrueFalseActivity.class);
                    typeOfQuizIntent.putExtra("COUNTER", mCounter);
                    startActivity(typeOfQuizIntent);
                }
            }
        });
    }

    /**
     * public method to check Button
     *
     * @param view
     */
    public void checkButton(View view) {
        int radioId = trueFalse.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }


}
