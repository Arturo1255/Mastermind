package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.mastermind.databinding.ActivityMainBinding;

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

        folders = new ArrayList<Folder>();

        folderAdapter = new FolderAdapter(this,folders);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.content.recyclerView.setLayoutManager(layoutManager);
        binding.content.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        binding.content.recyclerView.setAdapter(folderAdapter);
    }

    public void addFolder(View view) {
        // Toast.makeText(this, "You clicked on Add Contact Button", Toast.LENGTH_LONG).show();
        AddFolderDialog addFolderDialog = new AddFolderDialog();
        addFolderDialog.show(getSupportFragmentManager(), "");
    }

    public void addFolder(Folder folder){
        folders.add(folder);
        folderAdapter.notifyDataSetChanged();

    }

    public void addFlashCard(int position, String question, String answer){
        folders.get(position).addFlashCard(question, answer);
    }

    public void viewFolder(int position){
        ViewFolderDialog viewFolderDialog = new ViewFolderDialog();
        viewFolderDialog.setList(folders);
        viewFolderDialog.setPosition(position);
        viewFolderDialog.show(getSupportFragmentManager(),"");
    }


}