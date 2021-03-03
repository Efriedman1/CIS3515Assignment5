package com.example.cis3515assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SelectionActivity extends AppCompatActivity {

    ImageView imageView;
    Spinner spinner;
    int[] carImagesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        ArrayList carMakeArray = new ArrayList<String>();
        carMakeArray.add("Chevy");
        carMakeArray.add("Dodge");
        carMakeArray.add("Lamborghini");
        carMakeArray.add("Ford");
        carMakeArray.add("Ferrari");


        ArrayList carModelArray = new ArrayList<String>();
        carModelArray.add("Camaro");
        carModelArray.add("Charger");
        carModelArray.add("Gallardo");
        carModelArray.add("Mustang");
        carModelArray.add("488 Spider");

        carImagesArray = new int[]{R.drawable.camaro, R.drawable.charger, R.drawable.gallardo, R.drawable.mustang, R.drawable.spider488};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, carMakeArray);

        spinner.setAdapter(adapter);
        //DisplayActivity adapter = new DisplayActivity(this, desertsArray, locationArray);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectionActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();


                showPicture(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SelectionActivity.this, "Item Unselected", Toast.LENGTH_SHORT).show();
            }
        });
        //Set label
        //getActionBar().setTitle("@string/selection_activity");
    }

    private void showPicture (int position) {
        imageView.setImageResource(carImagesArray[position]);
    }
}

