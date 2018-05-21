package entitys;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity (tableName = "Lanchonete")
public class Lanchonete {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private @NonNull String nome;

    @ColumnInfo(name = "localidade")
    private @NonNull String localidade;

    @ColumnInfo(name = "responsavel")
    private @NonNull String responsavel;

    @ColumnInfo(name = "horaAtend")
    private @NonNull String horaAtend;

    public Lanchonete(String nome, String localidade, String responsavel, String horaAtend) {
        this.nome = nome;
        this.localidade = localidade;
        this.responsavel = responsavel;
        this.horaAtend = horaAtend;
    }

    public String getLanchonete(){return this.nome;}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getHoraAtend() {
        return horaAtend;
    }

    public void setHoraAtend(String horaAtend) {
        this.horaAtend = horaAtend;
    }
}
