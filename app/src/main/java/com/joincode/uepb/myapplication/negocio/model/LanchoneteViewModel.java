package com.joincode.uepb.myapplication.negocio.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import java.util.List;
import com.joincode.uepb.myapplication.Lanchonete;
import com.joincode.uepb.myapplication.persistencia.LanchonetePersistencia;

public class LanchoneteViewModel extends AndroidViewModel {

    //manter em cache a lista de lanchonetes
    private LiveData<List<Lanchonete>> lanchonetesAllsCache;
    private LanchonetePersistencia lRepository;

    //construtor obtem uma referência ao Persistência da Lanchonete e obtenha a lista de lanchonetes do repositório.
    public LanchoneteViewModel (Application application) {
        super(application);
        lRepository = new LanchonetePersistencia(application);
        lanchonetesAllsCache = lRepository.getAllLanchonetes();
    }

    LiveData<List<Lanchonete>> getAllLanchotetes() { return lanchonetesAllsCache; }

    //Esse método insert encapsula a visão do usuário que acessa o repositório de lanchonete a partir deste método.
    public void insert(Lanchonete lancho) { lRepository.insert(lancho); }

}
