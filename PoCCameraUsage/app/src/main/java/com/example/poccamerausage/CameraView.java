package com.example.poccamerausage;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Surface;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import android.app.Activity;
import java.util.List;


public class CameraView extends SurfaceView implements SurfaceHolder.Callback {


    private static final String APP_CLASS = "CameraView";
    private Camera mCamera;
    private View mView;
    private WindowManager display;
    private Context mContext;

    public CameraView() {};


    public CameraView(Context context, Camera mCamera) {
        super(context);

        mContext = context;

        this.mCamera = mCamera;
        mCamera.setDisplayOrientation(90);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }

    public CameraView(CaptureImage context, android.graphics.Camera mCamera) {
        super(context);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.e("cameraPreview", "The failure of the camera settings");
        }
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Camera.Parameters params = mCamera.getParameters();
        List<Camera.Size> sizes = params.getSupportedPreviewSizes();
        Camera.Size optionalSize = getOptimalPreviewSize(sizes, width, height);
        params.setPreviewSize(optionalSize.width, optionalSize.height);
        mCamera.setParameters(params);

        boolean isPreviewRunning = true;

        if (isPreviewRunning) {
            mCamera.stopPreview();
        }

        Parameters parameters = mCamera.getParameters();
        Display display = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        if (display.getRotation() == Surface.ROTATION_0) {
            parameters.setPreviewSize(height, width);
            mCamera.setDisplayOrientation(90);
        }

        if (display.getRotation() == Surface.ROTATION_90) {
            parameters.setPreviewSize(width, height);
        }

        if (display.getRotation() == Surface.ROTATION_180) {
            parameters.setPreviewSize(height, width);
        }

        if (display.getRotation() == Surface.ROTATION_270) {
            parameters.setPreviewSize(width, height);
            mCamera.setDisplayOrientation(180);
        }

        mCamera.setParameters(parameters);
        previewCamera();
    }

    public void previewCamera() {
        try {
            mCamera.setPreviewDisplay(getHolder());
            mCamera.startPreview();
            boolean isPreviewRunning = true;
        } catch (Exception e) {
            Log.d(APP_CLASS, "Cannot start preview", e);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.release();
        mCamera = null;
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes, int w, int h) {

        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) h / w;

        if (sizes == null) return null;

        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        for (Camera.Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Camera.Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;


    }
}
