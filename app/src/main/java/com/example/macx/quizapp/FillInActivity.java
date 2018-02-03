package com.example.macx.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class FillInActivity extends AppCompatActivity {

    RadioGroup trueFalse;
    View singleChoice;
    View fillIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        ArrayList<Question> questions = new ArrayList<Question>();

        trueFalse = findViewById(R.id.true_false_option);
        singleChoice = findViewById(R.id.single_choice_option);
        fillIn = findViewById(R.id.fill_in_option);



        questions.add(new Question("Battle of Trafalagar.", "1805"));
        questions.add(new Question("Assassination of Abraham Lincoln.", "1865"));
        questions.add(new Question("Beginning of the American Civil War.", "1861"));
        questions.add(new Question("Roentgen discovered X-Rays.", "1895"));
        questions.add(new Question("Chinese Revolution.", "1911"));
        questions.add(new Question("Beginning of World War I.", "1914"));
        questions.add(new Question("End of World War I.", "1918"));
        questions.add(new Question("Yuri Gagarin of USSR becomes the first spaceman.", "1961"));
        questions.add(new Question("The Hundred years War broke out.", "1338"));
        questions.add(new Question("Discovery of America by Columbus.", "1492"));


        trueFalse.setVisibility(View.GONE);
        singleChoice.setVisibility(View.GONE);

        Random generator = new Random();
        int rand = generator.nextInt(questions.size());

        TextView questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(questions.get(rand).getQuestion());

        String answer = questions.get(rand).getAnswer();



        Button backMenu = findViewById(R.id.back_to_menu);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent timeTableIntent = new Intent(FillInActivity.this, MainActivity.class);
                startActivity(timeTableIntent);
            }
        });

        Button checkAnswer = findViewById(R.id.check_answer);

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView toastText = (TextView) view;
                Toast.makeText(getApplicationContext(), "Good Answer!", Toast.LENGTH_SHORT).show();

                Intent typeOfQuizIntent = new Intent(FillInActivity.this, FillInActivity.class);
                startActivity(typeOfQuizIntent);
            }
        });
    }


}
