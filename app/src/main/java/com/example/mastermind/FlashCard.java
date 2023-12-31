package com.example.mastermind;

import java.io.Serializable;

public class FlashCard implements Serializable {
    private String question;
    private String answer;

    public FlashCard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
