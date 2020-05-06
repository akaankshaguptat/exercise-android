package com.example.gallery1.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00000\u001bj\b\u0012\u0004\u0012\u00020\u0000`\u001c0\u001aJ\u0006\u0010\u001d\u001a\u00020\u0007R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/gallery1/viewmodel/CategoryList1ViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "categoryList1Model", "Lcom/example/gallery1/model/pojo/CategoryList1Model;", "(Lcom/example/gallery1/model/pojo/CategoryList1Model;)V", "cat_id", "", "getCat_id", "()Ljava/lang/String;", "setCat_id", "(Ljava/lang/String;)V", "cat_image", "getCat_image", "setCat_image", "cat_title", "getCat_title", "setCat_title", "fAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "firebase", "Lcom/example/gallery1/data/FireBaseData;", "repo", "Lcom/example/gallery1/model/data/Repository;", "userId", "getArrayList", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getImageUrl", "app_leftMenuDebug"})
public final class CategoryList1ViewModel extends androidx.lifecycle.ViewModel {
    private java.lang.String userId;
    private com.google.firebase.auth.FirebaseAuth fAuth;
    private com.example.gallery1.data.FireBaseData firebase;
    private com.example.gallery1.model.data.Repository repo;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cat_image;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String cat_title;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String cat_id;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCat_image() {
        return null;
    }
    
    public final void setCat_image(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCat_title() {
        return null;
    }
    
    public final void setCat_title(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCat_id() {
        return null;
    }
    
    public final void setCat_id(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.gallery1.viewmodel.CategoryList1ViewModel>> getArrayList() {
        return null;
    }
    
    public CategoryList1ViewModel() {
        super();
    }
    
    public CategoryList1ViewModel(@org.jetbrains.annotations.NotNull()
    com.example.gallery1.model.pojo.CategoryList1Model categoryList1Model) {
        super();
    }
}