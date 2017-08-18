package test.viewtest.test;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * Created by admin on 2017/7/13.
 */

public class TestViews extends RelativeLayout {
    private String TAG = getClass().getSimpleName();
    private boolean isAttachToWindow = false;

    public TestViews(Context context) {
        this(context, null);
    }

    public TestViews(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestViews(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.w(TAG, " <--------------------------------------------------->");
        Log.w(TAG, "onCreate");
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.w(TAG, "onFinishInflate");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        Log.w(TAG, "onAttachedToWindow");
        isAttachToWindow = true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.w(TAG, "onMeasure");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.w(TAG, "onSizeChanged");
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.w(TAG, "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.w(TAG, "onDraw");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.w(TAG, "onDetachedFromWindow    " );
        isAttachToWindow = false;
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Log.w(TAG, "onWindowVisibilityChanged    " + visibility);

    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.w(TAG, "onWindowFocusChanged    " + hasWindowFocus);
    }

    public void setListener() {
//        onAttachedToWindow();
//        onWindowVisibilityChanged(VISIBLE);
    }

    public void destory() {
        onWindowVisibilityChanged(GONE);
//        onWindowFocusChanged(false);
        onDetachedFromWindow();
    }

    @Override
    public boolean isAttachedToWindow() {
        super.isAttachedToWindow();
        return isAttachToWindow;
    }

//    @Override
//    public int getVisibility() {
//        return super.getVisibility();
//    }

}
