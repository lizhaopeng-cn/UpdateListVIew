package com.example.lzp.updatelistview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> datas;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        datas = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            datas.add("第"+i);
        }
        myAdapter = new MyAdapter(this, datas, new MyAdapter.OnUpdateClickListener() {
            @Override
            public void OnUpdate() {
                for(int i = 0; i < myAdapter.getCount(); i++){
                    LinearLayout linearLayout = (LinearLayout) listView.getAdapter().getView(i,null,null);
                    Button button = (Button) linearLayout.getChildAt(0);
//                    button.setBackgroundDrawable(getResources().getColor(R.color.colorPrimary));
                    Log.d("text", button.getText().toString());
                    button.setText("睡觉");
                }

                myAdapter.notifyDataSetChanged();
            }
        });
        listView.setAdapter(myAdapter);

    }

    public List<String> getDatas() {
        return datas;
    }
}
