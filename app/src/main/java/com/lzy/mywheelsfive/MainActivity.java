package com.lzy.mywheelsfive;

import android.view.View;
import android.widget.Button;

import com.lzy.mywheelsfive.Base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button mBtShare;
    private Button mBtQQ;
    private Button mBtQZone;
    private Button mBtSiNa;
    private Button mBtWZ;
    private Button mBtFriend;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBtShare = (Button) findViewById(R.id.bt_share);
        mBtQQ = (Button) findViewById(R.id.bt_QQ);
        mBtQZone = (Button) findViewById(R.id.bt_QZone);
        mBtSiNa = (Button) findViewById(R.id.bt_SiNa);
        mBtWZ = (Button) findViewById(R.id.bt_WZ);
        mBtFriend = (Button) findViewById(R.id.bt_Friend);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void setClickEvent() {


        mBtQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.sendQQ();
            }
        });

        mBtQZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.sendQzone();
            }
        });
        mBtSiNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.sendSiNa();
            }
        });

        mBtWZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.sendWeChat();
            }
        });
        mBtFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.sendWeChatCore();
            }
        });
    }



}
