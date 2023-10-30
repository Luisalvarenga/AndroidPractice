package com.example.labsqlite.Entidades;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personas implements Parcelable{
    @PrimaryKey(autoGenerate = true)
    public int idPersona;
    public String nombrePersona;
    public String apellidoPersona;
    public int edadPersona;
    @NonNull
    @Override
    public String toString() {
        return nombrePersona + " " + apellidoPersona + " " + edadPersona;
    }

    // Implementación de Parcelable
    public Personas() {
    }
    public Personas(Parcel in) {
        nombrePersona = in.readString();
        apellidoPersona = in.readString();
        edadPersona = in.readInt();
        idPersona = in.readInt();
    }

    public static final Parcelable.Creator<Personas> CREATOR = new Parcelable.Creator<Personas>() {
        @Override
        public Personas createFromParcel(Parcel in) {
            return new Personas(in);
        }

        @Override
        public Personas[] newArray(int size) {
            return new Personas[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombrePersona);
        dest.writeString(apellidoPersona);
        dest.writeInt(edadPersona);
        dest.writeInt(idPersona);
    }
}
