package krb.com.teravinfilm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import api.APIInterface;
import api.APIResponse;
import api.ApiClient;
import model.Movies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.utilTeravin;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "f7b67d9afdb3c971d4419fa4cb667fbf";
    private utilTeravin util_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        util_ = util_.getInstance(getApplicationContext());

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //
        APIInterface apiService = ApiClient.getClient().create(APIInterface.class);
        Call<APIResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse>call, Response<APIResponse> response) {
                List<Movies> movies = response.body().getResults();
               /* for(int i=0;i<movies.size();i++){
                    Movies movie = movies.get(i);*/

                    util_.savetoLocalDB("A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A");
                    /*util_.savetoLocalDB(String.valueOf(movie.getAdult()),movie.getBackdropPath(), String.valueOf(movie.getBelongsToCollection()),
                            movie.getHomepage(), String.valueOf(movie.getId()), movie.getImdbId(),movie.getOriginalLanguage(),
                            movie.getOriginalTitle(), movie.getOverview(), String.valueOf(movie.getPopularity()),
                            movie.getPosterPath(), movie.getReleaseDate(), String.valueOf(movie.getRevenue()),
                            String.valueOf(movie.getRuntime()), movie.getStatus(), movie.getTagline(),
                            movie.getTitle(), String.valueOf(movie.getVideo()), String.valueOf(movie.getVoteAverage()), String.valueOf(movie.getVoteCount()));*/
                //}
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                //Log.d("Success", "Number of movies received: " + movies.size());
            }
            @Override
            public void onFailure(Call<APIResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("Failed", t.toString());
            }
        });

        //save database


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static void startMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
