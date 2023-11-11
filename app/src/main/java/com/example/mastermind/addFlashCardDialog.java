package com.example.mastermind;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mastermind.databinding.DialogAddFlashcardBinding;
import com.example.mastermind.databinding.DialogAddFolderBinding;

import java.util.ArrayList;

public class addFlashCardDialog extends DialogFragment {
    private DialogAddFlashcardBinding binding;
    private int position;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DialogAddFlashcardBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        binding.FlashCardSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        return builder.create();
    }

    public void save(){
        String question = binding.flashCardQuestion.getText().toString();
        String answer = binding.flashCardAnswer.getText().toString();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.addFlashCard(position,answer,question);
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
