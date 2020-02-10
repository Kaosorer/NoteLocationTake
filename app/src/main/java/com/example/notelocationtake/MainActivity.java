package com.example.notelocationtake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.noteRecyclerView);

        FloatingActionButton addNoteFAB = findViewById(R.id.addNewNoteFAB);
        addNoteFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this,"Button Clicked", Toast.LENGTH_SHORT).show();//Test FAB functionality

                startActivity(new Intent(MainActivity.this, AddNote.class));

            }
        });
    }



}
