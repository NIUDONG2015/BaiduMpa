package toasttest.luuuzi.baidumapdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baidu.mapapi.map.Circle;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.Stroke;

/**
 * Created by luuuzi on 2017/9/27.
 */

public class CircleOverlayActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加圆形覆盖物
        //创建一个圆形覆盖物的参数
        CircleOptions options=new CircleOptions();
        //指定圆的属性

        options.center(tencentPos);//圆心
        options.radius(1000);//半径
        options.stroke(new Stroke(20,0x55ff0000));//线条宽度,线条颜色(16进制的8位)
        options.fillColor(0x55ff0000);//圆的填充颜色
        //添加一个覆盖物
        baiduMap.addOverlay(options);
    }
}
