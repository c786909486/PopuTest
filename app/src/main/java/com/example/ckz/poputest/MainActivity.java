package com.example.ckz.poputest;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button bottombtn;
    private android.widget.Button centerbtn;
    private Button grideBtn;
    private MyAdapter adapter;
    private List<Integer> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.centerbtn = (Button) findViewById(R.id.center_btn);
        this.bottombtn = (Button) findViewById(R.id.bottom_btn);
        grideBtn = (Button) findViewById(R.id.grid);

        bottombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup popu = new ShowPopup(MainActivity.this);
                popu.showSimplePopupWindows(R.layout.popu_windows_bottom)
                        .setAnim(R.style.Animation)
                        .atBottom(view)
                        .setClick(R.id.test1, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_SHORT).show();
                            }
                        }).setDismissClick(R.id.test2);
            }
        });


        centerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup popu = new ShowPopup(MainActivity.this);
                popu.showSimplePopupWindows(R.layout.popu_windows_bottom).dropDown(view,0,0)
                        .setClick(R.id.test1, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_SHORT).show();
                            }
                        }).setDismissClick(R.id.test2);
            }
        });


        mData = new ArrayList<>();
        mData.add(R.mipmap.zhifubao);
        mData.add(R.mipmap.weibo);
        mData.add(R.mipmap.kongjian);
        mData.add(R.mipmap.qq);
        mData.add(R.mipmap.weixin);
        mData.add(R.mipmap.pengyouquan);

        grideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ShowPopup popu = new ShowPopup(MainActivity.this);
                popu.showSimplePopupWindows(R.layout.popu_girde_bottom)
                        .setAnim(R.style.Animation)
                        .atBottom(view).setDismissClick(R.id.cancel_btn);
                RecyclerView recyclerView = (RecyclerView) popu.getView().findViewById(R.id.share_list);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
                adapter = new MyAdapter(MainActivity.this,mData);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClickListener(View view, int position) {
                        Toast.makeText(MainActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
