package com.joincode.uepb.myapplication.persistencia;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.joincode.uepb.myapplication.Lanchonete;
import com.joincode.uepb.myapplication.negocio.model.LanchoneteDao;

/*
AppDatabase
 */

@Database(entities = {Lanchonete.class}, version = 1)
public abstract class DataBaseCreate extends RoomDatabase{

    public abstract LanchoneteDao lanchoneteDao();

}
