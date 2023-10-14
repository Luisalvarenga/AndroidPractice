package com.example.labrecyclerview.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.databinding.ActivityListTrabajadoresBinding;
import com.example.labrecyclerview.databinding.ActivityMainBinding;
import com.example.labrecyclerview.models.Trabajador;
import com.example.labrecyclerview.repositories.TrabajadorRespository;
import com.example.labrecyclerview.services.ServiceLocator;
import com.example.labrecyclerview.views.adapters.TrabajadorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuracion de viewbinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAgregarTrabajador.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SelectTipoTrabajador.class));
        });

        binding.btnMostrar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListTrabajadores.class));
            //ok

        });
        binding.btnAcerca.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
            }
        });

    }
}