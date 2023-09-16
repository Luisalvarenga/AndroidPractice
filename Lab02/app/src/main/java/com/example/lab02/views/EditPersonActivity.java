package com.example.lab02.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab02.R;
import com.example.lab02.models.Person;
import com.example.lab02.repositories.PersonRepository;
import com.example.lab02.services.ServiceLocator;
import com.google.gson.Gson;

public class EditPersonActivity extends AppCompatActivity {

    private PersonRepository dbSource = ServiceLocator.getInstance().getDBSource();
    private EditText edtNombre, edtApellido, edtEdad, edtCorreo;
    private Button btnGuardar;
    private Person personaAEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);

        edtNombre = findViewById(R.id.edtNombreN);
        edtApellido = findViewById(R.id.edtApellidoN);
        edtEdad = findViewById(R.id.edtEdadN);
        edtCorreo = findViewById(R.id.edtCorreoN);
        btnGuardar = findViewById(R.id.btnGuardarNuevo);

        String personEdit = getIntent().getStringExtra("personEdit");
        Gson gson = new Gson();

        personaAEditar = gson.fromJson(personEdit, Person.class);;

        if (personaAEditar != null) {
            edtNombre.setText(personaAEditar.getNombrePersona());
            edtApellido.setText(personaAEditar.getApellidoPersona());
            edtEdad.setText(String.valueOf(personaAEditar.getEdadPersona())); // Cambiado a getEdadPersona()
            edtCorreo.setText(personaAEditar.getCorreoPersona()); // Cambiado a getCorreoPersona()
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (personaAEditar != null) {
                    personaAEditar.setNombrePersona(edtNombre.getText().toString());
                    personaAEditar.setApellidoPersona(edtApellido.getText().toString());
                    personaAEditar.setEdadPersona(Integer.parseInt(edtEdad.getText().toString()));
                    personaAEditar.setCorreoPersona(edtCorreo.getText().toString());

                    dbSource.EditPerson(personaAEditar);

                    Toast.makeText(EditPersonActivity.this, "Cambios guardados", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });



    }
}