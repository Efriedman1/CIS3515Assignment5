package com.example.cis3515assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class DisplayActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.TextView);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");

        textView.setText(i.getStringExtra(SelectionActivity.EXTRA_DESCRIPTION));
        imageView.setImageResource(i.getIntExtra(SelectionActivity.EXTRA_IMAGE, R.drawable.ic_launcher_foreground));

        }
    }

