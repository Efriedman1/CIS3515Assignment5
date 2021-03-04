package com.example.cis3515assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import android.content.Intent;

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

        //Set label
        getSupportActionBar().setTitle("Selection Activity");

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        ArrayList carMakeArray = new ArrayList<String>();
        carMakeArray.add(0, "Select item from list");
        carMakeArray.add("Chevy");
        carMakeArray.add("Dodge");
        carMakeArray.add("Lamborghini");
        carMakeArray.add("Ford");
        carMakeArray.add("Ferrari");


        ArrayList carModelArray = new ArrayList<String>();
        carModelArray.add(0,"");
        carModelArray.add("Camaro");
        carModelArray.add("Charger");
        carModelArray.add("Gallardo");
        carModelArray.add("Mustang");
        carModelArray.add("Spider488");

        carImagesArray = new int[]{android.R.color.transparent, R.drawable.camaro, R.drawable.charger, R.drawable.gallardo, R.drawable.mustang, R.drawable.spider488};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, carMakeArray);

        spinner.setAdapter(adapter);
        //DisplayActivity adapter = new DisplayActivity(this, desertsArray, locationArray);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals("Select item from list")){
                    imageView.setImageResource(android.R.color.transparent);
                }
                else {
                    Toast.makeText(SelectionActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();
                    showPicture(position);


                    //Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    //startActivity(launchIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SelectionActivity.this, "Item Unselected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showPicture (int position) {
        imageView.setImageResource(carImagesArray[position]);
    }
}

