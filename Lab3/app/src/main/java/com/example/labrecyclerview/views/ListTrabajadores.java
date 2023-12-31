package com.example.labrecyclerview.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.databinding.ActivityListTrabajadoresBinding;
import com.example.labrecyclerview.databinding.ActivityLoginBinding;
import com.example.labrecyclerview.models.Trabajador;
import com.example.labrecyclerview.repositories.TrabajadorRespository;
import com.example.labrecyclerview.services.ServiceLocator;
import com.example.labrecyclerview.views.adapters.TrabajadorAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListTrabajadores extends AppCompatActivity implements TrabajadorAdapter.OnItemClickListener{

    private ActivityListTrabajadoresBinding binding;
    private TrabajadorAdapter personaAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuracion de viewbinding
        binding = ActivityListTrabajadoresBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setContentView(R.layout.activity_list_trabajadores);

        TrabajadorRespository dbSource = ServiceLocator.getInstance().getDBSource();
        List<Trabajador> listaTrabajadores = dbSource.getAllListTrabajadores();

        // Configurando adaptador
        personaAdapter = new TrabajadorAdapter((ArrayList<Trabajador>) listaTrabajadores, ListTrabajadores.this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.rcvTrabajadores);
        recyclerView.setAdapter(personaAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onItemClick(Trabajador persona) {
        Toast.makeText(this, "Esta es un prueba", Toast.LENGTH_SHORT).show();
    }
}