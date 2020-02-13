package com.example.notelocationtake;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    Geocoder geocoder;

    private FusedLocationProviderClient client;
    List<Address> addressList;

    TextView textViewDate, textViewTime, textViewAddress;
    EditText editTextTitle, editTextContent;
    FloatingActionButton noteSaveFAB;
    Button buttonCancel;

    Calendar c;
    String dateToday;
    String currentTime;
    String currentLocation = "Unknown Location";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        geocoder = new Geocoder(this);

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

        client = LocationServices.getFusedLocationProviderClient(this);
        client.getLastLocation().addOnSuccessListener(AddNoteActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if (location != null){
                    try {
                        Log.d("LocationLocation", currentLocation);
                        Log.d("LocationLocation",location.toString());
                        addressList = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    currentLocation = addressList.get(0).getAddressLine(0);
                    textViewAddress.setText(currentLocation);
                    Log.d("LocationLocation", currentLocation);
                }
            }
        });

        textViewDate.setText(dateToday);
        textViewTime.setText(currentTime);
        textViewAddress.setText(currentLocation);

        noteSaveFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextTitle.getText().length() != 0){
                    Log.d("LocationLocation", currentLocation);
                    Note note = new Note(editTextTitle.getText().toString(), editTextContent.getText().toString(), dateToday, currentTime, currentLocation);
                    DBHelper dbHelper = new DBHelper(AddNoteActivity.this);
                    dbHelper.addNote(note);
                    Toast.makeText(AddNoteActivity.this, "Note Saved!",Toast.LENGTH_SHORT).show();
                    goToMain();
                }
                else {
                    Toast.makeText(AddNoteActivity.this,"You cannot leave the title empty!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AddNoteActivity.this,"Note Not Saved!", Toast.LENGTH_SHORT);
                goToMain();
            }
        });

    }


    private void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
