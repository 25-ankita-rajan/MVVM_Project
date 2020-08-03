package com.example.mvvm_project;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_project.Model.Register;
import com.example.mvvm_project.Repositories.ResgisterMerchantRepo;


public class RegisterMerchantViewModel extends AndroidViewModel implements Observable {

    private String string_phone_number="";
    private String string_password1="";
    private String string_password2="";
    //public MutableLiveData<Boolean> isMerchantChecked;
    Boolean isMerchantChecked;
    MutableLiveData<Integer> busy;

    public final MutableLiveData<String> errorPhoneNumber=new MutableLiveData<>();
    public final MutableLiveData<String> errorPassword1 = new MutableLiveData<>();
    public final MutableLiveData<String> errorPassword2 = new MutableLiveData<>();

    private ResgisterMerchantRepo resgisterMerchantRepo;

    private MutableLiveData<Register> registerResponseMutableLiveData;

   // constructor
    public RegisterMerchantViewModel(@NonNull Application application) {
        super(application);
        resgisterMerchantRepo = new ResgisterMerchantRepo(application);
       //registerResponseMutableLiveData = resgisterMerchantRepo.registerMerchant(getString_phone_number(),getString_password1(),getString_password2(),getMerchantChecked());
//        registerResponseMutableLiveData = resgisterMerchantRepo.getRegisterResponseMutableLiveData();

    }

    public MutableLiveData<Register> getRegisterResponseLiveData(){
//        if(registerResponseMutableLiveData ==null){
//            registerResponseMutableLiveData = new MutableLiveData<>();
//        }
        return registerResponseMutableLiveData;
    }
    public void registerMerchant(String phone, String pwd1, String pwd2, Boolean check){
        resgisterMerchantRepo.registerMerchant(phone,pwd1,pwd2,check);
        registerResponseMutableLiveData = resgisterMerchantRepo.getRegisterResponseMutableLiveData();
    }


    @Bindable
    @NonNull
    public String getString_phone_number(){
        return this.string_phone_number;
    }
    public void setString_phone_number(@NonNull String string_phone_number){
        this.string_phone_number = string_phone_number;
    }

    @Bindable
    @NonNull
    public String getString_password1() {
        return string_password1;
    }

    public void setString_password1(@NonNull String string_password1) {
        this.string_password1 = string_password1;
    }

    @Bindable
    @NonNull
    public String getString_password2() {
        return string_password2;
    }

    public void setString_password2(@NonNull String string_password2) {
        this.string_password2 = string_password2;
    }

    @Bindable
    public Boolean getMerchantChecked() {
        return isMerchantChecked;
    }

    public void setMerchantChecked(@NonNull Boolean isMerchantChecked) {
        this.isMerchantChecked = isMerchantChecked;
    }

    @Bindable
    public MutableLiveData<Integer> getBusy() {
        if (busy == null){
           busy = new MutableLiveData<>();
           busy.setValue(8);
        }
        return busy;
    }

    public void setBusy(MutableLiveData<Integer> busy) {
        this.busy = busy;
    }
    public void onRegisterButtonClicked(View view){

        getBusy().setValue(0); // 0 == View.VISIBLE
//        new Runnable(){
//
//            @Override
//            public void run() {
                //Register register = new Register(getString_phone_number(),getString_password1(),getString_password2(),getMerchantChecked());
//                if(!register.isPhoneNumberValid()){
//                    errorPhoneNumber.setValue("should be less than 10 digits");
//                }
//                else {
//                    errorPhoneNumber.setValue(null);
//                }
//                if(!register.isPassword1EqualsPassword2()){
//                    errorPassword.setValue("password does not match");
//                }
//                else {
//                    errorPassword.setValue(null);
//                }
//                if(resgisterMerchantRepo == null){
//                    resgisterMerchantRepo.registerMerchant(getString_phone_number(),getString_password1(),getString_password2(),isMerchantChecked);
//                    registerResponseMutableLiveData = resgisterMerchantRepo.getRegisterResponseMutableLiveData();
//                }
//                registerResponseMutableLiveData.setValue(register);
//                busy.setValue(8); // 8 == View.GONE

                if(string_phone_number.isEmpty()){
                    errorPhoneNumber.setValue("phone number is required");
                }
                else if(string_password1.isEmpty()){
                    errorPassword1.setValue("required");
                }
                else if(string_password2.isEmpty()){
                    errorPassword2.setValue("required");
                }
                else if(!string_password1.equalsIgnoreCase(string_password2)){
                   // Toast.makeText(this, "password does not match.", Toast.LENGTH_SHORT).show();
                    errorPassword2.setValue("password does not match");
                }
                else {
                    //callApi(string_phone, string_psw1, string_psw2);
                    resgisterMerchantRepo.registerMerchant(getString_phone_number(),getString_password1(),getString_password2(),getMerchantChecked());
                    getBusy().setValue(8); // View.GONE
                }
          //  }
        //};
    }
    public void onLoginTextClicked(){

    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
