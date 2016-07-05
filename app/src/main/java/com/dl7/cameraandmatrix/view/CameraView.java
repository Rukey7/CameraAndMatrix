package com.dl7.cameraandmatrix.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by long on 2016/7/4.
 *
 */
public class CameraView extends ImageView {

    private Camera mCamera;
    private Matrix mMatrix;

    private int rotateX;
    private int rotateY;
    private int rotateZ;
    private int translateX;
    private int translateY;
    private int translateZ;


    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init();
    }

    private void _init() {
        mCamera = new Camera();
        mMatrix = new Matrix();
        reset();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        mCamera.save();
        mCamera.translate(translateX, translateY, translateZ);
        mCamera.rotate(rotateX, rotateY, rotateZ);
        mCamera.getMatrix(mMatrix);
        // 先将旋转的基准点平移到中点，旋转完后再还原
        mMatrix.preTranslate(-getWidth() / 2, -getHeight() / 2);
        mMatrix.postTranslate(getWidth() / 2, getHeight() / 2);
        mCamera.restore();
        // concat()方法合并当前canvas中的Matrix和所设置的Matrix
        canvas.concat(mMatrix);
        super.onDraw(canvas);
    }


    public void reset() {
        rotateX = 0;
        rotateY = 0;
        rotateZ = 0;
        translateX = 0;
        translateY = 0;
        translateZ = 0;
    }


    public void setRotateX(int rotateX) {
        this.rotateX = rotateX;
        invalidate();
    }

    public void setRotateY(int rotateY) {
        this.rotateY = rotateY;
        invalidate();
    }

    public void setRotateZ(int rotateZ) {
        this.rotateZ = rotateZ;
        invalidate();
    }

    public void setTranslateX(int translateX) {
        this.translateX = translateX;
        invalidate();
    }

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
        invalidate();
    }

    public void setTranslateZ(int translateZ) {
        this.translateZ = translateZ;
        invalidate();
    }

    public int getRotateX() {
        return rotateX;
    }

    public int getRotateY() {
        return rotateY;
    }

    public int getRotateZ() {
        return rotateZ;
    }

    public int getTranslateX() {
        return translateX;
    }

    public int getTranslateY() {
        return translateY;
    }

    public int getTranslateZ() {
        return translateZ;
    }
}
