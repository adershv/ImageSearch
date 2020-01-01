package com.example.imagesearch.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Result<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    public Result(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> loading(@Nullable T data){
        return new Result<>(Status.LOADING,data,null);
    }

    public static <T> Result<T> finish(@Nullable T data){
        return new Result<>(Status.FINISH,data,"Success");
    }

    public static <T> Result<T> error(@Nullable T data , @Nullable String message){

        return new Result<>(Status.ERROR,data,message);
    }

    public enum Status {LOADING,FINISH,ERROR};
}
