package toasttest.luuuzi.baidumapdemo;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by luuuzi on 2017/9/27.
 */

public class DemoListActivity extends ListActivity {
    //监听key是否正确
    BroadcastReceiver mReceiver;
    ClassAndName[] datas={
        new ClassAndName(HelloBaiduMapActivity.class,"HelloBaiduMap"),
            new ClassAndName(MapLayerActivity.class,"地图图层"),
            new ClassAndName(CircleOverlayActivity.class,"圆形的覆盖物")
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<ClassAndName> adapter;
        adapter = new ArrayAdapter<ClassAndName>(this, android.R.layout.simple_list_item_1,datas);
        setListAdapter(adapter);
    }
    //ListView的点击事件
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //取出点击位置的对象
        ClassAndName classAndName= (ClassAndName) l.getItemAtPosition(position);
        startActivity(new Intent(this,classAndName.cls));
    }
    //5.监听key
    private void registerSDKCheckRecerver() {
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR.equals(action)) {
                    //showToast("网络错误");
                    ToastUtils.showToast(DemoListActivity.this,"网络错误");
                } else if (SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR.equals(action)) {
                    //showToast("key验证失败");
                    ToastUtils.showToast(DemoListActivity.this,"key验证失败");
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        //监听网络错误
        filter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        //监听百度地图sdk的key是否正确
        filter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
        //注册广播
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁广播
        unregisterReceiver(mReceiver);
    }

    class ClassAndName{
        //用于保存Activity的字节码
        public Class<?> cls;
        //用于保存Activity对应的名字
        public String name;

        public ClassAndName(Class<?> cls,String name){
            this.cls=cls;
            this.name=name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
