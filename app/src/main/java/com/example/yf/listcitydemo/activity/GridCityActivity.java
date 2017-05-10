package com.example.yf.listcitydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yf.listcitydemo.R;
import com.example.yf.listcitydemo.adapter.ItemAdapter;
import com.example.yf.listcitydemo.model.CityModel;
import com.example.yf.listcitydemo.util.FileUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GridCityActivity extends AppCompatActivity implements RecyclerItemClickListener.OnItemClickListener {

    //封装城市列表数据
    private ArrayMap<String, ArrayList<CityModel>> map = new ArrayMap<>();
    //首字母数据
    private ArrayList<CityModel> nameSortsList = new ArrayList<>();

    private RecyclerView mRecyclerview;
    private ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        Intent intent = getIntent();
        String style = intent.getStringExtra("style");
        initData();
        initGridRecy(style);
    }

    private void initGridRecy(String style) {
        mRecyclerview = (RecyclerView) findViewById(R.id.list_cyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ItemAdapter(this);
        adapter.setData(nameSortsList);
        //列表和网格布局
        adapter.setCityName(map);
        adapter.setStyle(style);
        adapter.setOnItmeListener(this);
        mRecyclerview.setAdapter(adapter);
    }

    private void initData() {
        String json = FileUtil.getFromRaw(this);
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nameSort = jsonObject.getString("key");
                JSONArray jsonCityArray = jsonObject.getJSONArray("list");
                CityModel cityModel = new CityModel();
                cityModel.setNameScort(nameSort);
                addMap(nameSort, jsonCityArray);
                nameSortsList.add(cityModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void addMap(String nameSort, JSONArray jsonCityArray) {
        if (!map.containsKey(nameSort)) {
            map.put(nameSort, new ArrayList<CityModel>());
        }

        for (int i = 0; i < jsonCityArray.length(); i++) {
            CityModel cityModel = new CityModel();
            try {
                JSONObject jsonCityObject = jsonCityArray.getJSONObject(i);
                String realName = jsonCityObject.getString("realname");
                String displayName = jsonCityObject.getString("displayname");
                cityModel.setCityName(displayName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            map.get(nameSort).add(cityModel);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, ((TextView) view).getText(), Toast.LENGTH_LONG).show();
    }
}
