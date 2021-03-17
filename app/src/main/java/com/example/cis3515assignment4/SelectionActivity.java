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
import android.widget.GridView;
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


    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_IMAGE = "image";

  //  ImageView imageView;
    GridView gridView;

    int[] carImagesArray;
    ArrayList<String> carsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set label
        getSupportActionBar().setTitle("Image Select");

        gridView = findViewById(R.id.gridView);
        gridView.setNumColumns(3);

        carsArray = new ArrayList<String>();
        carsArray.add("Atacama");
        carsArray.add("Gobi");
        carsArray.add("Mohave");
        carsArray.add("Patagonian");
        carsArray.add("Sahara");

        carImagesArray = new int[]{R.drawable.camaro, R.drawable.charger, R.drawable.gallardo, R.drawable.mustang, R.drawable.spider488};
        ImageAdapter adapter = new ImageAdapter(this, carsArray, carImagesArray);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }
        });
    }

    private void showPicture (int position) {
        Intent launchIntent = new Intent(this, DisplayActivity.class);
        launchIntent.putExtra(EXTRA_DESCRIPTION, carsArray.get(position));
        launchIntent.putExtra(EXTRA_IMAGE, carImagesArray[position]);
        // Ensure that we are notified in onActivityResult() when DisplayActivity closes
        startActivity(launchIntent);
    }
}

