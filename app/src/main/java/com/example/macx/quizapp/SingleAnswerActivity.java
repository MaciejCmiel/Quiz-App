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

public class SingleAnswerActivity extends AppCompatActivity {

    RadioGroup trueFalse;
    RadioButton radioButton;
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


            questions.add(new Question("Who developed the theory of relativity?", "Albert Einstein"));
            questions.add(new Question("Who was leading Spartans in Thermopylae battle?", "Leonidas"));
            questions.add(new Question("Who is Poland president?", "Andrzej Duda"));
            questions.add(new Question(
                    "Who has invented the long-lasting, practical electric light bulb?", "Thomas Edison"));
            questions.add(new Question("Who was US President in 1961 – 1963", "John F. Kennedy"));
            questions.add(new Question("American businessman, founder of Microsoft", "Bill Gates"));
            questions.add(new Question("British Prime Minister 1979 – 1990", "Margaret Thatcher "));
            questions.add(new Question("British monarch since 1954", "Queen Elizabeth II"));
            questions.add(new Question("Businessman, politician, President of United States", "Donald Trump"));
            questions.add(new Question(
                    "The 264th Pope of the Catholic Church from 16 October 1978", "John Paul II"));

            trueFalse.setVisibility(View.GONE);
            fillIn.setVisibility(View.GONE);

            int scope = questions.size() - 1;
            Random generator = new Random();
            int rand = generator.nextInt(questions.size());

            Log.i(SingleAnswerActivity.class.getName(), "TEST: rand= " + rand);
            int secondRand;
            int thirdRand;
            if (rand == scope) {
                secondRand = 0;
            } else {
                secondRand = rand + 1;
            }

            if (rand == 0) {
                thirdRand = scope;
            } else {
                thirdRand = rand - 1;
            }

            TextView questionTextView = findViewById(R.id.question_text_view);
            questionTextView.setText(questions.get(rand).getQuestion());

            TextView answerTextView = findViewById(R.id.first_answer);
            answerTextView.setText(questions.get(rand).getAnswer());


            TextView secondAnswer = findViewById(R.id.second_answer);
            secondAnswer.setText(questions.get(secondRand).getAnswer());

            TextView thirdAnswer = findViewById(R.id.third_answer);
            thirdAnswer.setText(questions.get(thirdRand).getAnswer());



        Button backMenu = findViewById(R.id.back_to_menu);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent timeTableIntent = new Intent(SingleAnswerActivity.this, MainActivity.class);
                startActivity(timeTableIntent);
            }
        });

        Button checkAnswer = findViewById(R.id.check_answer);

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId = trueFalse.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                        TextView toastText = (TextView) view;
                Toast.makeText(getApplicationContext(), "Good Answer!", Toast.LENGTH_SHORT).show();

                Intent typeOfQuizIntent = new Intent(SingleAnswerActivity.this, SingleAnswerActivity.class);
                startActivity(typeOfQuizIntent);
            }
        });
    }


}
