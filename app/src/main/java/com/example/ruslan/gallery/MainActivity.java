package com.example.ruslan.gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ruslan.gallery.Gallery.GalleryActivity;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnFind;
    private EditText etPath;
    private ImageFinder imageFinder;
    private int kostil = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFinder = new ImageFinder();

        btnFind = (Button) findViewById(R.id.btn_find);
        btnFind.setOnClickListener(this);
        etPath = (EditText) findViewById(R.id.et_directory);
        etPath.setText(ImageFinder.SAMSUNG_G_S4_M);
    }

    @Override
    public void onClick(View v) {
        if(etPath.getText().toString() != "" || etPath.getText().toString() != null){
            imageFinder.setDirectory(etPath.getText().toString());
            try {
                imageFinder.setUpImagePaths();
            }catch (FileNotFoundException e){
                kostil = 1;
                Toast.makeText(this, "There is no file with path like this!", Toast.LENGTH_SHORT).show();
                etPath.setText(ImageFinder.SAMSUNG_G_S4_M);
                e.printStackTrace();
                try{
                    imageFinder.setUpImagePaths();
                }catch (FileNotFoundException e1){
                    e1.printStackTrace();
                }
            }
            if(kostil == 0){
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(intent);
            }
        }
    }
}
