package com.joincode.uepb.myapplication.entitys;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "Lanchonete")
public class Lanchonete {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private @NonNull String nome;

    private @NonNull String localidade;

    private @NonNull String responsavel;

    private @NonNull String horaAtend;

    public Lanchonete(@NonNull String nome, @NonNull String localidade, @NonNull String responsavel, @NonNull String horaAtend) {
        this.nome = nome;
        this.localidade = localidade;
        this.responsavel = responsavel;
        this.horaAtend = horaAtend;
    }

    public String getLanchonete(){return this.nome;}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getHoraAtend() {
        return horaAtend;
    }

    public void setHoraAtend(String horaAtend) {
        this.horaAtend = horaAtend;
    }
}
