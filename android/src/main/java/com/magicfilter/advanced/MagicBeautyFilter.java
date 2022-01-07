package com.magicfilter.advanced;

import android.opengl.GLES20;

import com.magicfilter.utils.MagicFilterType;
import com.kaibo.camera_rtmp.R;

import com.magicfilter.base.gpuimage.GPUImageFilter;

/**
 * Created by Administrator on 2016/5/22.
 */
public class MagicBeautyFilter extends GPUImageFilter{
    private int mSingleStepOffsetLocation;

    public MagicBeautyFilter(){
        super(MagicFilterType.BEAUTY, R.raw.beauty);
    }

    protected void onInit() {
        super.onInit();
        mSingleStepOffsetLocation = GLES20.glGetUniformLocation(getProgram(), "singleStepOffset");
    }

    @Override
    public void onInputSizeChanged(final int width, final int height) {
        super.onInputSizeChanged(width, height);
        setFloatVec2(mSingleStepOffsetLocation, new float[] {2.0f / width, 2.0f / height});
    }
}
