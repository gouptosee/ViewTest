package test.viewtest.view;

import android.app.Activity;
import android.os.Bundle;

import test.viewtest.R;

/**
 * Created by admin on 2017/6/2.
 */

public class ViewActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
    }
}
