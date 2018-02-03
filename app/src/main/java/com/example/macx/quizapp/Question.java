package com.example.macx.quizapp;

/**
 * Created by MacX on 2018-02-01.
 */

public class Question {


    private String mQuestion;

    private String mAnswer;

    /**
     * Create a new Question object
     *
     * @param question
     * @param answer
     */
    public Question(String question, String answer) {
        mQuestion = question;
        mAnswer = answer;
    }

    /**
     * Get question.
     */
    public String getQuestion() {
        return mQuestion;
    }

    /**
     * Get answer for question.
     */
    public String getAnswer() {
        return mAnswer;
    }

}
