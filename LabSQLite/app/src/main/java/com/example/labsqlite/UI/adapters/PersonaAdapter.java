package com.example.labsqlite.UI.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labsqlite.Entidades.Personas;
import com.example.labsqlite.R;
import com.example.labsqlite.UI.viewHolders.ViewHolderPersona;

import java.util.ArrayList;

public class PersonaAdapter extends RecyclerView.Adapter<ViewHolderPersona> {
    private ArrayList<Personas> datos;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onlongClickListener;

    public PersonaAdapter(ArrayList<Personas> datos, OnItemClickListener itemClickListener, OnItemLongClickListener longClickListener) {
        this.datos = datos;
        this.onItemClickListener = itemClickListener;
        this.onlongClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona,parent,false);
        return new ViewHolderPersona(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersona holder, int position) {

        final Personas PersonaItem = datos.get(position);


        holder.getNombrePersona().setText(String.valueOf(PersonaItem.nombrePersona));
        holder.getApellidoPersona().setText(String.valueOf(PersonaItem.apellidoPersona));
        holder.getEdadPersona().setText(String.valueOf(PersonaItem.edadPersona));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(PersonaItem);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                if (onlongClickListener != null) {
                    onlongClickListener.OnItemPressed(PersonaItem);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public interface OnItemClickListener{
        void onItemClick(Personas mainObject);
    }

    public interface OnItemLongClickListener{
        void OnItemPressed(Personas mainObject);
    }

}

