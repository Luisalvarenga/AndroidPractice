package com.example.lab02.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab02.R;
import com.example.lab02.repositories.PersonRepository;
import com.example.lab02.services.ServiceLocator;

public class MainActivity extends AppCompatActivity {

    private Button btnAbout, btnShowPersonList,btnAddPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbout = findViewById(R.id.btnAbout);
        btnShowPersonList = findViewById(R.id.btnShowPersonList);
        btnAddPerson = findViewById(R.id.btnAddPerson);

        btnAbout.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
        });

        btnShowPersonList.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ShowListActivity.class));
        });

        btnAddPerson.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddPersonActivity.class));
        });

    }
}