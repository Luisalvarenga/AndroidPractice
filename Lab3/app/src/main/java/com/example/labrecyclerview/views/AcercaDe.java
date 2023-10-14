package com.example.labrecyclerview.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.databinding.ActivityAcercaDeBinding;
import com.example.labrecyclerview.databinding.ActivityAgregarTrabajadorCompletoBinding;

public class AcercaDe extends AppCompatActivity {

    private ActivityAcercaDeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuracion de viewbinding
        binding = ActivityAcercaDeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}