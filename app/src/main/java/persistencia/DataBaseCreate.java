package persistencia;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import entitys.Lanchonete;
import dao.LanchoneteDao;

//A versão do banco de dados é importante caso seja necessário fazer uma migração
// Seu esquema mudou? Apenas aumente a versão do banco de dados e escreva uma nova implementação de Migration.

@Database(entities = {Lanchonete.class}, version = 1, exportSchema = false)
public abstract class DataBaseCreate extends RoomDatabase{

    public abstract LanchoneteDao lanchoneteDao();

    private static DataBaseCreate INSTANCE;

    /*Método pelo padrão singleton para evitar ter várias instâncias do banco de dados aberto ao mesmo tempo.*/
    public static DataBaseCreate getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBaseCreate.class) {
                if (INSTANCE == null) {
                    //Banco de Dados sendo instanciado uma única vez em toda a execução do aplicativo.
                    // Usa o construtor de banco de dados do Room para criar um objeto RoomDatabase
                    // no contexto do aplicativo a partir da classe DataBaseCreate e nomeá-la "francisco.db".
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataBaseCreate.class, "francisco.db").addCallback(sRoomDatabaseCallback).build();
                    //Execute aqui uma das migrações caso precise.
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                   // new PopulateDbAsync(INSTANCE).execute();
                }
            };


    class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final LanchoneteDao lDao;

        PopulateDbAsync(DataBaseCreate db) {
            lDao = db.lanchoneteDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            lDao.deleteAll();
            //essa inserção quando iniciar a aplicação já ter dados dentro do banco de dados
            Lanchonete lanchonete = new Lanchonete("Lanchonete 01", "uepb", "Francisco", "9");
            lDao.insert(lanchonete);
            return null;
        }
    }





    /*Caso necessite mudar de esquema o Room precisa receber os mesmos dados sem perda de dados para um novo schema de migração*/

    //Caso seja necessário migrar o Banco para não alterar nada no schema.
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //Como não alteramos a tabela, não há mais nada a fazer aqui.
        }
        //Execute isso na instâcia do Banco
        /*INSTANCE =  Room.databaseBuilder(context.getApplicationContext(),
         DataBaseCreate.class, "francisco.db").addMigrations(MIGRATION_1_2).build();
        */
        };

    //Mingração para adicionar mais uma coluna em uma tabela sem perder os dados
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE nomedatabela "
                    + " ADD COLUMN novacoluna INTEGER");
        }
        //Execute isso na instância do Banco
        /*INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
        DataBaseCreate.class, "francisco.db")
        .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
        .build();*/
    };

    //Migração para excluir uma tabela e colocar outra em seu lugar sem preder os dados
    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Create the new table
            database.execSQL(
                    "CREATE TABLE users_new (userid TEXT, username TEXT, last_update INTEGER, PRIMARY KEY(userid))");
            // Copy the data
            database.execSQL(
                    "INSERT INTO users_new (userid, username, last_update) SELECT userid, username, last_update FROM users");
            // Remove the old table
            database.execSQL("DROP TABLE users");
            // Change the table name to the correct one
            database.execSQL("ALTER TABLE users_new RENAME TO users");
        }
        //Execute isto na instância do Banco
        /*INSTANCE = Room. databaseBuilder (context.getApplicationContext (),
        DataBaseCreate.class, "francisco.db")
                . addMigrations ( MIGRATION_1_2 , MIGRATION_2_3 , MIGRATION_3_4).build ();
        */
    };


    //Caso queira migrar seu banco de dados da versão 1 diretamente para 4 faça o seguinte
    static final Migration MIGRATION_1_4 = new Migration(1, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Create the new table
            database.execSQL(
                    "CREATE TABLE users_new (userid TEXT, username TEXT, last_update INTEGER, PRIMARY KEY(userid))");

            // Copy the data
            database.execSQL(
                    "INSERT INTO users_new (userid, username, last_update) SELECT userid, username, last_update FROM users");
            // Remove the old table
            database.execSQL("DROP TABLE users");
            // Change the table name to the correct one
            database.execSQL("ALTER TABLE users_new RENAME TO users");
        }
        //Execute isto na instância do Banco
        /*INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
        DataBaseCreate.class, "francisco.db")
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_1_4).build();
        */
    };


}




