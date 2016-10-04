package api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sartikahasibuan on 9/27/2016.
 */
public class ApiClient {
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static Retrofit retrofit = null;

    public static final OkHttpClient httpClient = new OkHttpClient();
    private static OkHttpClient.Builder httpClient1 = new OkHttpClient.Builder();


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }

}
