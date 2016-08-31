package com.miri.materialdesign.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.miri.materialdesign.demo.adapter.OnRecyclerViewListener;
import com.miri.materialdesign.demo.adapter.RecyclerPersonAdapter;
import com.miri.materialdesign.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    public enum LayoutManagerEnum {
        LINEAR,
        GRID,
        STAGGERED
    }

    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    // RecyclerView specific options
    protected LayoutManagerEnum layoutManagerEnum = LayoutManagerEnum.GRID;
    protected Orientation orientation = Orientation.VERTICAL;
    protected boolean reverseLayout = false;
    private static final int GRID_SPAN = 3;

    private RecyclerView mRecyclerView;
    private RecyclerPersonAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

//        getActionBar().setTitle("那些年我们追的星女郎");

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        // 设置LayoutManager
        int layoutOrientation;
        switch (orientation) {
            case VERTICAL:
                layoutOrientation = OrientationHelper.VERTICAL;
                break;
            case HORIZONTAL:
                layoutOrientation = OrientationHelper.HORIZONTAL;
                break;
            default:
                layoutOrientation = OrientationHelper.VERTICAL;
        }
        RecyclerView.LayoutManager layoutManager = null;
        switch (layoutManagerEnum) {
            case LINEAR:
                layoutManager = new LinearLayoutManager(this, layoutOrientation, false);
                break;
            case GRID:
                layoutManager = new GridLayoutManager(this, GRID_SPAN, layoutOrientation, false);
                break;
            case STAGGERED:
                layoutManager = new StaggeredGridLayoutManager(GRID_SPAN, layoutOrientation);
                break;
        }

        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).setReverseLayout(reverseLayout);
        } else {
            ((StaggeredGridLayoutManager) layoutManager).setReverseLayout(reverseLayout);
        }
        mRecyclerView.setLayoutManager(layoutManager);

        // 设置ItemAnimator
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小，这样会提高RecyclerView的性能
        mRecyclerView.setHasFixedSize(true);

        // 初始化自定义的适配器
        myAdapter = new RecyclerPersonAdapter(initData());

        myAdapter.setOnRecyclerViewListener(new OnRecyclerViewListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(RecyclerViewActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View v, int position) {
                Toast.makeText(RecyclerViewActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // 为mRecyclerView设置适配器
        mRecyclerView.setAdapter(myAdapter);
    }

    private List<Person> initData() {
        List<Person> list = new ArrayList<>();
        Person p;
        for (int i = 0; i < 100; i++) {
            p = new Person();
            if (i % 5 == 0) {
                p.setName((i + 1) + "-Person Jim Perter Hihle hhod");
            } else {
                p.setName((i + 1) + "-Tom");
            }
            p.setAge(20 + new Random().nextInt(35));
            list.add(p);
        }
        return list;
    }


}

