package com.sjsm.listviewdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class MyAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {
    private Context                        mContext;
    private List<Map<String, String>> mData;
    private LayoutInflater mInflater;
    private String                          mId;

    public MyAdapter(Context context, List<Map<String, String>> data) {
        mContext = context;
        mData = data;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType==1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
       int type= Integer.parseInt(mData.get(position).get("type"));
        return type;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHold=null;
        View menuView=null;
        if(mData.get(position).get("type").equals("1")){
            if (convertView == null) {
                viewHold=new ViewHolder();
                convertView = mInflater.inflate(R.layout.layout_streelist_title,parent, false);
                viewHold.title= (TextView) convertView.findViewById(R.id.lv_title);
                convertView.setTag(viewHold);
            }else {
                viewHold = (ViewHolder) convertView.getTag();
            }
            viewHold.title.setText(mData.get(position).get("title"));
            convertView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });
            convertView.setClickable(false);
        }else {
            if(convertView==null){
                viewHold=new ViewHolder();
                convertView= mInflater.inflate(R.layout.list_item,parent, false);
                viewHold.text= (TextView) convertView.findViewById(R.id.lv_text);
                viewHold.info= (TextView) convertView.findViewById(R.id.lv_info);
                viewHold.tv_check= (TextView) convertView.findViewById(R.id.tv_open);
                viewHold.tv_changen= (TextView) convertView.findViewById(R.id.tv_change);
                viewHold.tv_del= (TextView) convertView.findViewById(R.id.tv_del);
                convertView.setTag(viewHold);
            }else {
                viewHold = (ViewHolder) convertView.getTag();
            }
            viewHold.text.setText(mData.get(position).get("text"));
            viewHold.info.setText(mData.get(position).get("info"));

        }
        return convertView;
    }
    class ViewHolder {
        TextView title,text,info;
        TextView tv_check,tv_changen,tv_del;
    }
}
