package com.example.mastermind;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mastermind.databinding.DialogAddFolderBinding;

import java.util.ArrayList;

public class AddFolderDialog extends DialogFragment {
    private DialogAddFolderBinding binding;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Creates the Add Folder Dialog
        binding = DialogAddFolderBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        // Method is called when the save button is clicked
        // Method saves the newly created folder
        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        return builder.create();
    }

    // Method is used to save a new folder
    public void save(){
        // Gets the name of the folder from the text input
        String name = binding.folderName.getText().toString();
        // Creates a new empty flashcard array for the folder
        ArrayList<FlashCard> list = new ArrayList<FlashCard>();
        Folder folder = new Folder(name, list);
        MainActivity mainActivity = (MainActivity) getActivity();
        // adds the folder to the folders list in mainActivity
        mainActivity.addFolder(folder);
        dismiss();
    }
}
