package com.miri.materialdesign.demo.adapter;

import android.view.View;

/**
 * 〈一句话功能简述〉〈功能详细描述〉
 *
 * @author PengL, , 2015/11/30.
 */
public interface OnRecyclerViewListener {

    void onItemClick(View view, int position);

    boolean onItemLongClick(View view, int position);
}
