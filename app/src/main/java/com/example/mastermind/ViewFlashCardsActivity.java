package com.example.mastermind;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastermind.databinding.ViewFlashcardsBinding;

public class ViewFlashCardsActivity extends AppCompatActivity {

    private ViewFlashcardsBinding binding;

    private FlashCardAdapter flashCardAdapter;

    private Folder folder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ViewFlashcardsBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        folder = (Folder) getIntent().getSerializableExtra("Folder");
        flashCardAdapter = new FlashCardAdapter(this, folder.getFlashCards());
        binding.folderTitle.setText(folder.getName());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.flashCardRecycler.setLayoutManager(layoutManager);
        binding.flashCardRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        binding.flashCardRecycler.setAdapter(flashCardAdapter);

    }
}
