package com.example.imagesearch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imagesearch.R;
import com.example.imagesearch.model.ImageList;
import com.example.imagesearch.model.Items;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ImageList imageList;
    private Context context;

    public RecyclerViewAdapter(ImageList imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageitem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        Items item = imageList.getItems().get(position);
        holder.text.setText(item.getImage().getContextLink());

        Glide.with(context)
                .load(item.getImage().getThumbnailLink())
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_error)
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return imageList.getItems().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image =  itemView.findViewById(R.id.imageView);
            text =  itemView.findViewById(R.id.textView);
        }
    }
}
