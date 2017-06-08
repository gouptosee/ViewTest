package test.viewtest.layoutanim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import test.viewtest.R;

/**
 * Created by admin on 2017/6/2.
 */

public class NormalLayoutAnim extends Activity implements View.OnClickListener {

    LinearLayout ll;
    Button add,remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_linear);
        initRes();
        initData();
    }

    private void initRes(){
        ll = (LinearLayout) findViewById(R.id.ll);
        add = (Button) findViewById(R.id.btn_nor_ll_add);
        remove = (Button) findViewById(R.id.btn_nor_ll_del);

    }


    protected void initData(){
        add.setOnClickListener(this);
        remove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_nor_ll_add:
                doAdd();
                break;
            case R.id.btn_nor_ll_del:
                if(ll.getChildCount() > 0) ll.removeViewAt(randomIndex(ll.getChildCount()));
                break;
        }
    }

    private void doAdd(){
        Button btn = new Button(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        float density = getResources().getDisplayMetrics().density;
        params.height = (int) (50 * density);
        params.width= (int) (120 * density);
        btn.setText("Button");
        btn.setLayoutParams(params);
        ll.addView(btn,0);
    }

    private int randomIndex(int childCount){
        return (int) (Math.random() * childCount);
    }
}
