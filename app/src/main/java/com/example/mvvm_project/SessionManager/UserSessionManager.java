package com.example.mvvm_project.SessionManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.mvvm_project.Activity.LoginActivity;
import com.example.mvvm_project.R;

import java.util.HashMap;

public class UserSessionManager {

    private static final String IS_MERCHANT_ADDED = "isMerchantAdded";
    private static final String MERCHANT_URL = "merchant_url";
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    Context context;
    public static final  String USER_TOKEN = "user_token";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_PASSWORD = "password";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";

    public UserSessionManager(Context context) {
        this.context = context;
        sharedPreference = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE);
        editor = sharedPreference.edit();
    }

    public void saveAuthToken(String token){
        editor.putString(USER_TOKEN,token);
        editor.apply();
    }

    public String fetchAuthToken(){
        return sharedPreference.getString(USER_TOKEN, null);
    }

    public void saveMerchantUrl(String merchant_url){
        editor.putString(MERCHANT_URL,merchant_url);
        editor.commit();
    }

    public String fetchMerchantUrl(){ return sharedPreference.getString(MERCHANT_URL,null); }

    //Create login session
    public void createUserLoginSession(String phone, String password){
        // Storing login value as TRUE
        editor.putBoolean(IS_USER_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_PHONE, phone);

        // Storing email in pref
        editor.putString(KEY_PASSWORD, password);

        // commit changes
        editor.commit();
    }
    public void createMerchantAdded(){
        editor.putBoolean(IS_MERCHANT_ADDED,true);
        editor.commit();
    }

    public boolean checkLogin(){
        // Check login status
        if(!this.isUserLoggedIn()){

            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(context, LoginActivity.class);

            // Closing all the Activities from stack
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            context.startActivity(i);

            return true;
        }
        return false;
    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){

        //Use hashmap to store user credentials
        HashMap<String, String> user = new HashMap<String, String>();

        // user name
        user.put(KEY_PHONE, sharedPreference.getString(KEY_PHONE, null));

        // user email id
        user.put(KEY_PASSWORD, sharedPreference.getString(KEY_PASSWORD, null));

        // return user
        return user;
    }
    // Check for login
    public boolean isUserLoggedIn(){
        return sharedPreference.getBoolean(IS_USER_LOGIN, false);
    }
    public boolean isMerchantAdded(){
        return sharedPreference.getBoolean(IS_MERCHANT_ADDED,false);
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){

        // Clearing all user data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Login Activity
        Intent i = new Intent(context, LoginActivity.class);

        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);
    }
}
