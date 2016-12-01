package com.example.david.myview;

/**
 * Created by David on 16/11/8.
 */
public interface IPullCallback {
    void onLoadMore();

    void onRefresh();

    boolean isLoading();

    boolean hasLoadedAllItems();

}
