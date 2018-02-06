package adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.takeoffandroid.seatBookingrecyclerView.R;

import java.util.List;

import models.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> moviesList;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView theaterName;
        public CardView mCardParentView;

        public MyViewHolder(View view) {
            super(view);
            theaterName = (TextView) view.findViewById(R.id.theaterName);
            mCardParentView = (CardView) view.findViewById(R.id.theatercard);


        }
    }


    public MoviesAdapter(List<Movie> moviesList, OnItemClickListener onItemClickListener) {
        this.moviesList = moviesList;
        this.itemClickListener = onItemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_theaterlistitem, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Movie movie = moviesList.get(position);
        holder.theaterName.setText(movie.getTheaterName());
        holder.mCardParentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}