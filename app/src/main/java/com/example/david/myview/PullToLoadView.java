package com.example.david.myview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by David on 16/10/27.
 * 自定义控件。
 */
public class PullToLoadView extends FrameLayout {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    private IPullCallback mPullCallback;
    private  RecyclerViewPositionHelper mRecyclerViewHelper;
    protected ScrollDirection mScorllDirection;
    protected  int mPrevFirstVisibleItem;
    private int mLoadMoreOffset;
    private boolean mIsLoadMoreEnabled;


    public PullToLoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToLoadView(Context context) {
        super(context);
    }

    public PullToLoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPrevFirstVisibleItem=0;
        this.mLoadMoreOffset=5;
        this.mIsLoadMoreEnabled=false;
        //LayoutInflater mInflater=(LayoutInflater)context.getSystemService("layout_inflater");
    }




}
