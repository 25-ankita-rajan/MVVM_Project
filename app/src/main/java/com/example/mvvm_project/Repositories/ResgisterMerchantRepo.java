package com.example.mvvm_project.Repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_project.Api.ApiClient;
import com.example.mvvm_project.Api.ApiInterface;
import com.example.mvvm_project.Model.Register;
import com.example.mvvm_project.SessionManager.UserSessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResgisterMerchantRepo {

    private  ApiInterface apiService;
    private MutableLiveData<Register> registerResponseMutableLiveData;
    UserSessionManager userSessionManager;

    public ResgisterMerchantRepo(Application application) {

        apiService = ApiClient.getClient(application).create(ApiInterface.class);
        registerResponseMutableLiveData = new MutableLiveData<>();
        userSessionManager = new UserSessionManager(application);
    }
    public MutableLiveData<Register> registerMerchant(String string_phone, String string_psw1, String string_psw2, Boolean isMerchant){

        Call<Register> call = apiService.registerUser(string_phone,string_psw1,string_psw2,isMerchant);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.isSuccessful()){
                    //progressBar.setVisibility(View.INVISIBLE);
                    registerResponseMutableLiveData.postValue(response.body());
                    Log.d("tag","response: isMerchant -->"+response.body().getIs_merchant());
                    Log.d("tag","response: Merchant register -"+response.body());
                    //generateToken(string_phone,string_psw1);
                    //Toast.makeText(LoginActivity.this, "user register success, response :"+response, Toast.LENGTH_SHORT).show();

                }
                else {
                    Log.d("tag","else response: Merchant register -"+response.body());
                    //progressBar.setVisibility(View.INVISIBLE);
                    //button.setEnabled(true);
                    //Toast.makeText(LoginActivity.this, "error :"+response, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {

                //Toast.makeText(LoginActivity.this, "registeration throw error: "+t.toString(), Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.INVISIBLE);
                //button.setEnabled(true);
                registerResponseMutableLiveData.postValue(null);
                Log.d("tag","Merchant register throw error--> "+t.toString());
            }
        });

        return null;
    }

    public MutableLiveData<Register> getRegisterResponseMutableLiveData(){
        return registerResponseMutableLiveData;
    }
}
