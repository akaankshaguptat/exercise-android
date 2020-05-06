package com.example.gallery1.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/gallery1/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "firebase", "Lcom/example/gallery1/data/FireBaseData;", "repo", "Lcom/example/gallery1/model/data/Repository;", "loginStatus", "Landroidx/lifecycle/MutableLiveData;", "", "email", "", "password", "activity", "Landroid/app/Activity;", "app_leftMenuDebug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gallery1.data.FireBaseData firebase;
    private com.example.gallery1.model.data.Repository repo;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> loginStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    public LoginViewModel() {
        super();
    }
}