package com.joincode.uepb.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_main);
       //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
   //    setSupportActionBar(toolbar);

        //Define a relação da classe com a visualização XML
       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //Faz o listener para quando o objeto (botão) for pressionado acionar uma determinada ação
     //   fab.setOnClickListener(new View.OnClickListener() {
     //       @Override
            //Quando for pressionado o botão, execute esta ação.
    //        public void onClick(View view) {
     //           Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
     //                   .setAction("Action", null).show();
     //       }
    //    });
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
