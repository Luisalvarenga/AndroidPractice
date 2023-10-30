package com.example.labsqlite.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.labsqlite.Entidades.Personas;
import com.example.labsqlite.R;
import com.example.labsqlite.UI.adapters.PersonaAdapter;
import com.example.labsqlite.ViewModel.PersonaViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListPersonas extends AppCompatActivity implements PersonaAdapter.OnItemClickListener, PersonaAdapter.OnItemLongClickListener{

    private PersonaViewModel personaViewModel;
    private PersonaAdapter personaAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_personas);


        personaViewModel = new ViewModelProvider(this).get(PersonaViewModel.class);

        LiveData<List<Personas>> liveDataPersonas = personaViewModel.getListaDePersonas();

        liveDataPersonas.observe(this, personas -> {
            // Configurando adaptador
            personaAdapter = new PersonaAdapter((ArrayList<Personas>) personas, ListPersonas.this, ListPersonas.this);
            layoutManager = new LinearLayoutManager(this);
            recyclerView = findViewById(R.id.rcvPersonas);
            recyclerView.setAdapter(personaAdapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
        });
    }

    @Override
    public void onItemClick(Personas mainObject) {
        Intent intent = new Intent(this, EditarPersona.class);
        intent.putExtra("personaEditar", mainObject);
        startActivity(intent);
    }

    @Override
    public void OnItemPressed(Personas mainObject) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmar Borrar");
        builder.setMessage("Está seguro de borrar el registro?");
        builder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                personaViewModel.deletePersona(mainObject);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}