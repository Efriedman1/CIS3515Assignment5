package com.example.cis3515assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SelectionActivity extends AppCompatActivity {


    public static final String EXTRA_DESCRIPTION = String.valueOf(R.string.description);
    public static final String EXTRA_IMAGE = String.valueOf(R.string.image);

  //  ImageView imageView;
    GridView gridView;

    Context context;

    int[] carImagesArray;
    ArrayList<String> carsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set label
        //getSupportActionBar().setTitle("Item Select");
        getSupportActionBar().setTitle(getString(R.string.actionBarTitle));
        //getSupportActionBar().setTitle(String.valueOf(R.string.actionBarTitle));

        gridView = findViewById(R.id.gridView);
        gridView.setNumColumns(3);

        Resources res = getResources();
        String[] carsArray = res.getStringArray(R.array.carsArray);
        List<String> cars = Arrays.asList(res.getStringArray(R.array.carsArray));
        ArrayList<String> carsList = new ArrayList<String>(cars);
        
//        carsArray = new ArrayList<String>();
//        carsArray.add("Camaro");
//        carsArray.add("Charger");
//        carsArray.add("Gallardo");
//        carsArray.add("Mustang");
//        carsArray.add("488 Spider");


//        carsArray.add(String.valueOf(R.string.carOne));
//        carsArray.add(String.valueOf(R.string.carTwo));
//        carsArray.add(String.valueOf(R.string.carThree));
//        carsArray.add(String.valueOf(R.string.carFour));
//        carsArray.add(String.valueOf(R.string.carFive));

        carImagesArray = new int[]{R.drawable.camaro, R.drawable.charger, R.drawable.gallardo, R.drawable.mustang, R.drawable.spider488};
        ImageAdapter adapter = new ImageAdapter(this, carsList, carImagesArray);
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

