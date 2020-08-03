package com.example.mvvm_project.AuthInterceptor;

import android.content.Context;

import com.example.mvvm_project.SessionManager.UserSessionManager;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    UserSessionManager userSessionManager;

    public AuthInterceptor(Context context) {
        userSessionManager = new UserSessionManager(context);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if (userSessionManager.fetchAuthToken() != null){
            builder.addHeader("Authorization","Token "+ userSessionManager.fetchAuthToken());
        }
        return chain.proceed(builder.build());
    }
}
