package test.viewtest.test;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by admin on 2017/7/13.
 */

public class AttachUtils {



    private void addAdToWindow(Context mCtx,View view, int gravity) {
        WindowManager mWindowManager = (WindowManager) mCtx.getSystemService(Context.WINDOW_SERVICE);
        int flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        int type;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            type = WindowManager.LayoutParams.TYPE_TOAST;
        } else {
            type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                type, flags, PixelFormat.TRANSLUCENT);
        layoutParams.gravity = gravity;
        view.setVisibility(View.GONE);
        mWindowManager.addView(view, layoutParams);
    }


    private void removeAdFromWindow(Context mCtx ,View view) {
        WindowManager mWindowManager = (WindowManager) mCtx.getSystemService(Context.WINDOW_SERVICE);
        try {
            mWindowManager.removeViewImmediate(view);
        }catch (Exception e){}

    }

}
