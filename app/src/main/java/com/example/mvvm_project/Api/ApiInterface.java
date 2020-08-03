package com.example.mvvm_project.Api;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_project.Model.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    // register merchant
    @POST("users/register/")
    @FormUrlEncoded
    Call<Register> registerUser(
            @Field("phone_number") String phone_number,
            @Field("password") String password,
            @Field("password2") String password2,
            @Field("is_merchant") MutableLiveData<Boolean> isMerchant

    );
}
