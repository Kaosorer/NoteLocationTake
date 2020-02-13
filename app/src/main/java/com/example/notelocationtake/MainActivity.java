package com.example.notelocationtake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    List<Note> noteList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);
        noteList = dbHelper.getNotes();

        recyclerView = findViewById(R.id.noteRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,noteList);
        recyclerView.setAdapter(adapter);


        FloatingActionButton addNoteFAB = findViewById(R.id.addNewNoteFAB);
        addNoteFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this,"Button Clicked", Toast.LENGTH_SHORT).show();//Test FAB functionality

                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));

            }
        });
    }



}
