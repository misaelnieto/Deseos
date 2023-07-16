package com.xonoe.deseos

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.core.CameraSelector
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun RecordScreen(navController: NavHostController) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }

    Box {
        Column {
            AndroidView(
                factory = { context ->
                    PreviewView(context).apply {
                        setBackgroundResource(R.drawable.video_preview)
                        // setBackgroundColor(Color.White.toArgb())
                        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                        scaleType = PreviewView.ScaleType.FILL_START
                        implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                    }.also { previewView ->
                        // Select back camera as a default
                        cameraController.cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
                        previewView.controller = cameraController
                        cameraController.bindToLifecycle(lifecycleOwner)
                    }
                },
                onRelease = {
                    cameraController.unbind()
                },
                modifier = Modifier
                    .height(600.dp)
            )
            IconButton(
                onClick = { navController.navigate("thankyou") },
                modifier = Modifier
                    .fillMaxSize()
                    .height(50.dp)
                    .width(50.dp),
            ) {
                Icon(
                    Icons.TwoTone.Close,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color(0xFFFFD700)
                )
            }
        }
    }
}

@Preview
@Composable
private fun RecordScreenPreview() {
    val navController = NavHostController(LocalContext.current)
    RecordScreen(navController)
}