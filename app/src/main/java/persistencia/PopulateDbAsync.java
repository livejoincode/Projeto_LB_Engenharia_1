package persistencia;

import android.os.AsyncTask;
import dao.LanchoneteDao;
import entitys.Lanchonete;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final LanchoneteDao lDao;

    PopulateDbAsync(DataBaseCreate db) {
        lDao = db.lanchoneteDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        //lDao.deleteAll();

        //essa inserção quando iniciar a aplicação já ter dados dentro do banco de dados
        /*
        Lanchonete lanchonete = new Lanchonete(
                "tocomfome Uepb", "uepb", "francisco","9");

        lDao.insert(lanchonete);
         //  lanchonete = new Lanchonete("World");
      //  lDao.insert(lanchonete);
*/
        return null;
    }
}
