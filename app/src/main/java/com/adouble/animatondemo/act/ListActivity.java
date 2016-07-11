package com.adouble.animatondemo.act;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.adouble.animatondemo.R;
import com.adouble.animatondemo.act.bean.RequestResult;
import com.adouble.animatondemo.act.net.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity implements Callback<RequestResult>, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private SwipeRefreshLayout mSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
        initData();
    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_recyclerView);
        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layout);
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mSwipe = (SwipeRefreshLayout) findViewById(R.id.list_swipeRefresh);
        assert mSwipe != null;
        mSwipe.setOnRefreshListener(this);
    }

    private void initData() {
        NetworkUtils.getService().getImgs().enqueue(this);
    }

    @Override
    public void onResponse(Call<RequestResult> call, Response<RequestResult> response) {
        if (response.isSuccessful()) {
            RequestResult body = response.body();
            if (body != null) {
                mAdapter.addAll(body.getTngou());
            }
        }
    }

    @Override
    public void onFailure(Call<RequestResult> call, Throwable t) {

    }

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSwipe.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}
