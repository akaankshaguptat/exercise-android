package com.example.gallery1.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u001c\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c0\u0014J$\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001e0\u001aj\b\u0012\u0004\u0012\u00020\u001e`\u001c0\u00142\u0006\u0010\u001f\u001a\u00020\u0017J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0017J\u001c\u0010#\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020$0\u001aj\b\u0012\u0004\u0012\u00020$`\u001c0\u0014J$\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020$J4\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u00100\u001a\u000201J4\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0017H\u0002J$\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00142\u0006\u00109\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006<"}, d2 = {"Lcom/example/gallery1/data/FireBaseData;", "", "()V", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "firebaseAuth$delegate", "Lkotlin/Lazy;", "firebaseStorageInstance", "Lcom/google/firebase/database/FirebaseDatabase;", "getFirebaseStorageInstance", "()Lcom/google/firebase/database/FirebaseDatabase;", "firebaseStorageInstance$delegate", "firebasedb", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFirebasedb", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "firebasedb$delegate", "deleteImage", "Landroidx/lifecycle/MutableLiveData;", "", "cid", "", "id", "getCategoryArrayList", "Ljava/util/ArrayList;", "Lcom/example/gallery1/viewmodel/CategoryList1ViewModel;", "Lkotlin/collections/ArrayList;", "getImagesArrayList", "Lcom/example/gallery1/viewmodel/ImageListViewModel;", "id1", "getProfileData", "Lcom/example/gallery1/model/ProfileModelClass;", "getSingleImageData", "getTimeLineArrayList", "Lcom/example/gallery1/viewmodel/TimelineViewModel;", "login", "email_login", "password_login", "activity", "Landroid/app/Activity;", "selector", "p", "signUp", "email", "password", "name", "imageView_progilesignup", "Landroid/widget/ImageView;", "uplaodImageAndSaveUri", "imageBitmap", "Landroid/graphics/Bitmap;", "uplaodImageAndTitle", "", "imageUri", "Landroid/net/Uri;", "title", "uploadCategoryImage", "Lcom/example/gallery1/model/CategoryModel;", "app_bottomNavDebug"})
public final class FireBaseData {
    private final kotlin.Lazy firebaseAuth$delegate = null;
    private final kotlin.Lazy firebaseStorageInstance$delegate = null;
    private final kotlin.Lazy firebasedb$delegate = null;
    
    private final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
        return null;
    }
    
    private final com.google.firebase.database.FirebaseDatabase getFirebaseStorageInstance() {
        return null;
    }
    
    private final com.google.firebase.firestore.FirebaseFirestore getFirebasedb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.gallery1.viewmodel.CategoryList1ViewModel>> getCategoryArrayList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.gallery1.viewmodel.TimelineViewModel>> getTimeLineArrayList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String selector(@org.jetbrains.annotations.NotNull()
    com.example.gallery1.viewmodel.TimelineViewModel p) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.gallery1.viewmodel.ImageListViewModel>> getImagesArrayList(@org.jetbrains.annotations.NotNull()
    java.lang.String id1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSingleImageData(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> deleteImage(@org.jetbrains.annotations.NotNull()
    java.lang.String cid, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> login(@org.jetbrains.annotations.NotNull()
    java.lang.String email_login, @org.jetbrains.annotations.NotNull()
    java.lang.String password_login, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> signUp(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView_progilesignup) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> uplaodImageAndSaveUri(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap imageBitmap, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.gallery1.model.ProfileModelClass> getProfileData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.gallery1.model.CategoryModel> uploadCategoryImage(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap imageBitmap, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    private final void uplaodImageAndTitle(android.net.Uri imageUri, java.lang.String title) {
    }
    
    public FireBaseData() {
        super();
    }
}