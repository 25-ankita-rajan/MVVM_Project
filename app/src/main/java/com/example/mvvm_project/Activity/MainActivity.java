package com.example.mvvm_project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvvm_project.Model.Register;
import com.example.mvvm_project.R;
import com.example.mvvm_project.RegisterMerchantViewModel;
import com.example.mvvm_project.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    RegisterMerchantViewModel registerMerchantViewModel;
    MutableLiveData<Register> registerMutableLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        registerMerchantViewModel = ViewModelProviders.of(this).get(RegisterMerchantViewModel.class);
//        registerMerchantViewModel = new RegisterMerchantViewModel(getApplication());
//        binding.setRegisterMerchantViewModel(registerMerchantViewModel);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        activityMainBinding.setRegisterMerchantViewModel(registerMerchantViewModel);
        registerMerchantViewModel = ViewModelProviders.of(MainActivity.this).get(RegisterMerchantViewModel.class);
        registerMerchantViewModel = new RegisterMerchantViewModel(getApplication());
        String phone = activityMainBinding.phoneEd.getText().toString();
        String pwd1 = activityMainBinding.password1Ed.getText().toString();
        String pwd2 = activityMainBinding.password2Ed.getText().toString();
        Boolean check = activityMainBinding.merchantCheckbox.isChecked();
        registerMerchantViewModel.registerMerchant(phone,pwd1,pwd2,check);

        registerMutableLiveData = registerMerchantViewModel.getRegisterResponseLiveData();
        Log.d("tag","response: "+registerMutableLiveData);
    }
}