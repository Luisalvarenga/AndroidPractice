package com.example.labrecyclerview.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.models.Trabajador;
import com.example.labrecyclerview.views.viewHolders.ViewHolderTrabajador;

import java.util.ArrayList;

public class TrabajadorAdapter extends RecyclerView.Adapter<ViewHolderTrabajador> {
    private ArrayList<Trabajador> datos;
    public TrabajadorAdapter(ArrayList<Trabajador> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolderTrabajador onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trabajadores,parent,false);
        return new ViewHolderTrabajador(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTrabajador holder, int position) {

        holder.getCodigoPersona().setText(String.valueOf(datos.get(position).getCodigoPersona()));
        holder.getNombrePersona().setText(datos.get(position).getNombrePersona() + " " + datos.get(position).getApellidoPersona());
        holder.getTipoTrabajador().setText(datos.get(position).getTipoTrabajador() == 1? "TC" : "TH" );
        holder.getTotalPagar().setText(Float.toString(datos.get(position).getTotalPagar()));
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }
}

