package com.daotrung.appfilm.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daotrung.appfilm.R;

public class MovieDetail extends AppCompatActivity {

    Button btnPlay ;
    TextView txtNameDetail ;
    ImageView imgDetail ;
    RatingBar ratingBar ;

    String mName , mImg , mId , mFileUrl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        btnPlay = findViewById(R.id.btn_play);
        ratingBar = findViewById(R.id.ratingBar_d);
        txtNameDetail = findViewById(R.id.txt_name_detail);
        imgDetail = findViewById(R.id.movie_img_detail);

         //getData from intent

        mId = getIntent().getStringExtra("movieId");
        mName = getIntent().getStringExtra("movieName");
        mImg = getIntent().getStringExtra("movieImageUrl");
        mFileUrl = getIntent().getStringExtra("movieFile");

        //setData to layout

        Glide.with(this).load(mImg).into(imgDetail);
        txtNameDetail.setText(mName);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetail.this,VideoPlayer.class);
                intent.putExtra("url",mFileUrl);
                startActivity(intent);
            }
        });
    }
}