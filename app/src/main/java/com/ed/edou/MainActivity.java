package com.ed.edou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ed.edou.bean.OrederSendInfo;
import com.ed.edou.bean.PrepayIdInfo;
import com.ed.edou.common.Constants;
import com.ed.edou.common.MyApplication;
import com.ed.edou.common.NetWorkFactory;
import com.ed.edou.utils.WXpayUtils;
import com.thoughtworks.xstream.XStream;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_prepare,btn_pay;
    PrepayIdInfo bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_prepare = (Button)findViewById(R.id.btn_prepare);
        btn_pay = (Button)findViewById(R.id.btn_pay);

        btn_pay.setEnabled(false);

        btn_prepare.setOnClickListener(this);
        btn_pay.setOnClickListener(this);



//        WXpayUtils.genSign(info);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_prepare:
                //生成预支付Id

                Date d = new Date();
                System.out.println(d);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String dateNowStr = sdf.format(d);
                System.out.println("格式化后的日期：" + dateNowStr);

                OrederSendInfo sendInfo = new OrederSendInfo(Constants.APP_ID,Constants.MCH_ID,WXpayUtils.genNonceStr(),"鹅豆-旅游2",dateNowStr,"1","127.0.0.1","www.baidu.com","APP");
                NetWorkFactory.UnfiedOrder(sendInfo, new NetWorkFactory.Listerner() {
                    @Override
                    public void Success(String data) {
                        Toast.makeText(MyApplication.getContext(),"生成预支付Id成功",Toast.LENGTH_LONG).show();
                        btn_pay.setEnabled(true);
                        XStream stream = new XStream();
                        stream.processAnnotations(PrepayIdInfo.class);
                        bean = (PrepayIdInfo) stream.fromXML(data);
                    }

                    @Override
                    public void Faiulre(String data) {
                    }
                });
                break;
            case R.id.btn_pay:
                btn_pay.setEnabled(false );
                WXpayUtils.Pay(bean.getPrepay_id());
                break;
        }
    }
}
