package view;

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
import android.widget.Toolbar;

import com.joincode.uepb.myapplication.R;

import java.util.List;

import controller.LanchoneteController;
import entitys.Lanchonete;
import model.LanchoneteViewModel;

public class MainActivity extends AppCompatActivity {

    /*
    Além disso onCreate(), adicione um observador para o LiveData retornado por getAllWords().
    O onChanged() método é disparado quando os dados observados são alterados e a atividade está em primeiro plano.
     */
    private LanchoneteViewModel lViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lanchonete);

        //Conecte-se com os dados, tudo apartir da classe LanchoneteViewModel que se encarrega de
        // acessar o repositório, que por sua vez acessa o banco de dados SQLite através da biblioteca ROOM
        lViewModel = ViewModelProviders.of(this).get(LanchoneteViewModel.class);


        //forma de exibir os dados na tela mas não vai ser no MainActivity, ver onde melhor se encaixa
/*
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final LanchoneteListAdapter adapter = new LanchoneteListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //não sei se dá certo, parece que deu certo kkk
                startActivity(new Intent(new Intent(getApplicationContext(),
                                LanchoneteController.class/*LanchoneteViewModel.class)*/)));

            //isso era uma mensagem que aparecia para mostrar alguma ação ao precionar o botão
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                        */
            }
        });

       //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);

/*
        lViewModel.getAllLanchotetes().observe(this, new Observer<List<Lanchonete>>() {
            @Override
            public void onChanged(@Nullable final List<Lanchonete> lanchos) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(lanchos);
            }
        });
        */
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
