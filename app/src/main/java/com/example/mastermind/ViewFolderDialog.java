package com.example.mastermind;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mastermind.databinding.DialogViewFolderBinding;

import java.util.ArrayList;

public class ViewFolderDialog extends DialogFragment {
    private DialogViewFolderBinding binding;
    private ArrayList<Folder> list;

    //Variable is used to store the index position of the selected folder
    private int position;

    private Folder folder;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Creates and shows a new folder view dialog
        binding = DialogViewFolderBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());
        // Loads the selected folders information for the view folder dialog
        viewFolder();


        binding.QuizButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // Code for the quiz button goes here

                    }
                }
        );

        // When the add flashcard button is clicked the add flashcard dialog is created and shown
        binding.addFlashcard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addFlashcard(v);
                    }
                }
        );

        binding.DeleteButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick (View v) {
                        // Code for delete button goes here
                        }
                }
        );

        binding.viewFlashCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code for view flashcard button goes here

            }
        });

        return builder.create();
    }

    // Method loads the folder information for the view folder dialog
    public void viewFolder(){
        Log.i("info", "viewFolder position" + position);
        this.folder = list.get(position);
        binding.ViewFolderName.setText(folder.getName());
    }

    // Method creates and shows a new add folder dialog
    public void addFlashcard(View view){
        addFlashCardDialog addFlashCardDialog = new addFlashCardDialog();
        assert getFragmentManager() != null;
        addFlashCardDialog.setPosition(this.position);
        addFlashCardDialog.show(getFragmentManager(), "");

    }

    public void setList(ArrayList<Folder> list){
        this.list = list;
    }

    public void setPosition(int position){
        this.position = position;
    }


}
