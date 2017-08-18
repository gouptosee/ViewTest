package test.viewtest.test;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import test.viewtest.R;

/**
 * Created by admin on 2017/7/13.
 */

public class LifeTestAct extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add_win, btn_create_parent, btn_create_only;
    private RelativeLayout rl_container_main;
    private RelativeLayout rl_container_extra;
    private TestViews views;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_test);
        initRes();
    }

    private void initRes() {
        btn_add_win = (Button) findViewById(R.id.btn_add_to_win);
        btn_create_parent = (Button) findViewById(R.id.btn_create__parent);
        btn_create_only = (Button) findViewById(R.id.btn_create_only);
        rl_container_main = (RelativeLayout) findViewById(R.id.rl_container);

        btn_add_win.setOnClickListener(this);
        btn_create_parent.setOnClickListener(this);
        btn_create_only.setOnClickListener(this);

    }

    private void initRel() {
        rl_container_extra = new RelativeLayout(this);
        int height = getResources().getDisplayMetrics().heightPixels;
        int width = getResources().getDisplayMetrics().widthPixels;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        rl_container_extra.setLayoutParams(params);
    }

    private void initViews() {
        views = null;
        views = new TestViews(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        views.setLayoutParams(params);
    }


    @Override
    public void onClick(View v) {
        rl_container_main.removeAllViews();
        if (rl_container_extra != null)
            rl_container_extra.removeAllViews();
        initViews();
        switch (v.getId()) {
            case R.id.btn_add_to_win:
                views.setVisibility(View.VISIBLE);
                rl_container_main.addView(views);
                rl_container_main.setVisibility(View.GONE);
                Log.w("1234",views.getVisibility() +"      " + rl_container_main.getVisibility());

                break;
            case R.id.btn_create__parent:
                initRel();

                views.setListener();
                rl_container_extra.addView(views);
//                Log.w("TestViews","afterAdd");
                rl_container_extra.measure(
                        View.MeasureSpec.makeMeasureSpec(rl_container_extra.getLayoutParams().width, View.MeasureSpec.EXACTLY),
                        View.MeasureSpec.makeMeasureSpec(rl_container_extra.getLayoutParams().height, View.MeasureSpec.EXACTLY));
                rl_container_extra.layout(0, 0, rl_container_extra.getMeasuredWidth(), rl_container_extra.getMeasuredHeight());

//                if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.KITKAT)
//                Log.w("TestViews","isAttachToWindow   " + views.isAttachedToWindow());

                break;
            case R.id.btn_create_only:
//                Log.w("TestViews","visbility     "  + views.getVisibility());
                break;
        }
    }
}
