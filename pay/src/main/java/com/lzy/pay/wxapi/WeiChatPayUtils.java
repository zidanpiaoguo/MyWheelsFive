package com.lzy.pay.wxapi;

import android.content.Context;
import android.widget.Toast;

import com.lzy.pay.Constant;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;



/**
 * Created by nee on 2017/12/26.
 */

public class WeiChatPayUtils {
    private static IWXAPI api;
    public static void  weiChatPay(Context mContext, WeiChatPayBean weichatPayBean){
        api = WXAPIFactory.createWXAPI(mContext, Constant.WX_APPID);
        PayReq req = new PayReq();
        //req.appId = "wxf8b4f85f3a794e77";  // 测试用appId
        req.appId			= weichatPayBean.getAppid();
        req.partnerId		= weichatPayBean.getPartnerid();
        req.prepayId		= weichatPayBean.getPrepayid();
        req.nonceStr		= weichatPayBean.getNoncestr();
        req.timeStamp		= weichatPayBean.getTimestamp();
        req.packageValue	= weichatPayBean.getPackageX();
        req.sign			= weichatPayBean.getSign();

        Toast.makeText(mContext, "正常调起支付", Toast.LENGTH_SHORT).show();
        // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
        api.sendReq(req);
    }
}
