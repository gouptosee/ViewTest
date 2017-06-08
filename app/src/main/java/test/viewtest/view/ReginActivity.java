package test.viewtest.view;

import android.graphics.Region;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import test.viewtest.R;

/**
 * Created by admin on 2017/6/8.
 */

public class ReginActivity extends AppCompatActivity {
    private final Region.Op[] ops = new Region.Op[]{Region.Op.DIFFERENCE, Region.Op.INTERSECT,Region.Op.REPLACE
            , Region.Op.REVERSE_DIFFERENCE,Region.Op.UNION,Region.Op.XOR};
    private GridView gv;
    private ReginView region;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regin_ops);
        initView();
    }

    private void initView(){
        region = (ReginView) findViewById(R.id.regin);
        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new ArrayAdapter<Region.Op>(this,android.R.layout.simple_list_item_1,ops));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                region.setReginType(ops[position]);
            }
        });
    }

}
