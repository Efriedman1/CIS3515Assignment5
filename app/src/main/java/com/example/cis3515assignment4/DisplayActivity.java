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

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int res_image = bundle.getInt("image");
            imageView.setImageResource(res_image);
            textView.setText(getIntent().getExtras().getString("name"));
        }

    }

}