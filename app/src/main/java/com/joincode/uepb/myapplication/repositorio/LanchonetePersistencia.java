package com.joincode.uepb.myapplication.repositorio;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.joincode.uepb.myapplication.entitys.Lanchonete;
import com.joincode.uepb.myapplication.dao.LanchoneteDao;

import java.util.List;

public class LanchonetePersistencia {


    //variavel de acesso aos dados
    private LanchoneteDao lanchoneteDao;
    //lista de todas as lanchonetes do banco de dados
    private LiveData<List<Lanchonete>> lanchonetesAlls;
    protected DataBaseCreate lBanco;

    public LanchonetePersistencia(Application application) {
        //isto não é uma nova instância do banco, pois uma vez criada a instância do Banco na Classe DataBaseCreate, embora tente criar uma nova instância
        // o método getDatabase que utiliza do singleton retornará a instância original já criada primeiramente.
        DataBaseCreate db = DataBaseCreate.getDatabase(application);
        lanchoneteDao = db.lanchoneteDao();
        lanchonetesAlls = lanchoneteDao.getAll();
    }

    public LiveData<List<Lanchonete>> getAllLanchonetes() {
        return lanchonetesAlls;
    }

    //insira uma lanchonete de forma sincronizada
    public void insert (Lanchonete lancho) {
        new insertAsyncTask(lanchoneteDao).execute(lancho);
    }

    //Nova Classe que extende de AsyncTask que fará a parte de sicronização
    private static class insertAsyncTask extends AsyncTask <Lanchonete, Void, Void> {

        private LanchoneteDao mAsyncTaskDao;

        insertAsyncTask(LanchoneteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Lanchonete... params) {
            mAsyncTaskDao.insert(params[0]);
            //aqui onde limpa ew insere assim que inicializa o app
            return null;
        }
    }

}
