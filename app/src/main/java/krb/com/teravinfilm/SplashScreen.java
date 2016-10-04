package krb.com.teravinfilm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import api.APIInterface;
import api.APIResponse;
import api.ApiClient;
import model.Movies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.utilTeravin;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private final static String API_KEY = "f7b67d9afdb3c971d4419fa4cb667fbf";
    private utilTeravin util_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        util_ = util_.getInstance(getApplicationContext());

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        //check whether first time launch
        if(util_.isFirstTimeLaunch()){
            Log.e("FirstTime","Yes");

           new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                /*
                * Within 10 seconds, system will fetch data from server using asyntask
                * Save data into local database
                *
                */
                    new FetchData().execute();

                    startMainActivity();

                    util_.setFirstTimeLaunch(false);

                    finish();
                }
            }, SPLASH_TIME_OUT);
        }else{
            Log.e("FirstTime","NO");
            startMainActivity();
        }
    }
    /**
     * Async Task to make http call using Retrofit
     */
    private class FetchData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            APIInterface apiService = ApiClient.getClient().create(APIInterface.class);
            Call<APIResponse> call = apiService.getTopRatedMovies(API_KEY);
            call.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse>call, Response<APIResponse> response) {
                    List<Movies> movies = response.body().getResults();

                    for(int i=0;i<movies.size();i++){
                        Movies movie = movies.get(i);

                        util_.savetoLocalDB(String.valueOf(movie.getAdult()),movie.getBackdropPath(), String.valueOf(movie.getBelongsToCollection()),
                                movie.getHomepage(), String.valueOf(movie.getId()), movie.getImdbId(),movie.getOriginalLanguage(),
                                movie.getOriginalTitle(), movie.getOverview(), String.valueOf(movie.getPopularity()),
                                movie.getPosterPath(), movie.getReleaseDate(), String.valueOf(movie.getRevenue()),
                                String.valueOf(movie.getRuntime()), movie.getStatus(), movie.getTagline(),
                                movie.getTitle(), String.valueOf(movie.getVideo()), String.valueOf(movie.getVoteAverage()), String.valueOf(movie.getVoteCount()));
                    }
                    Log.d("Success", "Size of movies received: " + movies.size());
                }
                @Override
                public void onFailure(Call<APIResponse>call, Throwable t) {
                    // Log error here since request failed
                    Log.e("Failed", t.toString());
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

        }

    }

    private void startMainActivity() {
        MainActivity.startMainActivity(this);
        finish();
    }
}
