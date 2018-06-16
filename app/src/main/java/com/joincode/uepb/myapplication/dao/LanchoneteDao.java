package com.joincode.uepb.myapplication.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.joincode.uepb.myapplication.entitys.Lanchonete;

import java.util.List;

@Dao
public interface LanchoneteDao {

    @Insert
    void insert (Lanchonete lanchonete);

    @Query("DELETE FROM Lanchonete")
    void deleteAll();

    @Update
    int update (Lanchonete lanchonete);

    @Query("SELECT * FROM Lanchonete ORDER BY nome ASC")
    LiveData<List<Lanchonete>> getAll();




}
