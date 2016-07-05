package com.dl7.cameraandmatrix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dl7.cameraandmatrix.activity.CameraActivity;
import com.dl7.cameraandmatrix.activity.CustomActivity;
import com.dl7.cameraandmatrix.activity.MatrixActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_camera)
    Button mBtnCamera;
    @BindView(R.id.btn_custom)
    Button mBtnCustom;
    @BindView(R.id.btn_matrix)
    Button mBtnMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn_custom, R.id.btn_camera, R.id.btn_matrix})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_custom:
                startActivity(new Intent(MainActivity.this, CustomActivity.class));
                break;
            case R.id.btn_camera:
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
                break;
            case R.id.btn_matrix:
                startActivity(new Intent(MainActivity.this, MatrixActivity.class));
                break;
        }
    }
}
