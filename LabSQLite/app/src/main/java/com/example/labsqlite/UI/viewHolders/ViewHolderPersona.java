package com.example.labsqlite.UI.viewHolders;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.labsqlite.R;

public class ViewHolderPersona extends RecyclerView.ViewHolder {
    private TextView NombrePersona;
    private TextView ApellidoPersona;
    private TextView EdadPersona;

    public TextView getNombrePersona() {
        return NombrePersona;
    }

    public TextView getApellidoPersona() {
        return ApellidoPersona;
    }

    public TextView getEdadPersona() {
        return EdadPersona;
    }

    public ViewHolderPersona(@NonNull View itemView) {
        super(itemView);
        this.NombrePersona = itemView.findViewById(R.id.txvNombrePersona);
        this.ApellidoPersona = itemView.findViewById(R.id.txvApellidoPersona);
        this.EdadPersona = itemView.findViewById(R.id.txvEdadPersona);
    }



}
