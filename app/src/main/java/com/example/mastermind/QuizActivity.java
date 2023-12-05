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
    private int cardPos = 0;

    private FlashCard currCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = QuizBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        folder = (Folder) getIntent().getSerializableExtra("Folder");
        cards = folder.getFlashCards();
        currCard = cards.get(cardPos);
        binding.card.setText(currCard.getQuestion());
        binding.titleQuiz.setText(folder.getName());
    }

    @Override
    public void onClick(View v){

    }
}
