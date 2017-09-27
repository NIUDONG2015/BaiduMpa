package toasttest.luuuzi.baidumapdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;

/**
 * Created by luuuzi on 2017/9/26.
 */

public class BaseActivity extends Activity {
    private String tag="BaseActivity";
    public MapView mMapView;
    BaiduMap baiduMap;
    //地图状态发生改变
    public MapStatusUpdate mMapStatusUpdate;
    //坐标对象（举例：腾讯大厦坐标：22.5460778801,113.9410619639）
    //参数1：纬度，参数2：经度
    public LatLng tencentPos = new LatLng(22.5460778801, 113.9410619639);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tag = "HelloBaiduMapActivity";
        mMapView = (MapView) findViewById(R.id.bmapView);
        baidumapTest();




    }

    private void baidumapTest() {
        //获取地图控制器,可以获取好多事件监听
        baiduMap = mMapView.getMap();
        //        1.隐藏缩放按钮，比例尺
        //mMapView.showZoomControls(false);//隐藏缩放按钮，默认为显示
        //mMapView.showScaleControl(false);//隐藏比例尺按钮,默认是显示的
        //通过控制器
        float maxZoomLevel = baiduMap.getMaxZoomLevel();//获取地图的最大缩放级别
        float minZoomLevel = baiduMap.getMinZoomLevel();//获取地图的最小缩放级别
        //        2.获取最小(3),最大缩放级别(22)
        Log.i(tag, "地图最大缩放级别" + maxZoomLevel + ";地图最小缩放级别:" + minZoomLevel);
        //09-26 11:46:29.401: I/HelloBaiduMapActivity(30819): 地图最大缩放级别22.0;地图最小缩放级别:3.0

//        3.设置地图中心点
        //newLatLng，通过经纬度设置中心位置，参数1()：维度,参数2：经度
        mMapStatusUpdate = MapStatusUpdateFactory.newLatLng(tencentPos);
        baiduMap.setMapStatus(mMapStatusUpdate);
//
        //  4.设置地图缩放为15
        //zoomBy（）是增量,zoomTo()是绝对值
        mMapStatusUpdate = MapStatusUpdateFactory.zoomTo(15);
        baiduMap.setMapStatus(mMapStatusUpdate);
        // 6.获取地图UI控制器：隐藏指南针
        UiSettings uiSetting=baiduMap.getUiSettings();
        //不显示指南针
        uiSetting.setCompassEnabled(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }


    public void showToast(CharSequence text){
        ToastUtils.showToast(this,text);

    }
}
