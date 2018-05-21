package controller;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import entitys.Lanchonete;
import model.LanchoneteModel;
import com.joincode.uepb.myapplication.R;
import model.LanchoneteViewModel;
import persistencia.DataBaseCreate;
import view.LanchoneteListAdapter;

//Tudo que está aqui em lanchoneteContorller deveria estar no main activity
//mas isto é apenas um teste
public class LanchoneteController  extends Activity implements OnClickListener {

   //visão do usuário
    private LanchoneteViewModel lViewModel;

    private Button confirmar;
    private Button cancelar;


    private String nome;
    private String localidade;
    private String responsavel;
    private String horaAtend;

    private TextInputLayout tilNome;
    private TextInputLayout tilLocalidade;
    private TextInputLayout tilResponsavel;
    private TextInputLayout tilHoraAtend;

    private LanchoneteModel lanchoneteNegocio;
    private LanchoneteViewModel lviewModel;
    private Lanchonete lanchonete;
    private TextView txv;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastro_lanchonete);

        //talvez seja aqui o lugar de inserir os dados no banco de dados chamando tudo a partir da classe model
        //não sei se os dados devem ser inseridos antes de criar o vielmodel ou depois, vou tentar depois
        //lviewModel = new LanchoneteViewModel(getApplication());





        //Lanchonete lanchoneteTable = new Lanchonete();
        //lanchoneteTable.setId(1);
        //lanchoneteTable.setNome("tô com fome UEPB");
        //lanchoneteTable.setLocalidade("UEPB");
        //lanchoneteTable.setHoraAtend("9h");

        //db.lanchoneteDao().insert(lanchoneteTable);



        /*
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final LanchoneteListAdapter adapter = new LanchoneteListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LanchoneteController.this, LanchoneteViewModel.class));
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }

        });
        */


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
                 /*
                Os dados devem ser inseridos preenchendo os Inputfields e clicando em cadastrar chamando o método de inserir
                */
                nome = tilNome.getEditText().toString() ;
                localidade = tilLocalidade.getEditText().toString();
                responsavel = tilResponsavel.getEditText().toString();
                horaAtend = tilHoraAtend.getEditText().toString();

                lanchonete = new Lanchonete(nome, localidade, responsavel, horaAtend);
                try {
                    lviewModel.insert(lanchonete);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
