package test.viewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.viewtest.image.Image1Activity;
import test.viewtest.layoutanim.LayoutAnimAct1;
import test.viewtest.layoutanim.NormalLayoutAnim;
import test.viewtest.normal.NormalGrid;
import test.viewtest.normal.NormalList;
import test.viewtest.test.LifeTestAct;
import test.viewtest.view.ReginActivity;
import test.viewtest.view.ViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button nor_lv,nor_gv,nor_ll,nor_ll_1,view_1,view_2,image_1,life_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRes();
    }

    private void initRes(){
        nor_lv = (Button) findViewById(R.id.btn_nor_lv);
        nor_gv = (Button) findViewById(R.id.btn_nor_gv);
        nor_ll = (Button) findViewById(R.id.btn_nor_ll);
        nor_ll_1 = (Button) findViewById(R.id.btn_nor_ll_1);
        view_1 = (Button) findViewById(R.id.btn_view_1);
        view_2 = (Button) findViewById(R.id.btn_view_2);
        image_1 = (Button) findViewById(R.id.btn_img_1);
        life_test = (Button) findViewById(R.id.btn_view_life_test);

        nor_lv.setOnClickListener(this);
        nor_gv.setOnClickListener(this);
        nor_ll.setOnClickListener(this);
        nor_ll_1.setOnClickListener(this);
        view_1.setOnClickListener(this);
        view_2.setOnClickListener(this);
        image_1.setOnClickListener(this);
        life_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_nor_lv:
                startActivity(NormalList.class);
                break;
            case R.id.btn_nor_gv:
               startActivity(NormalGrid.class);
                break;
            case R.id.btn_nor_ll:
                startActivity(NormalLayoutAnim.class);
                break;
            case R.id.btn_nor_ll_1:
                startActivity(LayoutAnimAct1.class);
                break;
            case R.id.btn_view_1:
                startActivity(ViewActivity.class);
                break;
            case R.id.btn_view_2:
                startActivity(ReginActivity.class);
                break;
            case R.id.btn_img_1:
                startActivity(Image1Activity.class);
                break;
            case R.id.btn_view_life_test:
                startActivity(LifeTestAct.class);
                break;
        }
    }

    private void startActivity(Class act){
        Intent intent = new Intent(this,act);
        startActivity(intent);
    }


}
