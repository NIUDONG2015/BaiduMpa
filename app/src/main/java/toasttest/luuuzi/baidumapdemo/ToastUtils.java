package toasttest.luuuzi.baidumapdemo;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by luuuzi on 2017/9/27.
 */

class ToastUtils {
    /*自定义toast显示*/
    public static void showToast(Context context, CharSequence text) {
        Toast toast=Toast.makeText(context,text,Toast.LENGTH_SHORT);
        //设置显示位置
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
