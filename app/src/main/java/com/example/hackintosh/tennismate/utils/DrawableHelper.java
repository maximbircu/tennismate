package com.example.hackintosh.tennismate.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

/**
 * Created by lschidu on 12/28/16.
 */

public class DrawableHelper {

    public static Bitmap getRoundedShape(Bitmap scaleBitmapImage, int dimension) {

        int targetWidth = dimension;
        int targetHeight = dimension;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }

    public static Bitmap resizeMapIcons(Bitmap imageBitmap ,int width, int height){
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

    public static RoundedBitmapDrawable createRoundedBitmapDrawableWithBorder(Bitmap bitmap, Resources resources){
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int borderWidthHalf = 10; // In pixels

        // Calculate the bitmap radius
        int bitmapRadius = Math.min(bitmapWidth,bitmapHeight)/2;

        int bitmapSquareWidth = Math.min(bitmapWidth,bitmapHeight);
        //Toast.makeText(mContext,""+bitmapMin,Toast.LENGTH_SHORT).show();

        int newBitmapSquareWidth = bitmapSquareWidth+borderWidthHalf;

        Bitmap roundedBitmap = Bitmap.createBitmap(newBitmapSquareWidth,newBitmapSquareWidth,Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(roundedBitmap);

        canvas.drawColor(Color.RED);

        // Calculation to draw bitmap at the circular bitmap center position
        int x = borderWidthHalf + bitmapSquareWidth - bitmapWidth;
        int y = borderWidthHalf + bitmapSquareWidth - bitmapHeight;


        canvas.drawBitmap(bitmap, x, y, null);

        // Initializing a new Paint instance to draw circular border
        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderWidthHalf*2);
        borderPaint.setColor(Color.WHITE);

        canvas.drawCircle(canvas.getWidth()/2, canvas.getWidth()/2, newBitmapSquareWidth/2, borderPaint);

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(resources,roundedBitmap);

        roundedBitmapDrawable.setCornerRadius(bitmapRadius);
        roundedBitmapDrawable.setAntiAlias(true);

        return roundedBitmapDrawable;
    }
}
