package com.lzy.pay;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alipay.sdk.app.PayTask;
import com.lzy.pay.alipay.PayResult;
import com.lzy.pay.wxapi.WeiChatPayBean;
import com.lzy.pay.wxapi.WeiChatPayUtils;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button mAliPay;
    private Button mWxPay;

    /**
     * 支付宝支付
     */

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: " + msg.obj.toString());
            @SuppressWarnings("unchecked")
            PayResult payResult = new PayResult((Map<String, String>) msg.obj);
            /**
             对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
             */
            String resultInfo = payResult.getResult();// 同步返回需要验证的信息
            String resultStatus = payResult.getResultStatus();
            // 判断resultStatus 为9000则代表支付成功
            if (TextUtils.equals(resultStatus, "9000")) {
                // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                MyToast.makeText(MainActivity.this, "支付成功");
                finish();
            } else {
                // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                MyToast.makeText(MainActivity.this, "支付失败");
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }


    private void initView() {
        mAliPay = (Button) findViewById(R.id.ali_pay);
        mWxPay = (Button) findViewById(R.id.wx_pay);
    }


    private void setListener() {

        mAliPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String orderInfo = Constant.ali_Info;
                Runnable payRunnable = new Runnable() {
                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(MainActivity.this);
                        Map<String, String> result = alipay.payV2(orderInfo, true);
                        Log.i("msp", result.toString());
                        Message msg = new Message();
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };
                Thread payThread = new Thread(payRunnable);
                payThread.start();
            }
        });

        mWxPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeiChatPayBean data = new WeiChatPayBean();
                data.setAppid("wxdb11265ac6b10f86");
                data.setPartnerid("1428905702");
                data.setPrepayid("wx20171227093714c97a8347cb0750274479");
                data.setNoncestr("12c427e8cafb4af5886d83c04b65ef86");
                data.setTimestamp("1514338631");
                data.setPackageX("Sign=WXPay");
                data.setSign("2E9C82B3FDD7F553529570DA6B72FA92");

                data.setPayment_code("wechatpay");


                WeiChatPayUtils.weiChatPay(MainActivity.this,data);


            }
        });
    }

}
