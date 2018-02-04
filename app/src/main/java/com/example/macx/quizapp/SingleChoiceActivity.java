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

public class SingleChoiceActivity extends AppCompatActivity {

    RadioGroup trueFalse;
    RadioButton radioButton;
    RadioGroup singleChoice;
    View fillIn;

    //variable to store user answer
    String mCheckedAnswer;
    // variable to store correct answer
    String mAnswer;

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

        // hide redundant view groups
        trueFalse.setVisibility(View.GONE);
        fillIn.setVisibility(View.GONE);

        //subtract 1  from size because of index numeration from 0
        int scope = questions.size() - 1;
        //use Random class to draw by lot number from 0 to size of question ArrayList
        Random generator = new Random();
        int rand = generator.nextInt(questions.size());

        //provide 2 more answers by subtracting and adding one to rand
        Log.i(SingleChoiceActivity.class.getName(), "TEST: rand= " + rand);
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

        //Find proper TextViews, get questions and answers and set them on TextViews
        TextView questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(questions.get(rand).getQuestion());

        TextView answerTextView = findViewById(R.id.first_answer);
        answerTextView.setText(questions.get(rand).getAnswer());

        TextView secondAnswer = findViewById(R.id.second_answer);
        secondAnswer.setText(questions.get(secondRand).getAnswer());

        TextView thirdAnswer = findViewById(R.id.third_answer);
        thirdAnswer.setText(questions.get(thirdRand).getAnswer());

        // get correct answer and set it to mAnswer
        mAnswer = questions.get(rand).getAnswer();

        //Find the Button and Set click listener on that Button
        Button backMenu = findViewById(R.id.back_to_menu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create a new intent to open the {@link MainActivity}
                Intent backToMenuIntent = new Intent(SingleChoiceActivity.this, MainActivity.class);
                startActivity(backToMenuIntent);
            }
        });

        //Find the answer checking Button and Set click listener on that Button
        Button checkAnswer = findViewById(R.id.check_answer);
        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the id of checked radio button
                int radioId = singleChoice.getCheckedRadioButtonId();
                Log.i(SingleChoiceActivity.class.getName(), "TEST: " + radioId);


                if (radioId == -1){
                    Toast.makeText(getApplicationContext(), "You must pick answer!", Toast.LENGTH_SHORT).show();
                } else {

                    //find checked radio button by id and get text from this button
                    radioButton = findViewById(radioId);
                    mCheckedAnswer = radioButton.getText().toString();

                    Log.i(SingleChoiceActivity.class.getName(), "TEST: m: " + mCheckedAnswer + " answer: " + mAnswer);

                    // check if user answer is equal to correct answer and inform about it by Toast message
                    if (mCheckedAnswer.equals(mAnswer)) {
                        Toast.makeText(getApplicationContext(), "Good Answer!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    }
                    // Create a new intent to open again SingleChoiceActivity with another question
                    Intent typeOfQuizIntent = new Intent(SingleChoiceActivity.this, SingleChoiceActivity.class);
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
