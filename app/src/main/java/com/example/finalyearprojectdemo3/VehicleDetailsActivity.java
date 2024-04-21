package com.example.finalyearprojectdemo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class VehicleDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        Button OnButtonSubmitButtonClick = findViewById(R.id.submitVehicleButton);
        OnButtonSubmitButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.vehicleNumberInput);
                String vehicleNumber = input.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("vehicleNumber", vehicleNumber);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
