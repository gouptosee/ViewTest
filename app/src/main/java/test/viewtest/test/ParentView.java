package test.viewtest.test;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by admin on 2017/7/13.
 */

public class ParentView extends RelativeLayout {

    private TestViews testViews;

    public ParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentView(Context context) {
        super(context);
    }

    public ParentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isAttachedToWindow() {
        return testViews == null ? false : testViews.isAttachedToWindow();
    }

    public void destory() {
        if (testViews != null) {
            testViews.destory();
        }
    }
}
