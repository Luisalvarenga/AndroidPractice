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

public class AddPersonActivity extends AppCompatActivity {

    private PersonRepository dbSource = ServiceLocator.getInstance().getDBSource();

    EditText edtNombre, edtApellido, edtEdad, edtCorreo;
    Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        edtNombre = findViewById(R.id.edtNombreN);
        edtApellido = findViewById(R.id.edtApellidoN);
        edtEdad = findViewById(R.id.edtEdadN);
        edtCorreo = findViewById(R.id.edtCorreoN);
        btnProcesar = findViewById(R.id.btnGuardarNuevo);

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbSource.AddPerson(new Person(0,edtNombre.getText().toString(),
                        edtApellido.getText().toString(), Integer.parseInt(edtEdad.getText().toString()),
                        edtCorreo.getText().toString()) );

                Toast.makeText(AddPersonActivity.this, "Inserción exitosa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}