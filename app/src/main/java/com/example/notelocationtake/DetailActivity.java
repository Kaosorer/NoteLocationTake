package com.example.notelocationtake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {

    TextView titleEA, dateEA, timeEA, addressEA, contentEA;
    DBHelper dbHelper;
    Note note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_detail);

        Intent intent = getIntent();
        Long id = intent.getLongExtra("ID",0);

        dbHelper = new DBHelper(this);
        note = dbHelper.getNote(id);

        //Toast.makeText(this,"Title = "+note.getTitle(), Toast.LENGTH_SHORT).show();//Test for index match

        titleEA = findViewById(R.id.textViewTitleActEdit);
        contentEA = findViewById(R.id.textViewContentActEdit);
        dateEA = findViewById(R.id.textViewDateActEdit);
        timeEA = findViewById(R.id.textViewTimeActEdit);
        addressEA = findViewById(R.id.textViewAddressActEdit);

        titleEA.setText(note.getTitle());
        contentEA.setText(note.getContent());
        dateEA.setText(note.getDate());
        timeEA.setText(note.getTime());
        addressEA.setText(note.getAddress());

        Button delButton = findViewById(R.id.buttonNoteDel);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteNote(note.getID());
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                Toast.makeText(getApplicationContext(),"Note Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton deleteNoteFAB = findViewById(R.id.editFAB);
        deleteNoteFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
