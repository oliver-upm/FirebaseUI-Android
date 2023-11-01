package com.firebase.uidemo.database.firestore;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.uidemo.api.models.Cryptocurrency;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirestoreCoinCapActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private static final CollectionReference sCryptocurrencyCollection =
            FirebaseFirestore.getInstance().collection("cryptocurrency");

    private static final Query sCryptocurrencyQuery =
            sCryptocurrencyCollection.orderBy("timestamp", Query.Direction.DESCENDING).limit(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Cryptocurrency> cryptocurrencies = new ArrayList<>();
        sCryptocurrencyQuery
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                cryptocurrencies.add(document.toObject(Cryptocurrency.class));
                                Log.d("MiW", "cryptocurreny added: " + document.toObject(Cryptocurrency.class).toString());
                            }
                            Log.i("MiW", "cryptocurrencies: " + cryptocurrencies);
                        } else {
                            Log.d("MiW", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}