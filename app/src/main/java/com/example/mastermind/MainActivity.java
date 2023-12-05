package com.example.mastermind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastermind.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Folder> folders;
    private ActivityMainBinding binding;
    private FolderAdapter folderAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        // Initializes the array list that will hold the folders
        folders = new ArrayList<Folder>();
        // Initializes the Folder Adapter
        folderAdapter = new FolderAdapter(this,folders);

        // Sets up the folder adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.content.recyclerView.setLayoutManager(layoutManager);
        binding.content.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        binding.content.recyclerView.setAdapter(folderAdapter);
    }

    public void viewFlashCards(Folder folder){
        Intent intent = new Intent(this, ViewFlashCardsActivity.class);
        intent.putExtra("Folder", (Serializable) folder);
        startActivity(intent);
    }

    //Method creates and shows a new add folder dialog
    public void addFolder(View view) {
        // Toast.makeText(this, "You clicked on Add Contact Button", Toast.LENGTH_LONG).show();
        AddFolderDialog addFolderDialog = new AddFolderDialog();
        addFolderDialog.show(getSupportFragmentManager(), "");
    }

    //Method adds a new folder to the folders array and updates the folder adapter to display
    //the newly added folder
    // Method takes in the folder that is going to be added to the folders array
    public void addFolder(Folder folder){
        folders.add(folder);
        folderAdapter.notifyDataSetChanged();
    }

    // Method is used to add flashcards to the specified folder
    // Method takes in the index position of the selected folder from thr folder array
    // and takes in a question and answer that are used to create the new flashcard
    public void addFlashCard(int position, String question, String answer){
        folders.get(position).addFlashCard(question, answer);
    }

    // Method is creates a new view folder dialog for the selected folder
    // Takes in the index of the selected folder
    public void viewFolder(int position){
        ViewFolderDialog viewFolderDialog = new ViewFolderDialog();
        viewFolderDialog.setFolder(folderAdapter, folders, position);
        viewFolderDialog.show(getSupportFragmentManager(),"");
    }


    public void viewFlashCard(int position) {
    }

    public void startQuiz(Folder folder) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("Folder", (Serializable) folder);
        startActivity(intent);
    }
}