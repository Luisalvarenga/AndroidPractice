package com.example.labsqlite.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.labsqlite.Entidades.Personas;
import com.example.labsqlite.R;
import com.example.labsqlite.ViewModel.PersonaViewModel;

public class EditarPersona extends AppCompatActivity {

    private PersonaViewModel personaViewModel;
    EditText etNombres;
    EditText etApellidos;
    EditText etEdad;
    Button btnGuardarCambios;
    Personas editObject = new Personas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        personaViewModel = new ViewModelProvider(this).get(PersonaViewModel.class);
        // Find the included layout view by its ID
        etNombres = this.findViewById(R.id.etNombre);
        etApellidos= this.findViewById(R.id.etApellido);
        etEdad = this.findViewById(R.id.etEdad);
        btnGuardarCambios = this.findViewById(R.id.btnGuardarCambios);

        Intent intent = getIntent();
        if (intent.hasExtra("personaEditar")) {
            editObject = intent.getParcelableExtra("personaEditar");
        }

        etNombres.setText(editObject.nombrePersona == null ? "" : editObject.nombrePersona);
        etApellidos.setText(editObject.apellidoPersona== null ? "" : editObject.apellidoPersona);
        etEdad.setText(String.valueOf(editObject.edadPersona));

        btnGuardarCambios.setOnClickListener(v -> {
            editObject.nombrePersona = etNombres.getText().toString();
            editObject.apellidoPersona = etApellidos.getText().toString();
            editObject.edadPersona = Integer.parseInt(etEdad.getText().toString());
            personaViewModel.updatePersona(editObject);
            finish();
        });
    }
}