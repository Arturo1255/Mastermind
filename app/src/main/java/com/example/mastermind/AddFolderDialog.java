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
        binding = DialogAddFolderBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        return builder.create();
    }

    public void save(){
        String name = binding.folderName.getText().toString();
        ArrayList<FlashCard> list = new ArrayList<FlashCard>();
        Folder folder = new Folder(name, list);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.addFolder(folder);
        dismiss();
    }
}
