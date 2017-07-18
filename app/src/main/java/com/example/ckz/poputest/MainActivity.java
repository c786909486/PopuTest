package com.example.ckz.poputest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button bottombtn;
    private android.widget.Button centerbtn;
    private Button grideBtn;
    private Button simpleBtn;
    private List<Integer> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.centerbtn = (Button) findViewById(R.id.center_btn);
        this.bottombtn = (Button) findViewById(R.id.bottom_btn);
        grideBtn = (Button) findViewById(R.id.grid);
        simpleBtn = (Button) findViewById(R.id.simple_btn);

        bottombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ShowPopup popu = new ShowPopup(MainActivity.this);
                popu.createLayoutPopupWindow(R.layout.popu_windows_bottom)
                        .setAnim(R.style.Animation)
                        .atBottom(view)
                        .setClick(R.id.test1, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_SHORT).show();
                                popu.closePopupWindow();

                            }
                        }).setDismissClick(R.id.test2);
            }
        });


        centerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ShowPopup popu = new ShowPopup(MainActivity.this);
                popu.createLayoutPopupWindow(R.layout.popu_windows_bottom).dropDown(view,0,0)
                        .setClick(R.id.test1, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"点击了1",Toast.LENGTH_SHORT).show();
                                popu.closePopupWindow();
                            }
                        }).setClick(R.id.test2, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"点击了2",Toast.LENGTH_SHORT).show();
                        popu.closePopupWindow();
                    }
                });
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
                popu.createLayoutPopupWindow(R.layout.popu_girde_bottom)
                        .setAnim(R.style.Animation)
                        .atBottom(view).setDismissClick(R.id.cancel_btn);
                RecyclerView recyclerView = (RecyclerView) popu.getView().findViewById(R.id.share_list);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
                MyAdapter adapter = new MyAdapter(MainActivity.this,mData);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClickListener(View view, int position) {
                        Toast.makeText(MainActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                        popu.closePopupWindow();
                    }
                });
            }
        });

        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ShowPopup popu = new ShowPopup(MainActivity.this);
                popu.createSimplePopupWindow("点击","开始","取消")
                        .setAnim(R.style.Animation)
                        .atBottom(view)
                        .setPositionClickListener(new ShowPopup.OnPositionClickListener() {
                            @Override
                            public void OnPositonClick(View view, int position) {
                                switch (position){
                                    case 0:
                                        Toast.makeText(MainActivity.this,"点击了1",Toast.LENGTH_SHORT).show();
                                        break;
                                    case 1:
                                        Toast.makeText(MainActivity.this,"点击了2",Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        popu.closePopupWindow();
                                        break;
                                }
                            }
                        });
            }
        });

    }
}
