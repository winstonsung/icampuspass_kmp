package com.itocc.icampuspass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.itocc.icampuspass.MainContent

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent() {
            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.dark(Color.Black.toArgb()),
                navigationBarStyle = SystemBarStyle.dark(Color.Black.toArgb())
            )

            MainContent()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    MainContent()
}
