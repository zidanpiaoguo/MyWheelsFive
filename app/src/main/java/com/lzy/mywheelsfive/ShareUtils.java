package com.lzy.mywheelsfive;

import android.util.Log;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * Created by bullet on 2017/12/19.
 */

public class ShareUtils {
    private static final String TAG = "ShareUtils";

    public static void sendQzone() {

        Platform.ShareParams sp = new Platform.ShareParams();
        //必须带的四个参数
        sp.setTitle("测试分享的标题");
        sp.setTitleUrl("http://www.baidu.com"); // 标题的超链接
        sp.setSite("发布分享的网站名称");
        sp.setSiteUrl("发布分享网站的地址");

        sp.setText("测试分享的文本");
        sp.setImageUrl("http://www.someserver.com/测试图片网络地址.jpg");
        Platform qzone = ShareSDK.getPlatform(QZone.NAME);
        // 设置分享事件回调（注：回调放在不能保证在主线程调用，不可以在里面直接处理UI操作）
        qzone.setPlatformActionListener(new PlatformActionListener() {
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                //失败的回调，arg:平台对象，arg1:表示当前的动作，arg2:异常信息
                Log.d(TAG, "onError: "+"Qzone");
            }

            public void onComplete(Platform arg0, int arg1, HashMap arg2) {
                //分享成功的回调

                Log.d(TAG, "onComplete: "+"Qzone");
            }

            public void onCancel(Platform arg0, int arg1) {
                //取消分享的回调
                Log.d(TAG, "onCancel: "+"Qzone");
            }
        });
        // 执行图文分享
        qzone.share(sp);
    }


    public static void sendQQ(){
        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setTitle("测试分享的标题");
        sp.setTitleUrl("http://www.baidu.com"); // 标题的超链接
        sp.setText("测试分享的文本");
        sp.setImageUrl("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");

        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        // 设置分享事件回调（注：回调放在不能保证在主线程调用，不可以在里面直接处理UI操作）
        qq.setPlatformActionListener(new PlatformActionListener() {
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                //失败的回调，arg:平台对象，arg1:表示当前的动作，arg2:异常信息
            }

            public void onComplete(Platform arg0, int arg1, HashMap arg2) {
                //分享成功的回调
            }

            public void onCancel(Platform arg0, int arg1) {
                //取消分享的回调
            }
        });
        // 执行图文分享
        qq.share(sp);
    }


    public static void sendSiNa(){

        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setText("测试分享的文本");
        sp.setImageUrl("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");

        Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
        weibo.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        }); // 设置分享事件回调
        // 执行图文分享
        weibo.share(sp);
    }


    /**
     * 分享微信好友
     */
    public static void sendWeChat(){


        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setTitle("标题");
        sp.setText("测试分享的文本");

        sp.setImageUrl("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        sp.setUrl("http://www.baidu.com");
        sp.setShareType(Platform.SHARE_WEBPAGE);
        Platform weibo = ShareSDK.getPlatform(Wechat.NAME);
        weibo.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

                Log.d(TAG, "onComplete: ");
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

                Log.d(TAG, "onError: "+throwable.getMessage());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d(TAG, "onCancel: ");

            }
        }); // 设置分享事件回调
        // 执行图文分享
        weibo.share(sp);
    }



    /**
     * 分享微信朋友圈
     */
    public static void sendWeChatCore(){


        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setTitle("标题");
        sp.setText("测试分享的文本");

        sp.setImageUrl("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        sp.setUrl("http://www.baidu.com");
        sp.setShareType(Platform.SHARE_WEBPAGE);
        Platform weibo = ShareSDK.getPlatform(WechatMoments.NAME);
        weibo.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        }); // 设置分享事件回调
        // 执行图文分享
        weibo.share(sp);
    }





}
