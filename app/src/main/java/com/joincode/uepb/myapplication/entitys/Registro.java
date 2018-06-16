package com.joincode.uepb.myapplication.entitys;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.sql.Timestamp;

@Entity
public class Registro {

    @PrimaryKey (autoGenerate = true)
    @NonNull
   private Timestamp dataRegisto;

   private String tipo;

   private int quantidade;

    public Registro(@NonNull Timestamp dataRegisto, String tipo, int quantidade) {
        this.dataRegisto = dataRegisto;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public String getRegistro(){
        return this.dataRegisto.toString();
    }

    @NonNull
    public Timestamp getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(@NonNull Timestamp dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
