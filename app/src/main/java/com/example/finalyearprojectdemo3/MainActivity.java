package com.example.finalyearprojectdemo3;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean isChronometerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Timer for Parking
        chronometer = findViewById(R.id.chronometer);
        Button startStopButton = findViewById(R.id.startStopButton);
        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonStartClick(v);
            }
        });

        // Button to End the Parking
        Button endButton = findViewById(R.id.endButton);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonEndClick(v);
            }
        });

        // Spinner (Parking Floor)
        Spinner parkingLotNumBox1 = findViewById(R.id.parkingLotNumBox1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.parking_lot_floor, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkingLotNumBox1.setAdapter(adapter);
    }

    // Button when user start the timer
    public void onButtonStartClick(View view) {
        if (!isChronometerRunning) {
            new AlertDialog.Builder(this)
                    .setTitle("Start Parking Confirmation")
                    .setMessage("Pressing 'Yes' will start the parking timer. Are you sure you want to start parking?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            chronometer.setBase(SystemClock.elapsedRealtime());
                            chronometer.start();
                            isChronometerRunning = true;

                            TextView statusBox = findViewById(R.id.statusBox);
                            statusBox.setText("On Going");
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Parking Timer Already Started")
                    .setMessage("The parking timer is already running. You cannot start it again.")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }

    // Button when user end the parking
    public void onButtonEndClick(View view) {
        if (isChronometerRunning) {
            new AlertDialog.Builder(this)
                    .setTitle("End Parking Confirmation")
                    .setMessage("Pressing 'Yes' will end the timer and you will have 15 minutes to leave the parking. Are you sure you want to end parking? ")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            chronometer.stop();
                            isChronometerRunning = false;
                            chronometer.setBase(SystemClock.elapsedRealtime());

                            TextView statusBox = findViewById(R.id.statusBox);
                            statusBox.setText("Available");

                            EditText parkingLotNumBox2 = findViewById(R.id.parkingLotNumBox2);
                            parkingLotNumBox2.setText("");
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Parking Timer Not Started")
                    .setMessage("You must start parking timer before ending the timer.")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }



    // Button Bar to redirect to other pages
    // Button to Vehicle Page
    public void onButtonVehicleClick(View view) {
        Intent intent = new Intent(this, VehiclePageActivity.class);
        startActivity(intent);
    }

    // Button for Season Page (Redirect to Sunway Season Pass Website)
    public void onButtonSeasonClick(View view) {
        String url = "https://seasonpass.sunwayparking.com/dashboard";

        new AlertDialog.Builder(this)
                .setTitle("Redirect to Sunway Season Pass Website?")
                .setMessage("This will redirect you to Sunway Season Pass website. Do you want to proceed?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    // Button to Help Page
    public void onButtonHelpClick(View view) {
        Intent intent = new Intent(this, HelpPageActivity.class);
        startActivity(intent);
    }

    // Button to Parking View Page
    public void onButtonParkingViewClick(View view) {
        Intent intent = new Intent(this, ParkingViewPageActivity.class);
        startActivity(intent);
    }

    // Button to Pay Page Website (Sunway Official Payment Website)
    String url = "http://payment.sunwayparking.com/";
    public void onButtonPayClick(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Redirect To Payment Website")
                .setMessage("This will redirect you to the Sunway Payment website. Do you want to proceed?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}

