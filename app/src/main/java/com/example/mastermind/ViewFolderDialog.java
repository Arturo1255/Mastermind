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
    private int position;

    private Folder folder;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DialogViewFolderBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());
        viewFolder();


        binding.QuizButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                    }
                }
        );

        binding.addFlashcard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {}
                }
        );

        binding.DeleteButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick (View v) {

                        }
                }
        );

        binding.viewFlashCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return builder.create();
    }

    public void viewFolder(){
        this.folder = list.get(position);
        binding.ViewFolderName.setText(folder.getName());
    }


    public void addFlashcard(){

    }

    public void setList(ArrayList<Folder> list){
        this.list = list;
    }

    public void setPosition(int position){
        this.position = position;
    }


}
