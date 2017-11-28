package com.wuzp.hellojenkins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MAdapter mAdapter;
    List<Bean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        listView = (ListView)findViewById(R.id.list);
    }

    private void initData(){
        getData();
        mAdapter = new MAdapter(this,mData);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"" + mData.get(i),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData(){
        mData = new ArrayList<>();
        for(int i=0;i<20;i++){
            Bean bean = new Bean();
            bean.title = "name "+i;
            bean.subtitle = "subname " + i;
            mData.add(bean);
        }
    }
}
