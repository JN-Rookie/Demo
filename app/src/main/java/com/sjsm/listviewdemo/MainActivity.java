package com.sjsm.listviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private MyListView mLv_list;
    private ArrayList mData;
    private Context mContext;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        mLv_list = (MyListView) findViewById(R.id.lv_list);
        initData();
        mAdapter=new MyAdapter(mContext,mData);
        mLv_list.setAdapter(mAdapter);
    }

    private void initData() {
        mData=new ArrayList();

        for (int i = 0; i < 5; i++) {
            Map<String,String> map=new HashMap<>();
            map.put("type","1");
            map.put("title","标题"+i);
            mData.add(map);
            for (int j = 0; j < 3; j++) {
                Map<String,String> stringMap=new HashMap<>();
                stringMap.put("type","0");
                stringMap.put("text","内容"+j);
                stringMap.put("info","详情"+j);
                mData.add(stringMap);
            }
        }

    }

}
