package com.example.simpleadapt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> data;//数据集合 其中的一条相当于ListView中的一行
    private Map<String, Object> map;//存储ListView中内容
    //要引入的图片地址
    private int image[] = {R.drawable.ic_launcher,R.drawable.ic_launcher};
    //文章的标题
    String title[] = {"NBA","电影"};
    //文章的简单描述
    String desc[] = {"骑士三巨头怒刷90分，吊打猛龙","最新电影你的名字好评率极高"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();

        //填充ListView中每行的数据
        for (int i = 0; i < image.length; i++) {
            map = new HashMap<String, Object>();
            map.put("image", image[i]);
            map.put("title", title[i]);
            map.put("desc", desc[i]);
            data.add(map);
        }
        //找到ListView
        listView = (ListView) findViewById(R.id.lv);
        //定义一个simpleadapt，并初始化
        //1.第一个参数为上下文对象
        //2.第二个参数为要显示的数据集合
        //3.第三个参数为自定义的ListView样式文件
        //4.第四个参数为map中的key值 这个key值必须一一对应要显示内容区域的地址
        //5.第五个参数为ListView中每一行中的标签id，也就是内容放的位置，要和第三个参数一一对应
        simpleAdapter = new SimpleAdapter(this, data, R.layout.mylayout,
                new String[]{"image","title","desc"}, new int[]{R.id.image,R.id.title,R.id.desc});
        listView.setAdapter(simpleAdapter);//注册adapt
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
