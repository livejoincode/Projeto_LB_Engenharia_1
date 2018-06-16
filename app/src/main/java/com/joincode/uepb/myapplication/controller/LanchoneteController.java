package com.joincode.uepb.myapplication.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joincode.uepb.myapplication.R;


import com.joincode.uepb.myapplication.model.LanchoneteViewModel;

public class LanchoneteController  extends AppCompatActivity{

    public static final String EXTRA_REPLY = "com.example.android.Lanchonetelistsql.REPLY";
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private TextInputLayout mEditWordView;

    //visão do usuário
    private LanchoneteViewModel lViewModel;

    private EditText tilNome;
    private EditText tilLocalidade;
    private EditText tilResponsavel;
    private EditText tilHoraAtend;

    //private LanchoneteModel lanchoneteNegocio;
    //private LanchoneteViewModel lviewModel;
    //private Lanchonete lanchonete;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastro_lanchonete);
        tilNome = findViewById(R.id.txtNome);
        tilLocalidade = findViewById(R.id.txtLocal);
        tilResponsavel = findViewById(R.id.txtResponsavel);
        tilHoraAtend = findViewById(R.id.txthoraAtendimento);

        final Button button = findViewById(R.id.bntCadLancho);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(tilNome.getText()) || TextUtils.isEmpty(tilLocalidade.getText()) || TextUtils.isEmpty(tilResponsavel.getText()) || TextUtils.isEmpty(tilHoraAtend.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.empty_not_saved,
                            Toast.LENGTH_LONG).show();
                } else {
                    String nome = tilNome.getText().toString();
                    String local = tilLocalidade.getText().toString();
                    String responsavel = tilResponsavel.getText().toString();
                    String horaAtend = tilHoraAtend.getText().toString();

                    replyIntent.putExtra(EXTRA_REPLY, horaAtend);
                    setResult(RESULT_OK, replyIntent);

                    replyIntent.putExtra(EXTRA_REPLY, responsavel);
                    setResult(RESULT_OK, replyIntent);

                    replyIntent.putExtra(EXTRA_REPLY, local);
                    setResult(RESULT_OK, replyIntent);

                    replyIntent.putExtra(EXTRA_REPLY, nome);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }


}
