package com.example.notelocationtake;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class AddNote extends AppCompatActivity {

    TextView textViewDate, textViewTime, textViewAddress;
    EditText editTextTitle, editTextContent;
    FloatingActionButton noteSaveFAB;
    Button buttonCancel;

    Calendar c;
    String dateToday;
    String currentTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note_activity);

        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        textViewAddress = findViewById(R.id.textViewAddress);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);

        noteSaveFAB = findViewById(R.id.saveFAB);

        buttonCancel = findViewById(R.id.buttonCancel);

        c = Calendar.getInstance();
        dateToday = Pad(c.get(Calendar.DAY_OF_MONTH))+Ordinal(c.get(Calendar.DAY_OF_MONTH))+" "+ShortForm(c.get(Calendar.MONTH))+" "+c.get(Calendar.YEAR);//date in dd MMM yyyy format: e.g, 21st January 2020
        currentTime = Pad(c.get(Calendar.HOUR))+":"+Pad(c.get(Calendar.MINUTE));

        textViewDate.setText(dateToday);
        textViewTime.setText(currentTime);

        noteSaveFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Note note = new Note(editTextTitle.getText().toString(),editTextContent.getText().toString(), dateToday, currentTime);
                DBHelper dbHelper = new DBHelper(AddNote.this);
                dbHelper.addNote(note);

            }
        });

    }



    private String ShortForm(int i){
        if (i==Calendar.JANUARY){
            return "Jan";
        }
        else if (i==Calendar.FEBRUARY){
            return "Feb";
        }
        else if (i==Calendar.MARCH){
            return "Mar";
        }
        else if (i==Calendar.APRIL){
            return "Apr";
        }
        else if (i==Calendar.MAY){
            return "May";
        }
        else if (i==Calendar.JUNE){
            return "Jun";
        }
        else if (i==Calendar.JULY){
            return "Jul";
        }
        else if (i==Calendar.AUGUST){
            return "Aug";
        }
        else if (i==Calendar.SEPTEMBER){
            return "Sep";
        }
        else if (i==Calendar.OCTOBER){
            return "Oct";
        }
        else if (i==Calendar.NOVEMBER){
            return "Nov";
        }
        else if (i==Calendar.DECEMBER){
            return "Dec";
        }
        else return "Err";
    }
    private String Pad(int i){
        String s;
        if (i<10){
            s = "0"+i;
            return s;
        }
        else {
            s = ""+i;
            return s;
        }
    }
    private String Ordinal(int i){
        int rule = i%10;
        if (i>10&&i<20){
            return "th";
        }
        else if(rule == 1){
            return "st";
        }
        else if (rule == 2){
            return "nd";
        }
        else if (rule == 3){
            return "rd";
        }
        else if (rule==0||rule>3){
            return "th";
        }
        else return "Err";
    }

}
