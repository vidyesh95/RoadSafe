package com.vinitchuri.roadsafe.feature_roadsafe.presentation.home.component

import androidx.camera.core.VideoCapture
import androidx.camera.video.FallbackStrategy
import androidx.camera.video.Quality
import androidx.camera.video.QualitySelector
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture.withOutput

/*In ViewModel*/
/*private fun setupVideoCapture(videoCapture: VideoCapture): VideoCapture {
    val videoCapture = VideoCapture.withOutput(setupRecorder())
    return videoCapture
}

private fun setupQualitySelector(): QualitySelector {
    val qualitySelector = QualitySelector.fromOrderedList(
        listOf(Quality.UHD, Quality.FHD, Quality.SD),
        FallbackStrategy.lowerQualityOrHigherThan(Quality.SD)
    )
    return qualitySelector
}

private fun setupRecorder(): Recorder {
    val recorder = Recorder.Builder()
        .setExecutor(cameraExecutor)
        .setQualitySelector(setupQualitySelector())
        .build()

    return recorder
}*/

// A helper function to translate Quality to a string
fun Quality.qualityToString() : String {
    return when (this) {
        Quality.UHD -> "UHD"
        Quality.FHD -> "FHD"
        Quality.HD -> "HD"
        Quality.SD -> "SD"
        else -> throw IllegalArgumentException()
    }
}