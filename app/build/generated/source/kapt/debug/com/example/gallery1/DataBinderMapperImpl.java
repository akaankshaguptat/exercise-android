package com.example.gallery1;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.gallery1.databinding.CategoryBindingImpl;
import com.example.gallery1.databinding.ImageBindingImpl;
import com.example.gallery1.databinding.TimelineBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CATEGORYLIST1 = 1;

  private static final int LAYOUT_IMAGELIST = 2;

  private static final int LAYOUT_TIMELINELIST = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gallery1.R.layout.category_list1, LAYOUT_CATEGORYLIST1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gallery1.R.layout.image_list, LAYOUT_IMAGELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gallery1.R.layout.timeline_list, LAYOUT_TIMELINELIST);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CATEGORYLIST1: {
          if ("layout/category_list1_0".equals(tag)) {
            return new CategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_list1 is invalid. Received: " + tag);
        }
        case  LAYOUT_IMAGELIST: {
          if ("layout/image_list_0".equals(tag)) {
            return new ImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for image_list is invalid. Received: " + tag);
        }
        case  LAYOUT_TIMELINELIST: {
          if ("layout/timeline_list_0".equals(tag)) {
            return new TimelineBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for timeline_list is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "categorymodel");
      sKeys.put(2, "imagemodel");
      sKeys.put(3, "timeline");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/category_list1_0", com.example.gallery1.R.layout.category_list1);
      sKeys.put("layout/image_list_0", com.example.gallery1.R.layout.image_list);
      sKeys.put("layout/timeline_list_0", com.example.gallery1.R.layout.timeline_list);
    }
  }
}
