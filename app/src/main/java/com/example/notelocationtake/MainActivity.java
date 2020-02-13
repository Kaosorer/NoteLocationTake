package com.example.notelocationtake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener{

    private static final int REQUEST_CODE_ACTIVATION_PERMISSION = 1;


    RecyclerView recyclerView;
    Adapter adapter;
    List<Note> noteList;

    LocationManager locationManager;

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

                if (ContextCompat.checkSelfPermission(
                        getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ACTIVATION_PERMISSION);
                }
                else {
                    getLocation();
                    startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_ACTIVATION_PERMISSION && grantResults.length > 0){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
            else {
                Toast.makeText(this, "Permission denied!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    void getLocation(){
        try {
            locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,0, MainActivity.this);
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
