package com.joincode.uepb.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Timestamp;

@Entity (tableName = "Lanchonete")
public class Lanchonete {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "localidade")
    private String localidade;

    @ColumnInfo(name = "responsavel")
    private String responsavel;

    @ColumnInfo(name = "horaAtend")
    private Timestamp horaAtend;
}
