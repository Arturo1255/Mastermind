package com.example.mastermind;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
    private FolderAdapter folderAdapter;

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
                      startQuiz();
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
                        deleteFolder(folder);
                        }
                }
        );

        binding.viewFlashCardButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                vewFlashCards(v);
            }
                }
        );

        return builder.create();
    }

    private void deleteFolder(Folder folder) {
        AlertDialog.Builder builder = new AlertDialog.Builder((MainActivity) getActivity());
        builder.setTitle("Delete Folder");
        builder.setMessage("Are you sure you want to delete this folder?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Delete the contact from the list
                list.remove(folder);
                // Notify the adapter about the change
                folderAdapter.notifyDataSetChanged();
                // Dismiss the dialog
                dialog.dismiss();
                dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing or handle cancel
                dialog.dismiss();
            }
        });
        builder.show();
    }



    private void startQuiz() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.startQuiz(this.folder);
    }

    private void vewFlashCards(View v) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.viewFlashCards(this.folder);
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

    public void setFolder(FolderAdapter folderAdapter, ArrayList<Folder> list, int position){
        this.list = list;
        this.position = position;
        this.folderAdapter = folderAdapter;
    }



}
