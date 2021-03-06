package com.rms.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Ashish on 9/13/2016.
 */
public class ListViewUtils {

    public static void setListViewHeightBasedOnChildren(ListView listView, int childCount) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < childCount; i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (childCount - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}