package com.vinitchuri.roadsafe.feature_roadsafe.presentation.home.component

import android.util.Log
import android.util.Size
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.video.VideoCapture
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.Executor

@Composable
fun CameraPreview(
    /*videoCapture: VideoCapture,
    analyzer: ImageAnalysis.Analyzer*/
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    AndroidView(
        factory = { ctx ->
            val previewView = PreviewView(ctx)
            val executor = ContextCompat.getMainExecutor(ctx)

            cameraProviderFuture.addListener(
                kotlinx.coroutines.Runnable {
                    // Used to bind the lifecycle of cameras to the lifecycle owner
                    val cameraProvider = cameraProviderFuture.get()

                    bindPreview(
                        lifecycleOwner,
                        previewView,
                        cameraProvider/*,
                        videoCapture,
                        analyzer,
                        executor,*/
                    )
                },
                executor
            )
            previewView
        },
        modifier = Modifier.fillMaxSize()
    )
}

private fun bindPreview(
    lifecycleOwner: LifecycleOwner,
    previewView: PreviewView,
    cameraProvider: ProcessCameraProvider,
    /*
        videoCapture: VideoCapture,
        analyzer: ImageAnalysis.Analyzer,
        executor: Executor*/
) {
    // Preview
    val preview = Preview
        .Builder()
        .build()
        .also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }

    val lensFacing = when {
        cameraProvider.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA) ->
            CameraSelector.LENS_FACING_BACK
        cameraProvider.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA) ->
            CameraSelector.LENS_FACING_FRONT
        else ->
            throw IllegalStateException("Back and front camera are unavailable.")
    }

    // Select lens facing camera as a default
    val cameraSelector = CameraSelector
        .Builder()
        .requireLensFacing(lensFacing)
        .build()

    try {
        // Unbind use cases before rebinding
        cameraProvider.unbindAll()

        // Bind use cases to camera
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            /*videoCapture,
            setupImageAnalysis(previewView, executor, analyzer),*/
            preview
        )
    } catch (exc: Exception) {
        Log.e(exc.toString(), "Use case binding failed")
    }
}

private fun setupImageAnalysis(
    previewView: PreviewView,
    executor: Executor,
    analyzer: ImageAnalysis.Analyzer
): ImageAnalysis {
    return ImageAnalysis.Builder()
        // RGBA output is needed.
        .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
        .setTargetResolution(Size(previewView.width, previewView.height))
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build()
        .also {
            it.setAnalyzer(executor, analyzer)
        }
}

