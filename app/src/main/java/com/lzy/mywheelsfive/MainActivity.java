package com.lzy.mywheelsfive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lzy.mywheelsfive.Base.BaseActivity;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class MainActivity extends BaseActivity {

    private Button mBtShare;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBtShare = (Button) findViewById(R.id.bt_share);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void setClickEvent() {

        mBtShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });

    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不     调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用

//        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//        oks.setTitleUrl("http://sharesdk.cn");

        // text是分享文本，所有平台都需要这个字段
//        oks.setText("我是分享文本");



        // url仅在微信（包括好友和朋友圈）中使用


        oks.setTitle("轮子");
//        // titleUrl是标题的网络链接，QQ和QQ空间等使用
//        oks.setTitleUrl("https://github.com/Horrarndoo/YiZhi");
//        // text是分享文本，所有平台都需要这个字段
        oks.setText("每日新闻，精选干货，最新资讯，应有尽有.项目详情链接：https://github.com/Horrarndoo/YiZhi");

        oks.setImageUrl("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");

//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setUrl("https://www.baidu.com/");



        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));

        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }

}
