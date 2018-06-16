package com.joincode.uepb.myapplication.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.joincode.uepb.myapplication.controller.ProdutoController;
import com.joincode.uepb.myapplication.R;

import java.util.List;

import com.joincode.uepb.myapplication.controller.LanchoneteController;
import com.joincode.uepb.myapplication.entitys.Lanchonete;
import com.joincode.uepb.myapplication.model.LanchoneteViewModel;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    /*
    Além disso onCreate(), adicione um observador para o LiveData retornado por getAllWords().
    O onChanged() método é disparado quando os dados observados são alterados e a atividade está em primeiro plano.
     */
    private LanchoneteViewModel lViewModel;

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lanchonete);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final LanchoneteListAdapter adapter = new LanchoneteListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //captura o click das recycleterViews e muda para a tela de registro
        adapter.setOnItemClickListener(new LanchoneteListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), ProdutoController.class);
                startActivity(intent);
            }
        });

        //Conecte-se com os dados, tudo apartir da classe LanchoneteViewModel que se encarrega de
        // acessar o repositório, que por sua vez acessa o banco de dados SQLite através da biblioteca ROOM
        lViewModel = ViewModelProviders.of(this).get(LanchoneteViewModel.class);

        lViewModel.getAllLanchotetes().observe(this, new Observer<List<Lanchonete>>() {
            @Override
            public void onChanged(@Nullable final List<Lanchonete> lanchos) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(lanchos);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LanchoneteController.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);

            /*isso era uma mensagem que aparecia para mostrar alguma ação ao precionar o botão
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            */
            }
        });

       /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        */
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Lanchonete lanchonete = new Lanchonete(
                    data.getStringExtra(LanchoneteController.EXTRA_REPLY),
                    data.getStringExtra(LanchoneteController.EXTRA_REPLY),
                    data.getStringExtra(LanchoneteController.EXTRA_REPLY),
                    data.getStringExtra(LanchoneteController.EXTRA_REPLY));
            lViewModel.insert(lanchonete);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lanchonete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
