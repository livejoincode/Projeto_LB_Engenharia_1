package com.joincode.uepb.myapplication.entitys;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Produto {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @NonNull
    private String nome;

    private String descricao;

    private String tipo;

    @NonNull
    private float preco;

    public Produto(@NonNull int id, @NonNull String nome, String descricao, String tipo, @NonNull float preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getProduto(){
        return this.nome;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @NonNull
    public float getPreco() {
        return preco;
    }

    public void setPreco(@NonNull float preco) {
        this.preco = preco;
    }
}
