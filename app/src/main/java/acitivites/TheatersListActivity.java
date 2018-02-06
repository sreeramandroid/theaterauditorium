package acitivites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.takeoffandroid.seatBookingrecyclerView.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MoviesAdapter;
import models.Movie;
import utils.CustomRecyclerView;

public class TheatersListActivity extends AppCompatActivity {
    /**
     * shankar
     ***/
    private CustomRecyclerView mTheatersListView;
    private List<Movie> movieList = new ArrayList<>();
    private MoviesAdapter mMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theaters_list);
        initComponents();
    }

    private void initComponents() {
        mTheatersListView = (CustomRecyclerView) findViewById(R.id.theaterslist);
        mMoviesAdapter = new MoviesAdapter(movieList, new MoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                navigatetoTheaterListScreen();
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mTheatersListView.setLayoutManager(mLayoutManager);
        mTheatersListView.setItemAnimator(new DefaultItemAnimator());
        mTheatersListView.setAdapter(mMoviesAdapter);
        prepareMovieData();
    }

    private void navigatetoTheaterListScreen() {
        Intent mTheatersListIntent = new Intent(this, TheaterSeatsActivity.class);
        startActivity(mTheatersListIntent);
    }


    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "1");
        movieList.add(movie);

        movie = new Movie("Inside Out", "2");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "3");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "4");
        movieList.add(movie);

        movie = new Movie("The Martian", "5");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "6");
        movieList.add(movie);

        movie = new Movie("Up", "7");
        movieList.add(movie);

        movie = new Movie("Star Trek", "8");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "9");
        movieList.add(movie);

        movie = new Movie("Iron Man", "10");
        movieList.add(movie);

        movie = new Movie("Aliens", "11");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "12");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "13");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "14");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "15");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "16");
        movieList.add(movie);

        mMoviesAdapter.notifyDataSetChanged();

    }
}
