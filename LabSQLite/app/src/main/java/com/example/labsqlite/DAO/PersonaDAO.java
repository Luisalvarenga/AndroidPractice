package com.example.labsqlite.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.labsqlite.Entidades.Personas;
import java.util.List;
@Dao
public interface PersonaDAO {
    @Insert
    void Insert(Personas personaEntity);
    @Update
    void Update(Personas personaEntity);
    @Delete
    void Delete(Personas personaEntity);
    @Query("SELECT * FROM PERSONAS")
    LiveData<List<Personas>> obtenerTodasLasPersonas();


}