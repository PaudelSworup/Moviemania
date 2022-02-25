package com.example.moviemania;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieGetter extends ViewModel {
    private static final String API_KEY = "caa4226c251747a5c3bf3d6bc23b2d18";
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String POPULAR_MOVIES_URL = BASE_URL + "/movie/popular?api_key="+API_KEY;
    public MutableLiveData<List<Movie>> popularMovies = new MutableLiveData<>();


    public void getPopularMovies( int page, RequestQueue queue) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, POPULAR_MOVIES_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");
                    List<Movie> movies = new ArrayList<>();
                    for(int i = 0; i< results.length(); i++){
                        JSONObject movie = (JSONObject) results.get(i);
                        movies.add(new Movie(
                                movie.getString("title"),
                                movie.getString("poster_path"),
                                movie.getString("overview")
                        ));
                    }
                    popularMovies.setValue(movies);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonObjectRequest);
    }
}
