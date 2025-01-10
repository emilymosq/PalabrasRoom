package com.examemily.otroproyecto;
import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class PalabraRepository {
    private PalabraDao mpalabraDAO;
    private LiveData<List<Palabra>> mPalabras;

    PalabraRepository(Application application) {
        PalabraDB db = PalabraDB.getDatabase(application);
        mpalabraDAO = db.palabraDAO();
        mPalabras = mpalabraDAO.getPalabrasOrdenadas();
    }

    LiveData<List<Palabra>> getAllPalabras(){
        return mPalabras;
    }

    void insert(Palabra palabra) {
        PalabraDB.databaseWriteExecutor.execute(() -> {
            mpalabraDAO.insert(palabra);
        });
    }
}
