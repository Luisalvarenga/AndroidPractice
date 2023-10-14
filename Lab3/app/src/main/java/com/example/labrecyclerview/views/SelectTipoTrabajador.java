package com.example.labrecyclerview.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.databinding.ActivityAgregarTrabajadorHoraBinding;
import com.example.labrecyclerview.databinding.ActivitySelectTipoTrabajadorBinding;

public class SelectTipoTrabajador extends AppCompatActivity {

    private ActivitySelectTipoTrabajadorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuracion de viewbinding
        binding = ActivitySelectTipoTrabajadorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ((RadioButton)binding.rgTrabajadores.getChildAt(0)).setChecked(true);

        binding.btnSiguiente.setOnClickListener(v -> {
            RadioButton selectedRadioButton = findViewById(binding.rgTrabajadores.getCheckedRadioButtonId());
            boolean idSelected = selectedRadioButton.getText().toString().contains("hora");
            finish();
            startActivity(new Intent(SelectTipoTrabajador.this, idSelected ? AgregarTrabajadorHora.class : AgregarTrabajadorCompleto.class ));
        });
    }


}