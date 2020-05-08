package com.example.gallery1.view.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0006\u0010\u0017\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/gallery1/view/activity/Gallery1Activity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "homeFragment", "Lcom/example/gallery1/view/fragment/HomeFragment;", "profileFragment", "Lcom/example/gallery1/view/fragment/ProfileFragment;", "timeLineFragment", "Lcom/example/gallery1/view/fragment/TimelineFragment;", "logout", "", "item", "Landroid/view/MenuItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onSupportNavigateUp", "updateNavHeader", "Companion", "app_bottomNavDebug"})
public final class Gallery1Activity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    private com.example.gallery1.view.fragment.HomeFragment homeFragment;
    private com.example.gallery1.view.fragment.ProfileFragment profileFragment;
    private com.example.gallery1.view.fragment.TimelineFragment timeLineFragment;
    @org.jetbrains.annotations.NotNull()
    public static androidx.fragment.app.FragmentManager manager;
    @org.jetbrains.annotations.Nullable()
    private static com.example.gallery1.view.activity.Gallery1Activity instance;
    public static final com.example.gallery1.view.activity.Gallery1Activity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    public final void updateNavHeader() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    public final void logout(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
    }
    
    public Gallery1Activity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/example/gallery1/view/activity/Gallery1Activity$Companion;", "", "()V", "instance", "Lcom/example/gallery1/view/activity/Gallery1Activity;", "getInstance", "()Lcom/example/gallery1/view/activity/Gallery1Activity;", "setInstance", "(Lcom/example/gallery1/view/activity/Gallery1Activity;)V", "manager", "Landroidx/fragment/app/FragmentManager;", "getManager", "()Landroidx/fragment/app/FragmentManager;", "setManager", "(Landroidx/fragment/app/FragmentManager;)V", "applicationContext", "Landroid/content/Context;", "app_bottomNavDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.FragmentManager getManager() {
            return null;
        }
        
        public final void setManager(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentManager p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.gallery1.view.activity.Gallery1Activity getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable()
        com.example.gallery1.view.activity.Gallery1Activity p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context applicationContext() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}