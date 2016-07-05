package com.dl7.cameraandmatrix.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dl7.cameraandmatrix.OnSeekBarChangeAdapter;
import com.dl7.cameraandmatrix.R;
import com.dl7.cameraandmatrix.view.CustomView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomActivity extends AppCompatActivity {

    @BindView(R.id.sb_translate_x)
    SeekBar mSbTranslateX;
    @BindView(R.id.tv_translate_x)
    TextView mTvTranslateX;
    @BindView(R.id.sb_translate_y)
    SeekBar mSbTranslateY;
    @BindView(R.id.tv_translate_y)
    TextView mTvTranslateY;
    @BindView(R.id.sb_scale_x)
    SeekBar mSbScaleX;
    @BindView(R.id.tv_scale_x)
    TextView mTvScaleX;
    @BindView(R.id.sb_scale_y)
    SeekBar mSbScaleY;
    @BindView(R.id.tv_scale_y)
    TextView mTvScaleY;
    @BindView(R.id.sb_rotate)
    SeekBar mSbRotate;
    @BindView(R.id.tv_rotate)
    TextView mTvRotate;
    @BindView(R.id.custom_view)
    CustomView mCustomView;
    @BindView(R.id.sb_skew_x)
    SeekBar mSbSkewX;
    @BindView(R.id.tv_skew_x)
    TextView mTvSkewX;
    @BindView(R.id.sb_skew_y)
    SeekBar mSbSkewY;
    @BindView(R.id.tv_skew_y)
    TextView mTvSkewY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ButterKnife.bind(this);
        _initViews();
    }

    private void _initViews() {
        mSbScaleX.setProgress((int) (mCustomView.getScaleX() * 100));
        mSbScaleY.setProgress((int) (mCustomView.getScaleY() * 100));
        mSbRotate.setProgress(mCustomView.getRotate());

        mSbTranslateX.setProgress(300);
        mSbTranslateY.setProgress(300);
        mSbSkewX.setProgress(100);
        mSbSkewY.setProgress(100);

        mSbScaleX.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                float scale = ((float) progress) / 100;
                mCustomView.setScaleX(scale);
                mTvScaleX.setText("" + scale);
            }
        });
        mSbScaleY.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                float scale = ((float) progress) / 100;
                mCustomView.setScaleY(scale);
                mTvScaleY.setText("" + scale);
            }
        });
        mSbTranslateX.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                progress -= 300;
                mCustomView.setTranslateX(progress);
                mTvTranslateX.setText("" + progress);
            }
        });
        mSbTranslateY.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                progress -= 300;
                mCustomView.setTranslateY(progress);
                mTvTranslateY.setText("" + progress);
            }
        });
        mSbRotate.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                mCustomView.setRotate(progress);
                mTvRotate.setText("" + progress);
            }
        });
        mSbSkewX.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                progress -= 100;
                float skew = ((float) progress) / 100;
                mCustomView.setSkewX(skew);
                mTvSkewX.setText("" + skew);
            }
        });
        mSbSkewY.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {
            @Override
            public void onProgress(SeekBar seekBar, int progress, boolean fromUser) {
                progress -= 100;
                float skew = ((float) progress) / 100;
                mCustomView.setSkewY(skew);
                mTvSkewY.setText("" + skew);
            }
        });
    }
}
