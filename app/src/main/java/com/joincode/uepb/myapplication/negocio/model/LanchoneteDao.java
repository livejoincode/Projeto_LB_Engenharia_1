package com.joincode.uepb.myapplication.negocio.model;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.joincode.uepb.myapplication.Lanchonete;

import java.util.List;

public interface LanchoneteDao {

    @Insert
    void insert (Lanchonete lanchonete);

    @Delete
    int deleteAll(Lanchonete[] lanchonetes);

    @Update
    int update (Lanchonete lanchonete);

    @Query("SELECT nome FROM Lanchonete" +
            "WHERE id LIKE :id")
    List<Lanchonete> findLanchonetesByName(int id);

}
