package test.viewtest.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


import test.viewtest.R;

/**
 * Created by admin on 2017/6/22.
 */

public class Image1Activity extends AppCompatActivity {

    private String TAG = "Image1Activity";
    private ImageView image;
    private BitmapRegionDecoder decoder;
    private int screen[];
    private int outer[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_1);
        initRes();
        initDecoder();

    }

    private void initRes() {
        image = (ImageView) findViewById(R.id.image);
        screen = getScreenPix(this);
        outer = getImageOuter(getInputStream("b1.png"));
        image.setAdjustViewBounds(true);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }


    private void initDecoder() {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            decoder = BitmapRegionDecoder.newInstance(getInputStream("b1.png"), false);
            Bitmap bitmap = decoder.decodeRegion(getAdjustRect(outer,screen), options);
            image.setImageBitmap(bitmap);
        } catch (Exception e) {

        }

    }

    private int[] getScreenPix(Context ctx) {
        DisplayMetrics metrics = ctx.getResources().getDisplayMetrics();
        Log.e(TAG, "screen ===>>>>" + metrics.widthPixels + "     " + metrics.heightPixels);
        return new int[]{metrics.widthPixels, metrics.heightPixels};
    }

    private int[] getImageOuter(InputStream is) {
        BitmapFactory.Options op = new BitmapFactory.Options();
        op.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, op);
        closeInput(is);
        Log.e(TAG, "outer ===>>>>" + op.outWidth + "     " + op.outHeight);
        return new int[]{op.outWidth, op.outHeight};
    }

    private InputStream getInputStream(String name) {
        try {
            return getAssets().open(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeInput(InputStream is) {
        try {
            if (is != null)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Rect getAdjustRect(int outer[],int screen[]){
        if(outer[0] >= screen[0] && outer[1] >= screen[0]){
            return new Rect(0,0,screen[0],screen[1]);
        } else if(outer[0] < screen[0] && outer[1] < screen[0]){
            return new Rect(0,0,outer[0],outer[1]);
        }

        float scale ;
        if(outer[0] < screen[0]){
            scale = (float)screen[0]/(float)outer[0];
            outer[1] = (int) ((float)screen[1]/scale);
            return new Rect(0,0,outer[0],outer[1]);
        }else {
            scale = (float)screen[1]/(float)outer[1];
            outer[0] = (int) ((float)screen[0]/scale);
            return new Rect(0,0,outer[0],outer[1]);
        }
    }

}
