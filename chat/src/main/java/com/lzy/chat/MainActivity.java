package com.lzy.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.YWLoginParam;
import com.alibaba.mobileim.channel.event.IWxCallback;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    YWIMKit mIMKit;
    private Button mLogin1;
    private Button mLogin2;
    private Button mOpen1;
    private Button mOpen2;
    private Button mLogin0;
    private Button mOpen0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initListener();
    }
    private void initView() {
        mLogin1 = (Button) findViewById(R.id.login1);
        mLogin2 = (Button) findViewById(R.id.login2);
        mOpen1 = (Button) findViewById(R.id.open1);
        mOpen2 = (Button) findViewById(R.id.open2);
        mLogin0 = (Button) findViewById(R.id.login0);
        mOpen0 = (Button) findViewById(R.id.open0);
    }
    private void initListener() {

        mLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login("test1","123456");
            }
        });

        mLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login("test2","123456");
            }
        });

        mOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChat();

            }
        });

        mOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChat();
            }
        });

        mLogin0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login("test0","123456");
            }
        });

        mOpen0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = mIMKit.getConversationActivityIntent();
                startActivity(intent);
            }
        });

    }

    private void openChat() {
//        //userid是客服帐号，第一个参数是客服帐号，第二个是组ID，如果没有，传0
//        EServiceContact contact = new EServiceContact("test0", 0);
//        //如果需要发给指定的客服帐号，不需要Server进行分流(默认Server会分流)，请调用EServiceContact对象
//        //的setNeedByPass方法，参数为false。
//        //contact.setNeedByPass(false);
//        Intent intent = mIMKit.getChattingActivityIntent(contact);
//        startActivity(intent);


        final String target = "test0";//消息接收者ID

        final String appkey = "24747420";//消息接收者appKey

        Intent intent = mIMKit.getChattingActivityIntent(target, appkey);

        startActivity(intent);

    }

    private void login(String userid,String password) {


        //此实现不一定要放在Application onCreate中
        final String APP_KEY = "24747420";

        //此对象获取到后，保存为全局对象，供APP使用
        //此对象跟用户相关，如果切换了用户，需要重新获取
        mIMKit = YWAPI.getIMKitInstance(userid, APP_KEY);


        //开始登录
        IYWLoginService loginService = mIMKit.getLoginService();

        YWLoginParam loginParam = YWLoginParam.createLoginParam(userid, password);
        loginService.login(loginParam, new IWxCallback() {

            @Override
            public void onSuccess(Object... arg0) {
                Log.d(TAG, "onSuccess: ");
                Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onProgress(int arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onError(int errCode, String description) {
                //如果登录失败，errCode为错误码,description是错误的具体描述信息
                Log.d(TAG, "onError: " + description);
            }
        });
    }


    private void logout(String userid){


        //此实现不一定要放在Application onCreate中
        final String APP_KEY = "24747420";

        //此对象获取到后，保存为全局对象，供APP使用
        //此对象跟用户相关，如果切换了用户，需要重新获取
        mIMKit = YWAPI.getIMKitInstance(userid, APP_KEY);

        //退出登录
        IYWLoginService loginService = mIMKit.getLoginService();
        loginService.logout(new IWxCallback() {
            @Override
            public void onSuccess(Object... objects) {

            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i) {

            }
        });
    }

}
