package com.example.ruslan.gallery.Gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ruslan.gallery.ImageActivity;
import com.example.ruslan.gallery.ImageFinder;
import com.example.ruslan.gallery.R;

public class GalleryActivity extends AppCompatActivity implements OnItemClickListener{

    private RecyclerView rvGallery;
    private GalleryAdapter galleryAdapter;
    private ImageFinder imageFinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        imageFinder = new ImageFinder();

        galleryAdapter = new GalleryAdapter(this,imageFinder.getImagePaths());
        galleryAdapter.setOnItemClickListener(this);

        rvGallery = (RecyclerView) findViewById(R.id.rv_gallery);
        rvGallery.setAdapter(galleryAdapter);
        rvGallery.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(getApplicationContext(), ImageActivity.class).putExtra("path",imageFinder.getImagePaths().get(position));
        startActivity(intent);
    }
}
