package com.example.examenavimar;


import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.functions.FirebaseFunctions;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PersistenciaPlats {
    private FirebaseFirestore db;
    public PersistenciaPlats() {
        // Inicialitza l'objecte FirebaseFirestore amb la teva configuració
        db = FirebaseFirestore.getInstance();
    }

    public List<String> obtenirNomsPlats() {
        List<String> nomsPlats = new ArrayList<>();

        // Fes una consulta a la BD per obtenir tots els documents de la colecció "plats"
        db.collection("plats")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            // Si la consulta s'ha executat amb èxit, itera sobre tots els documents
                            // i afegeix el nom del plat a la llista nomsPlats
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                nomsPlats.add(document.getString("nom"));
                            }
                        } else {
                            // Si hi ha hagut un error en la consulta, mostra un missatge d'error
                            Log.d(TAG, "Error obtenint els plats: ", task.getException());
                        }
                    }
                });

        return nomsPlats;
    }
}
