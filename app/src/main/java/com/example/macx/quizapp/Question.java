package com.example.macx.quizapp;

/**
 * Created by MacX on 2018-02-01.
 */

public class Question {

    private String mQuestion;

    private String mAnswer;


    public Question(String question, String answer) {
        mQuestion = question;
        mAnswer = answer;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getAnswer() {
        return mAnswer;
    }

}
