package com.example.imagesearch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.imagesearch.R;
import com.example.imagesearch.adapter.RecyclerViewAdapter;
import com.example.imagesearch.model.ImageList;
import com.example.imagesearch.utils.Result;
import com.example.imagesearch.viewmodels.MainAtivityViewModel;

public class ImageListActivity extends AppCompatActivity {

    private static final String TAG = "ImageListActivity";
    MainAtivityViewModel viewModel;
    ProgressBar progressBar;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        Intent intent = getIntent();
        String searchQuery = intent.getStringExtra("SearchQuery");

        viewModel = ViewModelProviders.of(this).get(MainAtivityViewModel.class);
        progressBar = findViewById(R.id.progress);

        recyclerView = findViewById(R.id.imageListRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        viewModel.getImageLIstFormApi(searchQuery);


        viewModel.getImageList().observe(this, new Observer<Result<ImageList>>() {
            @Override
            public void onChanged(Result<ImageList> imageListResult) {
                if(imageListResult != null){
                    switch (imageListResult.status){
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case FINISH:
                            progressBar.setVisibility(View.GONE);
                            setAdapter(imageListResult.data);
                            break;


                        case ERROR:
                            showProgressBar(false);
                            break;

                    }
                }


            }


        });


    }
    private void setAdapter(ImageList data) {

        mAdapter= new RecyclerViewAdapter(data,this);
        recyclerView.setAdapter(mAdapter);

    }

    private void showProgressBar(boolean isVisible){
        if(isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

}
