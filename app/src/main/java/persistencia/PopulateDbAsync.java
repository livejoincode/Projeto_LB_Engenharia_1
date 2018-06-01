package persistencia;

import android.os.AsyncTask;
import dao.LanchoneteDao;
import entitys.Lanchonete;

//POde excluir não serve mais
class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final LanchoneteDao lDao;

    PopulateDbAsync(DataBaseCreate db) {
        lDao = db.lanchoneteDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        lDao.deleteAll();

        //essa inserção quando iniciar a aplicação já ter dados dentro do banco de dados
        Lanchonete lanchonete = new Lanchonete("Lanchonete 01", "", "", "");
        lDao.insert(lanchonete);
        return null;
    }
}
