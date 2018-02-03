package com.example.macx.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by MacX on 2018-02-02.
 */

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        boolean mYesNoAnswer;
        final int chosenType = getIntent().getIntExtra("TYPE", 1);

        ArrayList<Question> questions = new ArrayList<Question>();

        View trueFalse = findViewById(R.id.true_false_option);
        View singleChoice = findViewById(R.id.single_choice_option);
        View fillIn = findViewById(R.id.fill_in_option);


        if (chosenType == 1) {
            questions.add(new Question("Stive Jobs is the founder of Microsoft", "false"));
            questions.add(new Question("Albert Einstein failed every subject in school that wasn't math or physics.", "yes"));
            questions.add(new Question("Bill Gates is the founder of Microsoft.", "yes"));
            questions.add(new Question("Tea has more caffeine than soda and coffee", "no"));

            singleChoice.setVisibility(View.GONE);
            fillIn.setVisibility(View.GONE);

            Random generator = new Random();
            int rand = generator.nextInt(questions.size());

            TextView questionTextView = findViewById(R.id.question_text_view);
            questionTextView.setText(questions.get(rand).getQuestion());

            String answer = questions.get(rand).getAnswer();
            if(answer.equals("yes")){
                mYesNoAnswer = true;
            } else {
                mYesNoAnswer = false;
            }


        } else if (chosenType == 2) {
            questions.add(new Question("Who developed the theory of relativity?", "Albert Einstein"));
            questions.add(new Question("Who was leading Spartans in Thermopylae battle?", "Leonidas"));
            questions.add(new Question("Who is Poland president?", "Andrzej Duda"));
            questions.add(new Question(
                    "Who has invented the long-lasting, practical electric light bulb?", "Thomas Edison"));

            trueFalse.setVisibility(View.GONE);
            fillIn.setVisibility(View.GONE);

            int scope = questions.size() - 1;
            Random generator = new Random();
            int rand = generator.nextInt(questions.size());

            Log.i(QuizActivity.class.getName(), "TEST: rand= " + rand);
            int secondRand = 0;
            int thirdRand = 0;
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

        } else if (chosenType == 3) {
            questions.add(new Question("Battle of Trafalagar.", "1805"));
            questions.add(new Question("Assassination of Abraham Lincoln.", "1865"));
            questions.add(new Question("Beginning of the American Civil War.", "1861"));
            questions.add(new Question("Roentgen discovered X-Rays.", "1895"));

            trueFalse.setVisibility(View.GONE);
            singleChoice.setVisibility(View.GONE);

            Random generator = new Random();
            int rand = generator.nextInt(questions.size());

            TextView questionTextView = findViewById(R.id.question_text_view);
            questionTextView.setText(questions.get(rand).getQuestion());

            String answer = questions.get(rand).getAnswer();

        }

        Button backMenu = findViewById(R.id.back_to_menu);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent timeTableIntent = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(timeTableIntent);
            }
        });

        Button checkAnswer = findViewById(R.id.check_answer);

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: add checking answer

                Intent typeOfQuizIntent = new Intent(QuizActivity.this, QuizActivity.class);
                typeOfQuizIntent.putExtra("TYPE", chosenType);
                startActivity(typeOfQuizIntent);
            }
        });
    }


}
