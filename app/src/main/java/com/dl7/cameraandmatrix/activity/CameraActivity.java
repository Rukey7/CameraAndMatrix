package com.dl7.cameraandmatrix.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dl7.cameraandmatrix.OnSeekBarChangeAdapter;
import com.dl7.cameraandmatrix.R;
import com.dl7.cameraandmatrix.view.CameraView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CameraActivity extends AppCompatActivity {

    @BindView(R.id.sb_translate_x)
    SeekBar mSbTranslateX;
    @BindView(R.id.tv_translate_x)
    TextView mTvTranslateX;
    @BindView(R.id.sb_translate_y)
    SeekBar mSbTranslateY;
    @BindView(R.id.tv_translate_y)
    TextView mTvTranslateY;
    @BindView(R.id.sb_translate_z)
    SeekBar mSbTranslateZ;
    @BindView(R.id.tv_translate_z)
    TextView mTvTranslateZ;
    @BindView(R.id.sb_rotate_x)
    SeekBar mSbRotateX;
    @BindView(R.id.tv_rotate_x)
    TextView mTvRotateX;
    @BindView(R.id.sb_rotate_y)
    SeekBar mSbRotateY;
    @BindView(R.id.tv_rotate_y)
    TextView mTvRotateY;
    @BindView(R.id.sb_rotate_z)
    SeekBar mSbRotateZ;
    @BindView(R.id.tv_rotate_z)
    TextView mTvRotateZ;
    @BindView(R.id.camera_view)
    CameraView mCameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);

        _initViews();
    }

    private void _initViews() {
        mSbRotateX.setProgress(mCameraView.getRotateX());
        mSbRotateY.setProgress(mCameraView.getRotateY());
        mSbRotateZ.setProgress(mCameraView.getRotateZ());
        mSbTranslateX.setProgress(mCameraView.getTranslateX());
        mSbTranslateY.setProgress(mCameraView.getTranslateY());
        mSbTranslateZ.setProgress(mCameraView.getTranslateZ());

        mSbTranslateX.setProgress(300);
        mSbTranslateY.setProgress(300);
        mSbTranslateZ.setProgress(100);

        mSbRotateX.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                mCameraView.setRotateX(progress);
                mTvRotateX.setText(""+progress);
            }
        });
        mSbRotateY.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                mCameraView.setRotateY(progress);
                mTvRotateY.setText(""+progress);
            }
        });
        mSbRotateZ.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                mCameraView.setRotateZ(progress);
                mTvRotateZ.setText(""+progress);
            }
        });
        mSbTranslateX.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                progress -= 300;
                mCameraView.setTranslateX(progress);
                mTvTranslateX.setText(""+progress);
            }
        });
        mSbTranslateY.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                progress -= 300;
                mCameraView.setTranslateY(progress);
                mTvTranslateY.setText(""+progress);
            }
        });
        mSbTranslateZ.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                progress -= 100;
                mCameraView.setTranslateZ(progress);
                mTvTranslateZ.setText(""+progress);
            }
        });
    }
}
