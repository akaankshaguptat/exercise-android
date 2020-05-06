package com.example.gallery1.view.Adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u0014\u0010\f\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/example/gallery1/view/Adapters/ImageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/gallery1/view/Adapters/ImageListAdapter$ItemView;", "context", "Landroid/content/Context;", "arrayList", "Ljava/util/ArrayList;", "Lcom/example/gallery1/viewmodel/ImageListViewModel;", "Lkotlin/collections/ArrayList;", "id1", "", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getId1", "setId1", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemView", "app_bottomNavDebug"})
public final class ImageListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.gallery1.view.Adapters.ImageListAdapter.ItemView> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "imagelist";
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.example.gallery1.viewmodel.ImageListViewModel> arrayList = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id1;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.gallery1.view.Adapters.ImageListAdapter.ItemView onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.gallery1.view.Adapters.ImageListAdapter.ItemView holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId1() {
        return null;
    }
    
    public final void setId1(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public ImageListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gallery1.viewmodel.ImageListViewModel> arrayList, @org.jetbrains.annotations.NotNull()
    java.lang.String id1) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/gallery1/view/Adapters/ImageListAdapter$ItemView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "imageBinding", "Lcom/example/gallery1/databinding/ImageBinding;", "(Lcom/example/gallery1/databinding/ImageBinding;)V", "getImageBinding", "()Lcom/example/gallery1/databinding/ImageBinding;", "bind", "", "imageListViewModel", "Lcom/example/gallery1/viewmodel/ImageListViewModel;", "app_bottomNavDebug"})
    public static final class ItemView extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.gallery1.databinding.ImageBinding imageBinding = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.gallery1.viewmodel.ImageListViewModel imageListViewModel) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.gallery1.databinding.ImageBinding getImageBinding() {
            return null;
        }
        
        public ItemView(@org.jetbrains.annotations.NotNull()
        com.example.gallery1.databinding.ImageBinding imageBinding) {
            super(null);
        }
    }
}