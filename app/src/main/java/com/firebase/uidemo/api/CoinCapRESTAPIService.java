package com.firebase.uidemo.api;

import com.firebase.uidemo.api.models.Cryptocurrency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoinCapRESTAPIService {

    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    // https://api.coincap.io/v2/assets/bitcoin
    @GET("v2/assets/{cryptocurrencyName}")
    Call<Cryptocurrency> getCryptocurrencyByName(@Path("cryptocurrencyName") String cryptocurrencyName);
}
