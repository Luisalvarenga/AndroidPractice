package com.example.labsqlite.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labsqlite.Entidades.Personas;
import com.example.labsqlite.R;
import com.example.labsqlite.ViewModel.PersonaViewModel;

public class AgregarPersona extends AppCompatActivity {

    private PersonaViewModel personaViewModel;
    EditText etNombres;
    EditText etApellidos;
    EditText etEdad;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);
        //elementosEditables = this.findViewById(R.id.et);
        personaViewModel = new ViewModelProvider(this).get(PersonaViewModel.class);


        // Find the included layout view by its ID
        etNombres = this.findViewById(R.id.etNombre);
        etApellidos= this.findViewById(R.id.etApellido);
        etEdad = this.findViewById(R.id.etEdad);
        btnGuardar = this.findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {
            Personas finalObject = new Personas();
            finalObject.nombrePersona = etNombres.getText().toString();
            finalObject.apellidoPersona = etApellidos.getText().toString();
            finalObject.edadPersona = Integer.parseInt(etEdad.getText().toString());
            personaViewModel.insertPersona(finalObject);
            finish();
        });

    }
}