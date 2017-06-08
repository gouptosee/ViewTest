package test.viewtest.normal;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import test.viewtest.R;

/**
 * Created by admin on 2017/6/2.
 */

public class NormalList extends Activity {

    ListView lv;
    List<String> dataList = new ArrayList<>();
    LayoutAnimationController controller;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_lv);
        initRes();
    }

    private void initRes(){
        lv = (ListView) findViewById(R.id.lv);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.anim_left_in);
        controller = new LayoutAnimationController(anim);
//        controller.setDelay(1000);
        controller.setDelay(0.3f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        controller.setInterpolator(new BounceInterpolator());




        for(int i =0 ;i <50;i++){
            dataList.add("data" + i);
        }


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        lv.setAdapter(adapter);
        lv.setLayoutAnimation(controller);
        lv.startLayoutAnimation();

    }
}
