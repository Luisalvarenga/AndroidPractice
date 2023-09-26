package com.example.labrecyclerview.views.viewHolders;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.labrecyclerview.R;

public class ViewHolderTrabajador extends RecyclerView.ViewHolder {
    private TextView codigoPersona;
    private TextView nombrePersona;
    private TextView tipoTrabajador;
    private TextView totalPagar;


    public ViewHolderTrabajador(@NonNull View itemView) {
        super(itemView);
        this.codigoPersona = itemView.findViewById(R.id.txvCodigoPersona);
        this.nombrePersona = itemView.findViewById(R.id.txvNombrePersona);
        this.tipoTrabajador = itemView.findViewById(R.id.txvTipoTrabajador);
        this.totalPagar = itemView.findViewById(R.id.txvTotalTrabajador);
    }

    public TextView getCodigoPersona() {
        return codigoPersona;
    }

    public TextView getNombrePersona() {
        return nombrePersona;
    }

    public TextView getTipoTrabajador() {
        return tipoTrabajador;
    }

    public TextView getTotalPagar() {
        return totalPagar;
    }
}
