package com.example.gallery1.model.Adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/gallery1/model/Adapters/CategoryList1Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/gallery1/model/Adapters/CategoryList1Adapter$ItemView;", "context", "Landroid/content/Context;", "arrayList", "Ljava/util/ArrayList;", "Lcom/example/gallery1/viewmodel/CategoryList1ViewModel;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemView", "app_leftMenuDebug"})
public final class CategoryList1Adapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.gallery1.model.Adapters.CategoryList1Adapter.ItemView> {
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.example.gallery1.viewmodel.CategoryList1ViewModel> arrayList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.gallery1.model.Adapters.CategoryList1Adapter.ItemView onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.gallery1.model.Adapters.CategoryList1Adapter.ItemView holder, int position) {
    }
    
    public CategoryList1Adapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.gallery1.viewmodel.CategoryList1ViewModel> arrayList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/gallery1/model/Adapters/CategoryList1Adapter$ItemView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "categoryBinding", "Lcom/example/gallery1/databinding/CategoryBinding;", "(Lcom/example/gallery1/databinding/CategoryBinding;)V", "getCategoryBinding", "()Lcom/example/gallery1/databinding/CategoryBinding;", "bind", "", "categoryList1ViewModel", "Lcom/example/gallery1/viewmodel/CategoryList1ViewModel;", "app_leftMenuDebug"})
    public static final class ItemView extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.gallery1.databinding.CategoryBinding categoryBinding = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.gallery1.viewmodel.CategoryList1ViewModel categoryList1ViewModel) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.gallery1.databinding.CategoryBinding getCategoryBinding() {
            return null;
        }
        
        public ItemView(@org.jetbrains.annotations.NotNull()
        com.example.gallery1.databinding.CategoryBinding categoryBinding) {
            super(null);
        }
    }
}