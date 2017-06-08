package test.viewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 2017/6/8.
 */

public class ReginView  extends View{

    public final Region.Op[] ops = new Region.Op[]{Region.Op.DIFFERENCE, Region.Op.INTERSECT,Region.Op.REPLACE
    , Region.Op.REVERSE_DIFFERENCE,Region.Op.UNION,Region.Op.XOR};
    private Region.Op mOp = Region.Op.UNION;


    public ReginView(Context context) {
        this(context,null);
    }

    public ReginView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ReginView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        Region region;
    }


    public void setReginType(Region.Op op){
        this.mOp = op;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRegin(canvas);

    }



    private void drawRegin(Canvas canvas){
        canvas.save();
        canvas.translate(250,250);
        Rect rect1 = new Rect(100,100,400,200);
        Rect rect2 = new Rect(200,0,300,300);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        canvas.drawRect(rect1, paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect2, paint);

        Region region = new Region(rect1);
        Region region2= new Region(rect2);


        region.op(region2, mOp);
        Paint paint_fill = new Paint();
        paint_fill.setColor(Color.GREEN);
        paint_fill.setStyle(Paint.Style.FILL);
        drawRegion(canvas, region, paint_fill);
        canvas.restore();
    }

    private void drawRegion(Canvas canvas,Region rgn,Paint paint)
    {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }
}
