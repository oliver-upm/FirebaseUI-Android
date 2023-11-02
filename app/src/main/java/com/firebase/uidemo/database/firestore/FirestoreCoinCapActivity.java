package com.firebase.uidemo.database.firestore;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.uidemo.api.models.Cryptocurrency;
import com.firebase.uidemo.database.CryptocurrencyHolder;
import com.firebase.uidemo.databinding.ActivityFirestoreCoincapBinding;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FirestoreCoinCapActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MiW";

    private static final CollectionReference sCryptocurrencyCollection =
            FirebaseFirestore.getInstance().collection("cryptocurrency");

    /**
     * Get the last 20 cryptocurrency messages ordered by timestamp .
     */
    private static final Query sCryptocurrencyQuery =
            sCryptocurrencyCollection.orderBy("timestamp", Query.Direction.DESCENDING).limit(20);

    private ActivityFirestoreCoincapBinding mBinding;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityFirestoreCoincapBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        setupRecyclerView();
        attachRecyclerViewAdapter();
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mBinding.cryptocurrencyRecyclerview.setHasFixedSize(true);
        mBinding.cryptocurrencyRecyclerview.setLayoutManager(manager);
    }

    private void attachRecyclerViewAdapter() {
        this.adapter = newAdapter();

        // Scroll to top on new searches
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                mBinding.cryptocurrencyRecyclerview.smoothScrollToPosition(0);
            }
        });

        mBinding.cryptocurrencyRecyclerview.setAdapter(adapter);
    }

    @NonNull
    private FirestoreRecyclerAdapter newAdapter() {
        FirestoreRecyclerOptions<Cryptocurrency> response = new FirestoreRecyclerOptions.Builder<Cryptocurrency>()
                .setQuery(sCryptocurrencyQuery, Cryptocurrency.class)
                .setLifecycleOwner(this)
                .build();

        return new FirestoreRecyclerAdapter<Cryptocurrency, CryptocurrencyHolder>(
                response) {
            @NonNull
            @Override
            public CryptocurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                           int viewType) {
                return CryptocurrencyHolder.create(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull CryptocurrencyHolder holder,
                                         int position,
                                         @NonNull Cryptocurrency cryptocurrency) {
                holder.bind(cryptocurrency);
            }

            @Override
            public void onError(@NonNull FirebaseFirestoreException e) {
                Log.e(LOG_TAG, "Error: " + e.getMessage());
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
