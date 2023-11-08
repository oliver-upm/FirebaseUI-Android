package com.firebase.uidemo.api;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.uidemo.R;
import com.firebase.uidemo.api.models.Cryptocurrency;
import com.firebase.uidemo.api.models.Data;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinCapActivity extends AppCompatActivity {

    private static final String API_BASE_URL = "https://api.coincap.io/";
    private static final String LOG_TAG = "MiW";

    private TextView tvResponse;
    private EditText etCryptocurrencyName;

    private CoinCapRESTAPIService apiService;

    private static final CollectionReference sCryptocurrencyCollection =
            FirebaseFirestore.getInstance().collection("cryptocurrency");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        tvResponse = findViewById(R.id.tvResponse);
        etCryptocurrencyName = findViewById(R.id.cryptocurrencyName);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(CoinCapRESTAPIService.class);
    }

    public void getCryptocurrencyInfo(View v) {
        String cryptocurrencyName = etCryptocurrencyName.getText().toString();
        Log.i(LOG_TAG, "getCryptocurrencyInfo => cryptocurrencyName: " + cryptocurrencyName);
        tvResponse.setText(null);

        Call<Cryptocurrency> call_async = apiService.getCryptocurrencyByName(cryptocurrencyName);

        // Asíncrona
        call_async.enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                Cryptocurrency cryptocurrency = response.body();
                if (cryptocurrency != null) {
                    Data data = cryptocurrency.getData();
                    String dataInfo = "ID: " + data.getId() +
                            "\nRank: " + data.getRank() +
                            "\nSymbol: " + data.getSymbol() +
                            "\nName: " + data.getName() +
                            "\nSupply: " + data.getSupply() +
                            "\nMax Supply: " + data.getMaxSupply() +
                            "\nMarket Cap USD: " + data.getMarketCapUsd() +
                            "\nVolume USD 24 Hr: " + data.getVolumeUsd24Hr() +
                            "\nPrice USD: " + data.getPriceUsd() +
                            "\nChange Percent 24 Hr: " + data.getChangePercent24Hr() +
                            "\nVWAP 24 Hr: " + data.getVwap24Hr() +
                            "\nExplorer: " + data.getExplorer();
                    tvResponse.append(dataInfo + "\n\n");
                    addCryptocurrency(cryptocurrency);
                    Log.i(LOG_TAG, "getCryptocurrencyInfo => data=" + cryptocurrency.getData());
                } else {
                    tvResponse.setText(getString(R.string.strError));
                    Log.i(LOG_TAG, getString(R.string.strError));
                }
            }

            @Override
            public void onFailure(Call<Cryptocurrency> call, Throwable t) {
                Toast.makeText(
                        getApplicationContext(),
                        "ERROR: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
                Log.e(LOG_TAG, t.getMessage());
            }
        });
    }

    private void addCryptocurrency(@NonNull Cryptocurrency cryptocurrency) {
        // Añadir la criptomoneda a Firestore
        sCryptocurrencyCollection.add(cryptocurrency)
                .addOnSuccessListener(documentReference ->
                        Log.i(LOG_TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                .addOnFailureListener(e ->
                        Log.e(LOG_TAG, "Error adding document", e));
    }
}
