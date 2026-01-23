package com.example.mycityandroidstudiocourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityandroidstudiocourses.ui.MyCityApp
import com.example.mycityandroidstudiocourses.ui.theme.MyCityAndroidStudioCoursesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityAndroidStudioCoursesTheme {
                val windowSize = calculateWindowSizeClass(this)
                MyCityApp(
                    windowSize = windowSize.widthSizeClass
                )
            }
        }
    }
}


@Preview(showBackground = true, )
@Composable
fun MyCityAppCompactPreview() {
    MyCityAndroidStudioCoursesTheme {
        MyCityApp(
            windowSize = WindowWidthSizeClass.Compact,
        )
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun MyCityAppMediumPreview() {
    MyCityAndroidStudioCoursesTheme {
        MyCityApp(
            windowSize = WindowWidthSizeClass.Medium,
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun MyCityAppExpandedPreview() {
    MyCityAndroidStudioCoursesTheme {
        MyCityApp(
            windowSize = WindowWidthSizeClass.Expanded,
        )
    }
}