package com.example.mastermind;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.databinding.QuizBinding;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    private QuizBinding binding;

    private Folder folder;

    private ArrayList<FlashCard> cards;
    private int cardIt = 0;

    private FlashCard currCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = QuizBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        folder = (Folder) getIntent().getSerializableExtra("Folder");
        cards = folder.getFlashCards();
        currCard = cards.get(cardIt);
        binding.card.setText(currCard.getQuestion());
        binding.titleQuiz.setText(folder.getName());

        binding.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the quiz button goes here
                if(binding.card.getText() == currCard.getAnswer()){
                    binding.card.setText(currCard.getQuestion());

                }
                else{
                    binding.card.setText(currCard.getAnswer());
                }
            }
        });

        binding.nextCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the quiz button goes here
                if(cardIt < folder.getFlashCards().size() - 1){
                    cardIt += 1;
                    currCard = cards.get(cardIt);
                    binding.card.setText(currCard.getQuestion());
                }
            }
        });

        binding.prevCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the quiz button goes here
                if(cardIt > 0){
                    cardIt -= 1;
                    currCard = cards.get(cardIt);
                    binding.card.setText(currCard.getQuestion());
                }
            }
        });
    }

    @Override
    public void onClick(View v){

    }
}
