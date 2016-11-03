package com.example.ruslan.gallery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * Created by Ruslan on 11.10.2016.
 */

public class ImageFinder {
    private String directory;
    private ArrayList<String> imagePaths;
    public final static String SAMSUNG_G_S4_M = "/storage/emulated/0/DCIM/Camera";

    public ImageFinder(){
        directory = SAMSUNG_G_S4_M;
        imagePaths = new ArrayList<>();

        try{
            setUpImagePaths();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void setUpImagePaths() throws FileNotFoundException {

        imagePaths.clear();

        FilenameFilter filter  = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                name=name.toLowerCase();

                if(name.endsWith(".jpg") || name.endsWith(".png")){
                    return true;
                }else{
                    return false;
                }
            }
        };

        File file = new File(directory);

        if(file.exists()){
            File[] images = file.listFiles(filter);

            for(File image:images){
                imagePaths.add(image.getAbsolutePath());
            }
        }else{
            throw new FileNotFoundException("There is no file with path like this!");
        }

    }

    public void setDirectory(String path){
        directory = path;
    }

    public String getDirectory(){
        return directory;
    }

    public ArrayList<String> getImagePaths(){
        return imagePaths;
    }
}
