package com.example.finalyearprojectdemo3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VehiclePageActivity extends AppCompatActivity {

    private VehicleAdapter adapter;
    private List<String> placeholderData = new ArrayList<>();
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("VehiclePageActivity", "onCreate called");
        setContentView(R.layout.activity_vehicle_page);

        loadDataFromSharedPreferences();

        listView = findViewById(R.id.listView);
        adapter = new VehicleAdapter(this, placeholderData);
        listView.setAdapter(adapter);

        Button addVehicleButton = findViewById(R.id.addVehicleButton);
        addVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnButtonAddButtonClick(v);
            }
        });
    }

    public void OnButtonAddButtonClick(View view) {
        if (placeholderData.size() >= 5) {
            Toast.makeText(VehiclePageActivity.this, "Maximum amount of vehicles has been reached.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, VehicleDetailsActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            String vehicleNumber = data.getStringExtra("vehicleNumber");
            if (vehicleNumber != null && !vehicleNumber.isEmpty()) {
                placeholderData.add(vehicleNumber);
                adapter.notifyDataSetChanged();
                saveDataToSharedPreferences();
            }
        }
    }

    // When leaving the page and rejoining
    private void loadDataFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("VehicleData", MODE_PRIVATE);
        String json = sharedPreferences.getString("vehicleList", "");
        if (!json.isEmpty()) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<String>>(){}.getType();
            placeholderData = gson.fromJson(json, type);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    // When added a new item in the ListView (Car Plate Number)
    private void saveDataToSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("VehicleData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(placeholderData);
        editor.putString("vehicleList", json);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveDataToSharedPreferences();
    }

    private class VehicleAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final List<String> values;

        public VehicleAdapter(Context context, List<String> values) {
            super(context, R.layout.list_item_vehicle, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public int getCount() {
            return Math.min(super.getCount(), 5);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item_vehicle, parent, false);

            ImageView imageView = rowView.findViewById(R.id.vehicleImage);
            TextView textView = rowView.findViewById(R.id.vehicleNumber);
            Button deleteButton = rowView.findViewById(R.id.buttonDelete);

            imageView.setImageResource(R.drawable.vehicle_img);
            textView.setText(values.get(position));


            // Delete Button
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(context)
                            .setTitle("Confirm Deletion")
                            .setMessage("Are you sure you want to delete the vehicle number?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    values.remove(position);
                                    notifyDataSetChanged();
                                    ((VehiclePageActivity) context).saveDataToSharedPreferences();
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            });

            return rowView;

        }
    }
}