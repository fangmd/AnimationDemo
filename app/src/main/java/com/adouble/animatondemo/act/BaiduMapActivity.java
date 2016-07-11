package com.adouble.animatondemo.act;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adouble.animatondemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaiduMapActivity extends AppCompatActivity {

    @BindView(R.id.list_recyclerView)
    RecyclerView mListRecyclerView;
    @BindView(R.id.baidu_map_swipeRefresh)
    SwipeRefreshLayout mBaiduMapSwipeRefresh;
    @BindView(R.id.design_bottom_sheet_bar)
    RelativeLayout mDesignBottomSheetBar;
    @BindView(R.id.bottom_sheet_tv)
    TextView mBottomSheetTv;
    @BindView(R.id.bottom_sheet_iv)
    ImageView mBottomSheetIv;
    @BindView(R.id.design_bottom_sheet)
    RelativeLayout mDesignBottomSheet;
    @BindView(R.id.baidu_map_coordinatorLayout)
    CoordinatorLayout mBaiduMapCoordinatorLayout;
    private boolean isSetBottomSheetHeight;
    private BottomSheetBehavior<RelativeLayout> mBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_map);
        ButterKnife.bind(this);

        initBehavior();


    }

    private void initBehavior() {
        mBehavior = BottomSheetBehavior.from(mDesignBottomSheet);
        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                if(newState!=BottomSheetBehavior.STATE_COLLAPSED&&bottom_sheet_tv.getVisibility()==View.VISIBLE){
//                    bottom_sheet_tv.setVisibility(View.GONE);
//                    bottom_sheet_iv.setVisibility(View.VISIBLE);
//                }else if(newState==BottomSheetBehavior.STATE_COLLAPSED&&bottom_sheet_tv.getVisibility()==View.GONE){
//                    bottom_sheet_tv.setVisibility(View.VISIBLE);
//                    bottom_sheet_iv.setVisibility(View.GONE);
//                }

                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mDesignBottomSheetBar.setVisibility(View.GONE);
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    mDesignBottomSheetBar.setVisibility(View.VISIBLE);
                }
            }

            /**
             * 滑动过程中
             * @param bottomSheet
             * @param slideOffset
             */
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                if (bottomSheet.getTop() < 2 * mDesignBottomSheetBar.getHeight()) {
                    mDesignBottomSheetBar.setVisibility(View.VISIBLE);
                    mDesignBottomSheetBar.setAlpha(slideOffset);
                    mDesignBottomSheetBar.setTranslationY(bottomSheet.getTop() - 2 * mDesignBottomSheetBar.getHeight());
                } else {
                    mDesignBottomSheetBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    /**
     * 修改底部拉出布局的高度,流出标题栏的位置
     *
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //修改SetBottomSheet的高度 留出顶部工具栏的位置

        // 下面的代码可以调整拉出的高度,也可以直接在布局中写死高度
        if (!isSetBottomSheetHeight) {
            CoordinatorLayout.LayoutParams linearParams = (CoordinatorLayout.LayoutParams) mDesignBottomSheet.getLayoutParams();
            linearParams.height = mBaiduMapCoordinatorLayout.getHeight() - mDesignBottomSheetBar.getHeight();
            mDesignBottomSheet.setLayoutParams(linearParams);
            isSetBottomSheetHeight = true;//设置标记 只执行一次
        }
    }

    @OnClick(R.id.design_bottom_sheet_bar)
    public void onClick() {
        mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }
}
