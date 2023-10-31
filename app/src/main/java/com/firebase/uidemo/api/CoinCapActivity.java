package com.firebase.uidemo.api;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.uidemo.R;
import com.firebase.uidemo.api.models.Cryptocurrency;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

            /**
             * Invoked for a received HTTP response.
             * <p>
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call {@link Response#isSuccessful()} to determine if the response indicates success.
             */
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                Cryptocurrency cryptocurrency = response.body();
                if (null != cryptocurrency) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String formattedJson = gson.toJson(cryptocurrency.data);
                    tvResponse.append(formattedJson + "\n\n");
                    Log.i(LOG_TAG, "getCryptocurrencyInfo => data=" + formattedJson);
                } else {
                    tvResponse.setText(getString(R.string.strError));
                    Log.i(LOG_TAG, getString(R.string.strError));
                }
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
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


        // Síncrona... no aquí => NetworkOnMainThreadException
//        Call<Country> call_sync = apiService.getCountryByName("spain");
//        try {
//            Country country = call_sync.execute().body();
//            Log.i(LOG_TAG, "SYNC => " + country.toString());
//        } catch (IOException e) {
//            Log.e(LOG_TAG, e.getMessage());
//        }
    }
}
