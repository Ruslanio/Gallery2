package com.example.ruslan.gallery.Gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ruslan.gallery.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ruslan on 12.10.2016.
 */

public class GalleryAdapter extends RecyclerView.Adapter {

    private ArrayList<String> mImagePaths;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public GalleryAdapter(Context context, ArrayList<String> imagePaths){
        mImagePaths = imagePaths;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,null);
        return new ImagehHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ImagehHolder) holder).bind(mOnItemClickListener,position);
    }

    @Override
    public int getItemCount() {
        return mImagePaths.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public class ImagehHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ImagehHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }

        public void bind(final OnItemClickListener onItemClickListener, final int position){

            String path = mImagePaths.get(position);

            Picasso.with(mContext).load(new File(path)).resize(400,400).into(image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClickListener(position);
                }
            });
        }
    }
}
