package com.example.lab02.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab02.R;
import com.example.lab02.models.Person;
import com.example.lab02.repositories.PersonRepository;
import com.example.lab02.services.ServiceLocator;
import com.google.gson.Gson;

import java.io.Serializable;

public class ShowListActivity extends AppCompatActivity {

    private ListView lsvPersonas;
    private ArrayAdapter<Person> arrayAdapter;
    private PersonRepository dbSource = ServiceLocator.getInstance().getDBSource();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        lsvPersonas = findViewById(R.id.lsvPersonas);
        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, dbSource.getAllListPerson());
        lsvPersonas.setAdapter(arrayAdapter);

        // Click on element to Edit
        lsvPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person personaEncontrada = (Person)lsvPersonas.getAdapter().getItem((int)id);

                Person personaParaEditar = dbSource.getPersonById(personaEncontrada.getIdPersona());
                Intent intent = new Intent(ShowListActivity.this, EditPersonActivity.class);
                String personEdit = new Gson().toJson(personaParaEditar);

                intent.putExtra("personEdit", personEdit);
                startActivity(intent);
            }
        });

        lsvPersonas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ShowListActivity.this);
                builder.setTitle("Eliminar Persona");
                builder.setMessage("¿Estás seguro de que quieres eliminar a esta persona?");

                builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Person personaEncontrada = (Person)lsvPersonas.getAdapter().getItem((int)id);
                        dbSource.DeletePerson(personaEncontrada.getIdPersona());
                        arrayAdapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        arrayAdapter.notifyDataSetChanged();
        super.onResume();
    }
}