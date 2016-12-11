package com.ed.edou.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 统一下单信息
 * Created by xmg on 2016/12/5.
 */

@XStreamAlias("xml")
public class OrederSendInfo {

//    应用ID		appid
//    商户号		mch_id
//    随机字符串	nonce_str	随机数生成算法
//    商品描述	body		鹅豆-旅游
//    商户订单号	out_trade_no	32个字符内
//    总金额		total_fee       单位：分
//    终端IP		spbill_create_ip
//    通知地址	notify_url
//    交易类型	trade_type	APP

//    签名		sign		签名生成算法

    private String appid;
    private String mch_id;
    private String nonce_str;
    private String body;
    private String out_trade_no;
    private String total_fee;
    private String spbill_create_ip;
    private String notify_url;
    private String trade_type;

    private String sign;

    public OrederSendInfo(String appid, String mch_id, String nonce_str, String body, String out_trade_no, String total_fee, String spbill_create_ip, String notify_url, String trade_type) {
        this.appid = appid;
        this.mch_id = mch_id;
        this.nonce_str = nonce_str;
        this.body = body;
        this.out_trade_no = out_trade_no;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
        this.notify_url = notify_url;
        this.trade_type = trade_type;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    //注意排序规则ASCII排序（一般按照A-Z,a-z）就行
    @Override
    public String toString() {
        return "appid=" + appid  + '&' +
                "body=" + body + '&' +
                "mch_id=" + mch_id  + '&' +
                "nonce_str=" + nonce_str  + '&' +
                "notify_url=" + notify_url + '&' +
                "out_trade_no=" + out_trade_no + '&' +
                "spbill_create_ip=" + spbill_create_ip + '&' +
                "total_fee=" + total_fee + '&' +
                "trade_type=" + trade_type + '&';
    }
}
