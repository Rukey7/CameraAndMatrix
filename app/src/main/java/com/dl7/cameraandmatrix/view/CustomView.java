package com.dl7.cameraandmatrix.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Rukey7 on 2016/7/4.
 */
public class CustomView extends ImageView {

    private float scaleX = 1;
    private float scaleY = 1;
    private int rotate;
    private int translateX;
    private int translateY;
    private float skewX = 0;
    private float skewY = 0;


    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init();
    }

    private void _init() {
        reset();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(translateX, translateY);
        // 设置以中点为基准点，默认图形左上角为原点坐标
        canvas.rotate(rotate, getWidth() / 2, getHeight() / 2);
        canvas.scale(scaleX, scaleY, getWidth() / 2, getHeight() / 2);
        // canvas的错切方法不提供设置某个点为基准点
        canvas.skew(skewX, skewY);
        super.onDraw(canvas);
    }


    public void reset() {
        scaleX = 1;
        scaleY = 1;
        rotate = 0;
        translateX = 0;
        translateY = 0;
        skewX = 0;
        skewY = 0;
    }

    @Override
    public float getScaleX() {
        return scaleX;
    }

    @Override
    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
        invalidate();
    }

    @Override
    public float getScaleY() {
        return scaleY;
    }

    @Override
    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
        invalidate();
    }

    public int getRotate() {
        return rotate;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
        invalidate();
    }

    public int getTranslateX() {
        return translateX;
    }

    public void setTranslateX(int translateX) {
        this.translateX = translateX;
        invalidate();
    }

    public int getTranslateY() {
        return translateY;
    }

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
        invalidate();
    }

    public float getSkewX() {
        return skewX;
    }

    public void setSkewX(float skewX) {
        this.skewX = skewX;
        invalidate();
    }

    public float getSkewY() {
        return skewY;
    }

    public void setSkewY(float skewY) {
        this.skewY = skewY;
        invalidate();
    }
}
