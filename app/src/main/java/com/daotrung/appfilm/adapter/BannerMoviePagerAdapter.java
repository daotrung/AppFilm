package com.daotrung.appfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.daotrung.appfilm.R;
import com.daotrung.appfilm.model.BannerMovie;
import com.daotrung.appfilm.model.MovieDetail;

import java.util.List;

public class BannerMoviePagerAdapter extends PagerAdapter {

    Context context ;
    List<BannerMovie> bannerMovieList ;

    public BannerMoviePagerAdapter(Context context, List<BannerMovie> bannerMovieList) {
        this.context = context;
        this.bannerMovieList = bannerMovieList;
    }

    @Override
    public int getCount() {
        return bannerMovieList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view  = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout,null);

        ImageView bannerImg = view.findViewById(R.id.banner_img);

        Glide.with(context).load(bannerMovieList.get(position).getImgUrl()).into(bannerImg);
        container.addView(view);

        bannerImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(context, MovieDetail.class);
                    intent.putExtra("movieId",bannerMovieList.get(position).getId());
                    intent.putExtra("movieName",bannerMovieList.get(position).getMovieName());
                    intent.putExtra("movieImageUrl",bannerMovieList.get(position).getImgUrl());
                    intent.putExtra("movieFile",bannerMovieList.get(position).getFileUrl());

                    context.startActivity(intent);
            }
        });

        return view ;

    }
}
