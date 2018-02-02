package com.example.macx.quizapp;

/**
 * Created by MacX on 2018-02-01.
 */

public class Question {

    private String mWord;

    private String mAnswer;

    /**
     * number of points for good answer
     */
    private int mPoints;

    public Question(String question, String answer) {
        mWord = question;
        mAnswer = answer;
        mPoints = 0;
    }

    public String getWord() {
        return mWord;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public int getPoints() {
        return mPoints;
    }

    public void setPoints(boolean sign) {
        if (sign) {
            mPoints++;
        } else {
            mPoints--;
        }
    }
}
