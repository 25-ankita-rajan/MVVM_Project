package com.example.mvvm_project.Model;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register {

    @SerializedName("phone_number")
    @Expose
    private String phone_number;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("password2")
    @Expose
    private String password2;

    @SerializedName("is_merchant")
    @Expose
    private MutableLiveData<Boolean> is_merchant;

    public Register() {
    }

    public Register(String phone_number, String password, String password2, MutableLiveData<Boolean> is_merchant) {
        this.phone_number = phone_number;
        this.password = password;
        this.password2 = password2;
        this.is_merchant = is_merchant;
    }

    public MutableLiveData<Boolean> getIs_merchant() {
        return is_merchant;
    }

    public void setIs_merchant(MutableLiveData<Boolean> is_merchant) {
        this.is_merchant = is_merchant;
    }

    public String getPhone_number() {
        if(phone_number == null){
            return " ";
        }
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        if (password == null){
            return "";
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        if(password2==null){
            return "";
        }
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public boolean isPhoneNumberValid() {
        return getPhone_number().length() <= 10;
    }
    public boolean isPassword1EqualsPassword2() {
        return password.equalsIgnoreCase(password2);
    }
//        else if(string_psw1.isEmpty()){
//            pswd1_et.setError("required");
//        }
//        else if(string_psw2.isEmpty()){
//            pswd2_et.setError("required");
//        }
//        else if(!string_psw1.equalsIgnoreCase(string_psw2)){
//            Toast.makeText(this, "password does not match.", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            callApi(string_phone, string_psw1, string_psw2);
//        }
//    }
}
