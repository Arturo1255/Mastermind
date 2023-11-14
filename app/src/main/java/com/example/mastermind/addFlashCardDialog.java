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

    // Variable stores the index of the selected folder
    private int position;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Creates and shows a new add Flashcard dialog
        binding = DialogAddFlashcardBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        // When the save button is clicked the flashcard is saved to the selected folder
        binding.FlashCardSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        return builder.create();
    }

    // Method is used to save the flashcard and ad the flashcard to the selected folder
    public void save(){
        // Gets the question and answer form the text box
        String question = binding.flashCardQuestion.getText().toString();
        String answer = binding.flashCardAnswer.getText().toString();
        MainActivity mainActivity = (MainActivity) getActivity();
        // The flashed is added to the selected folder
        mainActivity.addFlashCard(position,question,answer);
        dismiss();
    }

    // Function is used to give the dialog the index of the selected folder
    public void setPosition(int position) {
        this.position = position;
    }
}
