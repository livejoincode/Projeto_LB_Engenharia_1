package com.joincode.uepb.myapplication.view.controller;


import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.joincode.uepb.myapplication.Lanchonete;
import com.joincode.uepb.myapplication.negocio.model.LanchoneteModel;
import com.joincode.uepb.myapplication.R;
import com.joincode.uepb.myapplication.persistencia.DataBaseCreate;

public class LanchoneteController  extends Activity implements OnClickListener {

    private Button confirmar;
    private Button cancelar;

    private TextView nome;
    private TextView localidade;
    private TextView responsavel;
    private TextView horaAtend;

    private LanchoneteModel lanchoneteNegocio;
   //private DatabaseCreate dbCreate;
    private Lanchonete lanchonete;
    private TextView txv;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lanchonete);
/*
        DataBaseCreate db = Room.databaseBuilder(getApplicationContext(),
                DataBaseCreate.class, "franciscoDB").build();

        Lanchonete lanchoneteTable = new Lanchonete();

        lanchoneteTable.setId(1);
        lanchoneteTable.setNome("tô com fome UEPB");
        lanchoneteTable.setLocalidade("UEPB");
        lanchoneteTable.setHoraAtend("9h");

        db.lanchoneteDao().insert(lanchoneteTable);

        System.out.println(db.lanchoneteDao().getAll().toString());
        /*

        lanchoneteNegocio = new LanchoneteModel(this.getApplication());
        //dbCreate = new DatabaseCreate(this);

        nome = (TextView) findViewById(R.id.txtNome);
        localidade = (TextView) findViewById(R.id.txtLocal);
        responsavel = (TextView) findViewById(R.id.txtResponsavel);
       // horaAtend = (TextView) findViewById(R.id.txtHora);

        confirmar = (Button) findViewById(R.id.bntCadLancho);
        cancelar = (Button) findViewById(R.id.bntCancelar);

//        confirmar.setOnClickListener(this);
//        cancelar.setOnClickListener(this);
*/
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bntCadLancho:

                abrirTelaCadastro();
                break;

            /*case R.id.buttonEnviar:

                carro = recuperarInformacaoCarro();
                enviarCarro();
                limparCampos();

                break;

            case R.id.buttonExcluir:

                abrirTelaExclusao();
                break;*/
        }


    }
    private void abrirTelaCadastro() {

        Intent it = new Intent(this, BuscarLanchoneteController.class);
        startActivity(it);

    }

    /**
     * Abre a tela de exclusão.
     */
   /* private void abrirTelaExclusao() {

        Intent it = new Intent(this, ExcluirCarroController.class);
        startActivity(it);

    }*/
}
