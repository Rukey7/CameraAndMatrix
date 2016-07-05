package com.dl7.cameraandmatrix;

import android.widget.SeekBar;

/**
 * Created by long on 2016/7/4.
 */
public abstract class OnSeekBarChangeAdapter implements SeekBar.OnSeekBarChangeListener {

    public abstract void onProgress(SeekBar seekBar, int progress, boolean fromUser);

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        onProgress(seekBar, progress, fromUser);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
