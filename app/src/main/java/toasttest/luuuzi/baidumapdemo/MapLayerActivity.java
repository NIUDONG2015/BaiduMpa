package toasttest.luuuzi.baidumapdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.map.BaiduMap;

/**
 * 显示地图图层
 * 地图可以包含一个或多个图层，每个图层在每个级别都是由若干个图块组成的，它们覆盖了地图的整个表面。

 百度地图小应用
 	百度地图热力图（http://map.baidu.com/heatmap/index/index ）
 	百度坐标拾取（http://api.map.baidu.com/lbsapi/getpoint/index.html ）
 	百度迁徙（http://qianxi.baidu.com/ ）
 	商户免费标注（http://biaozhu.baidu.com/?from=maptop#/ 可标注自己的公司在地图上的位置）

 图层分类
 	底图
 	卫星图（卫星地图是卫星拍摄的真实的地理面貌，所以卫星地图可用来检测地面的信息，你可以了解到地理位置，地形等。）
 	交通图
 baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE) 设置地图类型
 baiduMap.setTrafficEnabled(true) 是否显示交通图

 基础地图和上面的各种覆盖物元素，具有一定的层级压盖关系（从下至上的顺序）:
 1、基础底图（包括底图、底图道路、卫星图等）；
 2、地形图图层（GroundOverlay）；
 3、热力图图层（HeatMap）；

 * Created by luuuzi on 2017/9/27.
 */

public class MapLayerActivity extends BaseActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                //显示普通地图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                //只显示普通地图，不显示其他地图
                baiduMap.setTrafficEnabled(false);

                break;
            case R.id.btn2:
                //显示卫星地图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                baiduMap.setTrafficEnabled(false);
                break;
            //  显示交通图
            case R.id.btn3:
                baiduMap.setTrafficEnabled(true);
                break;
        }
    }
}
