package com.example.notelocationtake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditNoteActivity extends AppCompatActivity {

    EditText editTextTitleEN, editTextContentEN;
    TextView textViewDateEN, textViewTimeEN, textViewAddressEN;


    Note note;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        editTextTitleEN = findViewById(R.id.editTextTitleEditNote);
        editTextContentEN = findViewById(R.id.editTextContentEditNote);
        textViewDateEN = findViewById(R.id.textViewDateEditNote);
        textViewTimeEN = findViewById(R.id.textViewTimeEditNote);
        textViewAddressEN = findViewById(R.id.textViewAddressEditNote);
        Button buttonCancelEditNote = findViewById(R.id.buttonCancelEditNote);
        FloatingActionButton noteSaveUpdateFAB = findViewById(R.id.updateSaveFAB);

        Intent intent = getIntent();
        Long id = intent.getLongExtra("ID",0);
        dbHelper = new DBHelper(this);
        note = dbHelper.getNote(id);

        editTextTitleEN.setText(note.getTitle());
        editTextContentEN.setText(note.getContent());
        textViewDateEN.setText(note.getDate());
        textViewTimeEN.setText(note.getTime());
        textViewAddressEN.setText(note.getAddress());

        buttonCancelEditNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditNoteActivity.this,"Cancelled Edit!",Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

        noteSaveUpdateFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextTitleEN.getText().length() != 0){

                    note.setTitle(editTextTitleEN.getText().toString());
                    note.setContent(editTextContentEN.getText().toString());
                    int id = dbHelper.editNote(note);
                    if(id==note.getID()){
                        Toast.makeText(EditNoteActivity.this, "Note Updated!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(EditNoteActivity.this, "Error on updating note",Toast.LENGTH_SHORT).show();
                    }
                    goToMain();

                }
                else{
                    Toast.makeText(EditNoteActivity.this,"You cannot leave the title empty!",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}
