package com.example.gallery1.databinding;
import com.example.gallery1.R;
import com.example.gallery1.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CategoryBindingImpl extends CategoryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CategoryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private CategoryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[2]
            );
        this.categoryImage.setTag(null);
        this.categoryList.setTag(null);
        this.categoryTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.categorymodel == variableId) {
            setCategorymodel((com.example.gallery1.viewmodel.CategoryList1ViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCategorymodel(@Nullable com.example.gallery1.viewmodel.CategoryList1ViewModel Categorymodel) {
        this.mCategorymodel = Categorymodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.categorymodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.gallery1.viewmodel.CategoryList1ViewModel categorymodel = mCategorymodel;
        java.lang.String categorymodelCatTitle = null;
        java.lang.String categorymodelImageUrl = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (categorymodel != null) {
                    // read categorymodel.cat_title
                    categorymodelCatTitle = categorymodel.getCat_title();
                    // read categorymodel.imageUrl
                    categorymodelImageUrl = categorymodel.getImageUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.gallery1.viewmodel.CategoryBindingAdapter.setImageUrl(this.categoryImage, categorymodelImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryTitle, categorymodelCatTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): categorymodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}