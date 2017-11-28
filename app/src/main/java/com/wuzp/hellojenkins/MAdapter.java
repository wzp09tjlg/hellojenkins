package com.wuzp.hellojenkins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wuzp on 2017/11/28.
 */
public class MAdapter extends BaseAdapter {

    private Context mContext;
    private List<Bean> mData;
    private LayoutInflater inflater;

    public MAdapter(Context context, List<Bean> data){
      this.mContext = context;
        this.mData = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData == null? 0 : mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
           view = inflater.inflate(R.layout.item_list,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
          viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(mData.get(i).title);
        viewHolder.subTitle.setText(mData.get(i).subtitle);
        return view;
    }

    static class ViewHolder{
        private TextView title;
        private TextView subTitle;

        public ViewHolder(View view){
            title = (TextView)view.findViewById(R.id.tv_title);
            subTitle = (TextView)view.findViewById(R.id.tv_subtitle);
        }
    }
}
