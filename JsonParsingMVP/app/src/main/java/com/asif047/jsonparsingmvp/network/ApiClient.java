package com.asif047.jsonparsingmvp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static Retrofit retrofit = null;
    public static final String API_KEY ="2e901364c3d103dcb00ced520e9bca3c";
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w200/";

    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        }
        return retrofit;
    }

}
