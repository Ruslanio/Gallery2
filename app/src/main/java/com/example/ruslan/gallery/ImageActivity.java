package com.example.ruslan.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class ImageActivity extends AppCompatActivity {

    private ImageView ivPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ivPicture = (ImageView) findViewById(R.id.iv_big_picture);

        String path = getIntent().getStringExtra("path");

        Picasso.with(this).load(new File(path)).into(ivPicture);

    }
}
