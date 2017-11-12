package com.example.hackintosh.tennismate.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

/**
 * Created by nicu on 11/12/17.
 */

public class CircleTransform implements Transformation {
<<<<<<< HEAD
=======

    private boolean hasBorder;

    public CircleTransform(boolean hasBorder) {
        this.hasBorder = hasBorder;
    }

>>>>>>> 9bdc677132c3a17a004c7b7bf96ebe22de6382fb
    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        squaredBitmap.recycle();
        float r = size/2f;
        canvas.drawCircle(r, r, r, paint);

<<<<<<< HEAD
        squaredBitmap.recycle();
=======
        if(hasBorder) {
            // Initializing a new Paint instance to draw circular border
            Paint borderPaint = new Paint();
            borderPaint.setStyle(Paint.Style.STROKE);
            borderPaint.setStrokeWidth(borderWidthHalf*2);
            borderPaint.setColor(Color.WHITE);
            borderPaint.setAntiAlias(true);
            canvas.drawCircle(canvas.getWidth()/2, canvas.getWidth()/2, newBitmapSquareWidth/2 - 15, borderPaint);
        }

>>>>>>> 9bdc677132c3a17a004c7b7bf96ebe22de6382fb
        return bitmap;
    }

    @Override
    public String key() {
        return "circle";
    }
}