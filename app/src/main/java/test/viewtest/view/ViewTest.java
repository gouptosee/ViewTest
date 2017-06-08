package test.viewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by admin on 2017/6/2.
 */

public class ViewTest extends View {

    Paint paint;
    Path cwPath;
    Typeface typeface;
    Region regin;
    public ViewTest(Context context) {
        this(context,null);
    }

    public ViewTest(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        paint = new Paint();
        paint.setColor(Color.RED);
//        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);


        typeface = Typeface.create("宋体",Typeface.NORMAL);
        paint.setTypeface(typeface);


        cwPath = new Path();

        cwPath.addCircle(300,300,180, Path.Direction.CCW);
//        cwPath.moveTo(120,300);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawRegin(canvas);
        drawCircleText(canvas);


    }

    private void drawRegin(Canvas canvas){
        regin = new Region();
        Path path = new Path();
        path.addCircle(300,300,120, Path.Direction.CCW);
//        path.addRoundRect(new RectF(180,180,300,300),20,20, Path.Direction.CCW);
        regin.setPath(path,new Region(0,0,500,500));
        Log.d("1234",regin.getBounds().left +"  " +regin.getBounds().top +"   " +regin.getBounds().right +"  " +regin.getBounds().bottom);

//        canvas.drawPath(path,paint);
        paint.setColor(Color.BLUE);
        RegionIterator it = new RegionIterator(regin);
        Rect rect = new Rect();
        while (it.next(rect)){
            canvas.drawRect(rect,paint);
        }
    }


    private void drawCrossRegin(Canvas canvas){
        Paint paint_o = new Paint();
        Paint paint_c = new Paint();
        paint_c.setColor(Color.BLUE);
        paint_o.setColor(Color.RED);
        paint_c.setAntiAlias(true);
        paint_o.setAntiAlias(true);

        Rect rect_o1 = new Rect(200,300,500,400);
        Rect rect_o2 = new Rect(300,200,400,500);
        canvas.drawRect(rect_o1,paint_o);
        canvas.drawRect(rect_o2,paint_o);

        Region region  = new Region(rect_o1);
        Region region1 = new Region(rect_o2);

        region.op(region1, Region.Op.INTERSECT);

        Region outside = new Region(0,0,600,600);


    }


    private void drawCircleText(Canvas canvas){
        canvas.save();
        Log.d("1234",getWidth() +"    " + getHeight());
        canvas.rotate(135,300,300);
        String text = "This is the text on path";
        paint.setTextSize(35);
        paint.setTextSkewX((float) -0.25);
        canvas.drawPath(cwPath,paint);
        paint.setColor(Color.BLUE);
        canvas.drawTextOnPath(text,cwPath,0,10,paint);

        canvas.restore();

        Path path1 = new Path();
        path1.moveTo(100,500);
        path1.quadTo(200,900,500,800);
        canvas.drawPath(path1,paint);
    }
}
