package com.vinitchuri.roadsafe.feature_roadsafe.presentation.home.component

import android.provider.MediaStore
import androidx.camera.core.VideoCapture
import androidx.camera.video.FallbackStrategy
import androidx.camera.video.MediaStoreOutputOptions
import androidx.camera.video.Quality
import androidx.camera.video.QualitySelector
import androidx.camera.video.Recorder
import androidx.camera.video.RecordingStats
import androidx.camera.video.VideoCapture.withOutput
import androidx.camera.video.VideoRecordEvent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.util.Consumer

/*In ViewModel*/
/*Step1*/
private fun setupQualitySelector(): QualitySelector {
    val qualitySelector = QualitySelector.fromOrderedList(
        listOf(Quality.UHD, Quality.FHD, Quality.SD),
        FallbackStrategy.lowerQualityOrHigherThan(Quality.SD)
    )
    return qualitySelector
}

/*private fun setupRecorder(): Recorder {
    val recorder = Recorder.Builder()
        .setExecutor(cameraExecutor)
        .setQualitySelector(setupQualitySelector())
        .build()

    return recorder
}*/

// A helper function to translate Quality to a string
private fun Quality.qualityToString() : String {
    return when (this) {
        Quality.UHD -> "UHD"
        Quality.FHD -> "FHD"
        Quality.HD -> "HD"
        Quality.SD -> "SD"
        else -> throw IllegalArgumentException()
    }
}

/*Step2*/
/*private fun setupVideoCapture(videoCapture: VideoCapture): VideoCapture {
    val videoCapture = VideoCapture.withOutput(setupRecorder())
    return videoCapture
}*/
/*Bind use case to camera in viewmodel*/

/*Step 3*/
private fun setupVideoRecordEventListener() {
    val videoRecordEventListener = Consumer<VideoRecordEvent> {
        when(it) {
            is VideoRecordEvent.Start -> {}
            is VideoRecordEvent.Finalize -> {}
            is VideoRecordEvent.Status -> {
                // The status event, which will be continuously updated during the recording.
                val stats: RecordingStats = it.recordingStats
                // RecordingStats includes recording file size and duration.
            }
            is VideoRecordEvent.Pause -> {}
            is VideoRecordEvent.Resume -> {}
        }
    }
}

/*Step4:Setup & Start Recording*/
/*@Composable
fun setupStartRecording() {
    val mediaStoreOutputOptions = MediaStoreOutputOptions.Builder(LocalContext.current.contentResolver,MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
        .setContentValues(contentValues)
        .build()

    // Configure Recorder and Start recording to the mediaStoreOutput.
    val activeRecording = videoCapture.output.prepareRecording(LocalContext.current,mediaStoreOutputOptions)
        .withEventListener(ContextCompat.getMainExecutor(LocalContext.current), videoRecordEventListener)
        .withAudioEnabled()
}*/

/*Step5 : Operate on ActiveRecording. */
/*@Composable
fun ActiveRecording() {
    activeRecording.pause()
    activeRecording.resume()
    activeRecording.stop()
}*/

