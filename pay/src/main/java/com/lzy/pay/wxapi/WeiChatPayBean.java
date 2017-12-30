package com.lzy.pay.wxapi;



/**
 * Created by nee on 2017/12/26.
 */

public class WeiChatPayBean {


    /**
     * package : Sign=WXPay
     * appid : wxdb11265ac6b10f86
     * sign : 2E9C82B3FDD7F553529570DA6B72FA92
     * partnerid : 1428905702
     * prepayid : wx20171227093714c97a8347cb0750274479
     * noncestr : 12c427e8cafb4af5886d83c04b65ef86
     * payment_code : wechatpay
     * timestamp : 1514338631
     * status : SUCCESS
     */


    private String packageX;
    private String appid;
    private String sign;
    private String partnerid;
    private String prepayid;
    private String noncestr;
    private String payment_code;
    private String timestamp;
    private String status;

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPayment_code() {
        return payment_code;
    }

    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
