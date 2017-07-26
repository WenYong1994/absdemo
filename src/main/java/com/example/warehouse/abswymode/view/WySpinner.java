package com.example.warehouse.abswymode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.warehouse.abswymode.R;
import com.example.warehouse.abswymode.utils.DensityUtil;

/**
 * Created by Administrator on 2017/7/25.
 */


public class WySpinner extends LinearLayout {
    TextView mTextView;
    String[] datas;
    ListPopupWindow mLpw;





    Context context;

    //ListView mListView;
    // 用来记录弹出框选择
    private int checkPosition=0;
    public WySpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
        initData(context,attrs);
        initListener();
    }
    private void initData(Context context, @Nullable AttributeSet attrs) {
        this.context = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WySpinner);
        int resourceId = ta.getResourceId(R.styleable.WySpinner_entries, 0);
        float sipnner_hight = ta.getDimension(R.styleable.WySpinner_sipnner_hignt, 150);
        float sipnner_weight = ta.getDimension(R.styleable.WySpinner_sipnner_weight, 50);
        ta.recycle();
        try {
            datas= getResources().getStringArray(resourceId);
        }catch (Exception e){

        }
        mLpw =new ListPopupWindow(context);
        mTextView.setText(datas[0]);
       // mLpw =new ListPopupWindow(context);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_list_item_1, datas);
        mLpw.setAdapter(stringArrayAdapter);
        mLpw.setAnchorView(mTextView);
        mLpw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                mTextView.setText(data);
                checkPosition=position;
                if(mLpw!=null&&mLpw.isShowing()){
                    mLpw.dismiss();
                    checkPosition=position;
                }
            }
        });
        mLpw.setModal(true);
        mLpw.setHeight(DensityUtil.dip2px(context,sipnner_hight));
        mLpw.setWidth(DensityUtil.dip2px(context,sipnner_weight));

        mLpw.getListView();
        //mListView = mLpw.getListView();
    }

    private void initListener() {
        //设置点击弹出选择框
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLpw!=null&&!mLpw.isShowing()){
                    mLpw.show();
                }else if(mLpw!=null&&mLpw.isShowing()){
                    mLpw.dismiss();
                }
            }
        });
    }


    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.wy_spinner_view,this,false);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WySpinner);
        float text_hight = ta.getDimension(R.styleable.WySpinner_text_hight, 30);
        float text_weight = ta.getDimension(R.styleable.WySpinner_text_weight, 50);
        ta.recycle();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height=DensityUtil.dip2px(context,text_hight);
        layoutParams.width=DensityUtil.dip2px(context,text_weight);
        view.setLayoutParams(layoutParams);
        addView(view);
        mTextView = (TextView) view.findViewById(R.id.m_text);
    }


    //获取选择的列表
    public String getText(){
        return mTextView.getText().toString().trim();
    }

//    private class WyPopuwindows extends PopupWindow{
//        RecyclerView mRecyclerView;
//        RecyclerView.Adapter mAdapter;
//
//        public WyPopuwindows(Context context) {
//            super(context);
//            initPopuWindow();
//        }
//
//        private void initPopuWindow() {
//
//            setWidth(LayoutParams.WRAP_CONTENT);
//            setHeight(LayoutParams.WRAP_CONTENT);
//        }
//    }
//
//
//    private class WyViewHoulder  extends RecyclerView.ViewHolder{
//        TextView textView;
//        public WyViewHoulder(View itemView) {
//            super(itemView);
//            textView= (TextView) itemView.findViewById(R.id.my_text_view);
//        }
//    }
//
//    private class WyAdapter extends RecyclerView.Adapter<WyViewHoulder>{
//
//        @Override
//        public WyViewHoulder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view= LayoutInflater.from(context).inflate(R.layout.wy_spinner_recyler_view_item,parent,false);
//            WyViewHoulder viewHoulder=  new WyViewHoulder(view);
//            return viewHoulder;
//        }
//
//        @Override
//        public void onBindViewHolder(WyViewHoulder holder, int position) {
//            holder.textView.setText(datas[position]);
//        }
//
//        @Override
//        public int getItemCount() {
//            return datas.length;
//        }
//    }



}
