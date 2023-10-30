package com.example.labsqlite.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.labsqlite.R;

public class MainActivity extends AppCompatActivity {
    private Button btnAgregarPersonas;
    private Button btnListarPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregarPersonas = findViewById(R.id.btnAgregarPersona);
        btnListarPersonas = findViewById(R.id.btnListarPersonas);

        btnAgregarPersonas.setOnClickListener(v -> {
          startActivity(new Intent(this, AgregarPersona.class));
        });

        btnListarPersonas.setOnClickListener(v -> {
            startActivity(new Intent(this, ListPersonas.class));
        });

    }
}
