package com.example.mastermind;

import static java.lang.String.*;

import android.annotation.SuppressLint;
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
        assert folder != null;
        cards = folder.getFlashCards();
        binding.titleQuiz.setText(folder.getName());
        updateCards();

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
                    updateCards();
                }
            }
        });

        binding.prevCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the quiz button goes here
                if(cardIt > 0){
                    cardIt -= 1;
                    updateCards();
                }
            }
        });
    }

    @Override
    public void onClick(View v){

    }

    private void updateCards(){
        currCard = cards.get(cardIt);
        binding.card.setText(currCard.getQuestion());
        @SuppressLint("DefaultLocale")
        String cardTracker = format("%d/%d", cardIt + 1, folder.getFlashCards().size());
        binding.cardTracker.setText(cardTracker);
    }
}
