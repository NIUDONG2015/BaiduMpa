package toasttest.luuuzi.baidumapdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

public class HelloBaiduMapActivity extends BaseActivity implements View.OnClickListener {
    private Context mContext;
    private String tag;




    private Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }







    //5.更新地图状态
    //        1)缩小
//            2)放大
//            3)旋转(0~360),每次在原来的基础上在旋转30度
//            4)俯、仰(0~45),每次在原来的基础上在俯视-5度
//            5)移动
    @Override
    public void onClick(View view) {
        MapStatusUpdate mapstatusupdate=null;
        switch (view.getId()) {
            case R.id.btn1:
                //        1)缩小
                mapstatusupdate=MapStatusUpdateFactory.zoomOut();
                break;
            case R.id.btn2:
                //            2)放大
                mapstatusupdate=MapStatusUpdateFactory.zoomIn();
                break;
            case R.id.btn3:
                //            3)旋转(0~360),每次在原来的基础上在旋转30度
                //3.1先拿到原来的角度
                MapStatus currentMapStatus=baiduMap.getMapStatus();
                //原来的角度+30度
                float rotate=currentMapStatus.rotate+30;
                //创建一个地图状态，给该状态中添加角度
                MapStatus mapStatus=new MapStatus.Builder().rotate(rotate).build();
                mapstatusupdate=MapStatusUpdateFactory.newMapStatus(mapStatus);
                break;
            case R.id.btn4:
                //            4)俯、仰(0~45),每次在原来的基础上在俯视-5度(只支持负数，正数没有效果)
                MapStatus currentMapStatus4=baiduMap.getMapStatus();
                float overlook=currentMapStatus4.overlook-5;
                MapStatus mapStatus4=new MapStatus.Builder().overlook(overlook).build();
                mapstatusupdate=MapStatusUpdateFactory.newMapStatus(mapStatus4);
                break;
            case R.id.btn5:
                //            5)移动
                mapstatusupdate=MapStatusUpdateFactory.newLatLng(tencentPos);
                //让其缓慢移动,以动画的方式更新地图动态，动画耗时2s，
                baiduMap.animateMapStatus(mapstatusupdate,2000);
        }
        baiduMap.setMapStatus(mapstatusupdate);

    }

}
