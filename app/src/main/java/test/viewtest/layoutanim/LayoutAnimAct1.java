package test.viewtest.layoutanim;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;

/**
 * Created by admin on 2017/6/2.
 */

public class LayoutAnimAct1 extends  NormalLayoutAnim {
    LayoutTransition layoutTransition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        ObjectAnimator disappear = ObjectAnimator.ofFloat(null,"rotationY",0,180);
//        ObjectAnimator appear =
        PropertyValuesHolder appear1 = PropertyValuesHolder.ofFloat("alpha",0,1);
        PropertyValuesHolder appear2 = PropertyValuesHolder.ofFloat("scaleX",0,1);
        PropertyValuesHolder appear3 = PropertyValuesHolder.ofFloat("scaleY",0,1);
////
//        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left",0,0);
//        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top",1,1);
//        ObjectAnimator change_appear = ObjectAnimator.ofPropertyValuesHolder(ll,pvhLeft,pvhTop);
//
        ObjectAnimator appear =  ObjectAnimator.ofPropertyValuesHolder(ll,appear1,appear2,appear3);




        layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(LayoutTransition.APPEARING,appear);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,disappear);
//        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING,change_appear);
//        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,change_appear);
        ll.setLayoutTransition(layoutTransition);

    }
}
