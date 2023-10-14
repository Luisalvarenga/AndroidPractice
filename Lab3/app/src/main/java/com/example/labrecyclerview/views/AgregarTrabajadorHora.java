package com.example.labrecyclerview.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.databinding.ActivityAgregarTrabajadorHoraBinding;
import com.example.labrecyclerview.databinding.ActivitySelectTipoTrabajadorBinding;
import com.example.labrecyclerview.models.TrabajadorHora;
import com.example.labrecyclerview.repositories.TrabajadorRespository;
import com.example.labrecyclerview.services.ServiceLocator;
import com.google.android.material.textfield.TextInputEditText;

public class AgregarTrabajadorHora extends AppCompatActivity {

    private ActivityAgregarTrabajadorHoraBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TrabajadorRespository dbSource = ServiceLocator.getInstance().getDBSource();

        super.onCreate(savedInstanceState);

        // Configuracion de viewbinding
        binding = ActivityAgregarTrabajadorHoraBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAgregarTH.setOnClickListener(v -> {

            if (validateFields()){
                if (dbSource.getTrabajadorById(binding.etId.getText().toString())!= null){
                    Toast.makeText(getApplicationContext(), "No se puede usar este ID", Toast.LENGTH_SHORT).show();
                }
                else{

                   if( dbSource.AddTrabajador(new TrabajadorHora(
                           binding.etId.getText().toString(),
                           binding.etNombre.getText().toString(),
                           binding.etApellido.getText().toString(),
                           Integer.parseInt(binding.etHoras.getText().toString()),
                           Float.parseFloat(binding.etValor.getText().toString() )))){

                       AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                       alertDialogBuilder.setTitle("Registrado!");
                       alertDialogBuilder.setMessage("Registrado con éxito");
                       alertDialogBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               finish();
                           }
                       });

                       alertDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                           @Override
                           public void onCancel(DialogInterface dialogInterface) {
                               finish();
                           }
                       });

                       AlertDialog alertDialog = alertDialogBuilder.create();
                       alertDialog.show();
                   }
                   else{
                       new AlertDialog.Builder(AgregarTrabajadorHora.this)
                               .setTitle("Error!")
                               .setMessage("No se pudo guardar el registro")
                               .setPositiveButton("Aceptar", null)
                               .show();
                   }
                }
            }
        });

    }

    private boolean validateFields(){
        if (binding.etId.getText().toString().isEmpty() ||
                binding.etNombre.getText().toString().isEmpty()||
                binding.etApellido.getText().toString().isEmpty() ||
                binding.etEdad.getText().toString().isEmpty() ||
                binding.etValor.getText().toString().isEmpty()||
                binding.etHoras.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Rellene todos los campos para continuar", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}