package com.asif047.jsonparsingmvp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asif047.jsonparsingmvp.R;
import com.asif047.jsonparsingmvp.model.Movie;
import com.asif047.jsonparsingmvp.network.ApiClient;
import com.bumptech.glide.Glide;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private List<Movie> movieList;
    private Context context;

    public MovieListAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_movie_list, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvMovietitle.setText(movieList.get(position).getTitle());
        holder.tvReleaseDate.setText(movieList.get(position).getReleaseDate());
        holder.tvOverview.setText(movieList.get(position).getOverview());


        Glide.with(context).load(ApiClient.IMAGE_BASE_URL+movieList.get(position).getPosterPath()).into(holder.ivMovie);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MyViewHolder extends  RecyclerView.ViewHolder {

        ImageView ivMovie;
        TextView tvMovietitle, tvReleaseDate, tvOverview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMovie = itemView.findViewById(R.id.ivMovie);
            tvMovietitle = itemView.findViewById(R.id.tvTitleMovie);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseMovie);
            tvOverview = itemView.findViewById(R.id.tvOverviewMovie);

        }
    }


}
