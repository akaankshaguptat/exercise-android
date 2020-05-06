package com.example.gallery1.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/gallery1/viewmodel/ImageDisplayViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "firebase", "Lcom/example/gallery1/data/FireBaseData;", "repo", "Lcom/example/gallery1/model/data/Repository;", "deleteImage", "Landroidx/lifecycle/MutableLiveData;", "", "cid", "", "id", "getImage", "app_bottomNavDebug"})
public final class ImageDisplayViewModel extends androidx.lifecycle.ViewModel implements androidx.lifecycle.LifecycleObserver {
    private com.example.gallery1.data.FireBaseData firebase;
    private com.example.gallery1.model.data.Repository repo;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getImage(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> deleteImage(@org.jetbrains.annotations.NotNull()
    java.lang.String cid, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public ImageDisplayViewModel() {
        super();
    }
}