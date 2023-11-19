package com.example.mastermind;

import java.io.Serializable;
import java.util.ArrayList;

public class Folder implements Serializable {
    private String name;
    private ArrayList<FlashCard> flashCards;

    public Folder(String name, ArrayList<FlashCard> flashCards){
        this.name = name;
        this.flashCards = flashCards;

    }

    public ArrayList<FlashCard> getFlashCards() {
        return flashCards;
    }

    public String getName() {
        return name;
    }

    public void setFlashCards(ArrayList<FlashCard> flashCards) {
        this.flashCards = flashCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFlashCard(String question, String answer){
        FlashCard newFlashcard = new FlashCard(question,answer);
        flashCards.add(newFlashcard);
    }
}
