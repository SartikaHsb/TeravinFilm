package api;

import java.util.List;

import model.Movies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sartikahasibuan on 9/27/2016.
 */
public interface APIInterface {
    @GET("books")
    Call<List<Movies>> getMovies();

    @GET("top_rated")
    Call<APIResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<APIResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
