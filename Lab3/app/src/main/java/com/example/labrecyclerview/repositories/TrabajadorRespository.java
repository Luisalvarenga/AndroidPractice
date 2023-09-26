package com.example.labrecyclerview.repositories;


import com.example.labrecyclerview.models.Trabajador;
import com.example.labrecyclerview.models.TrabajadorHora;
import com.example.labrecyclerview.models.TrabajadorTiempoCompleto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrabajadorRespository {

    List<Trabajador> mainList;


    public TrabajadorRespository(){
        mainList = new ArrayList<>();
        TrabajadorTiempoCompleto tc1 = new TrabajadorTiempoCompleto("1", "Juan", "Perez", 800){};
        TrabajadorTiempoCompleto tc2 = new TrabajadorTiempoCompleto("2", "Miguel", "Sosa", 900){};
        TrabajadorHora th1 = new TrabajadorHora("3", "Maria", "Garcia", 8, (float)6.25 ){};

        mainList.add(tc1);
        mainList.add(tc2);
        mainList.add(th1);

    }

    public List<Trabajador> getAllListTrabajadores(){
        return this.mainList;
    }

    public Trabajador getTrabajadorById(String idMainObject){
        for (Trabajador person : mainList) {
            if (Objects.equals(person.getCodigoPersona(), idMainObject)) {
                return person;
            }
        }
        return null;
    }

    public boolean AddTrabajador(Trabajador mainObject) {
        return this.mainList.add(mainObject);
    }
}
