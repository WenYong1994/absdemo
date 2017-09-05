package com.example.warehouse.abswymode.view;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.warehouse.abswymode.R;
import com.example.warehouse.abswymode.utils.DensityUtil;
import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/5.
 */

public class WyLooperViewPopuWindow extends PopupWindow {
    Context context;
    ArrayList<String> data;
    LoopView mLoopView;
    TextView okTv;
    TextView cancleTv;
    int mindex;
    OnOkTvClickListener onOkTvClikListener;
    public WyLooperViewPopuWindow(Context context, ArrayList<String> data) {
        super(context);
        this.context = context;
        this.data = data;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.wy_looper_view_popuwindow, null, false);
        setContentView(view);
        okTv = (TextView) view.findViewById(R.id.ok_tv);
        cancleTv = (TextView) view.findViewById(R.id.cancel_tv);
        mLoopView = (LoopView) view.findViewById(R.id.m_loop_view);
        cancleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShowing()){
                   dismiss();
                }
            }
        });
        okTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShowing()){
                    dismiss();
                }
                if(onOkTvClikListener!=null){
                    onOkTvClikListener.onOkTvClickListner(mindex);
                }
            }
        });
        mLoopView.setItems(data);
        mLoopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                mindex = index;
            }
        });
        mLoopView.setTextSize(17);
        setFocusable(true);
        setHeight(DensityUtil.dip2px(context,200));
        // 设置点击popupwindow外屏幕其它地方消失
        setOutsideTouchable(true);
        //让popuweindow 显示最最下面
        showAtLocation(((Activity)context).getWindow().getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }


    public void setOnOkTvClickListener(OnOkTvClickListener listener){
        this.onOkTvClikListener = listener;
    }

    public interface OnOkTvClickListener{
        void onOkTvClickListner(int index);
    }

}
