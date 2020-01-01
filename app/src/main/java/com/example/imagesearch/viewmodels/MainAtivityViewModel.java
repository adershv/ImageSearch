package com.example.imagesearch.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.imagesearch.model.ImageList;
import com.example.imagesearch.model.Items;
import com.example.imagesearch.network.ImageApi;
import com.example.imagesearch.network.RetrofitInstance;
import com.example.imagesearch.utils.Constants;
import com.example.imagesearch.utils.Result;

import org.reactivestreams.Publisher;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainAtivityViewModel extends ViewModel {

    private static final String TAG = "MainAtivityViewModel";
    ImageApi imageApi;

    private MediatorLiveData<Result<ImageList>> imageListResult = new MediatorLiveData<>();
    public MainAtivityViewModel() {

        imageApi = RetrofitInstance.getClient().create(ImageApi.class);

    }

    public void getImageLIstFormApi(String searchQuery){
        Log.d(TAG,"working");
        imageListResult.setValue(Result.loading((ImageList)null));
        final LiveData<Result<ImageList>> source = LiveDataReactiveStreams.fromPublisher(
                imageApi.searchImages(searchQuery, Constants.apiKey,Constants.searchId,"image")
                        .onErrorReturn(new Function<Throwable, ImageList>() {
                            @Override
                            public ImageList apply(Throwable throwable) throws Exception {

                                ImageList imageList = new ImageList();
                                imageList.setError(-1);
                                return imageList;
                            }
                        })
                        .map(new Function<ImageList, Result<ImageList>>() {
                            @Override
                            public Result<ImageList> apply(ImageList imageList) throws Exception {
                                if(imageList.getError()==-1){
                                    return Result.error(imageList,"Error happend");
                                }
                                return Result.finish(imageList);
                            }
                        })
                        .subscribeOn(Schedulers.io())
        );

        imageListResult.addSource(source, new Observer<Result<ImageList>>() {
            @Override
            public void onChanged(Result<ImageList> imagetResult) {
                Log.d(TAG,imagetResult.data.getItems().get(0).getLink());
                imageListResult.setValue(imagetResult);
                imageListResult.removeSource(source);
            }


        });
    }

    public LiveData<Result<ImageList>> getImageList(){

        return imageListResult;
    }

}



