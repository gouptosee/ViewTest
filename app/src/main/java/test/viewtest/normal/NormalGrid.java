package test.viewtest.normal;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import test.viewtest.R;

/**
 * Created by admin on 2017/6/2.
 */

public class NormalGrid extends Activity {

    GridView gv;
    List<String> dataList = new ArrayList<>();
    GridLayoutAnimationController controller;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_gv);
        initRes();
    }

    private void initRes(){
        gv = (GridView) findViewById(R.id.gv);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.anim_left_in);
        controller = new GridLayoutAnimationController(anim);
//        controller.setDelay(1000);
        controller.setDelay(0.3f);
        controller.setDirection(GridLayoutAnimationController.DIRECTION_BOTTOM_TO_TOP|GridLayoutAnimationController.DIRECTION_RIGHT_TO_LEFT);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        controller.setInterpolator(new BounceInterpolator());
        gv.setLayoutAnimation(controller);



        for(int i =0 ;i <50;i++){
            dataList.add("data" + i);
        }


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        gv.setAdapter(adapter);
        gv.startLayoutAnimation();

    }
}
