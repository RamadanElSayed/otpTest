package com.instant.otptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DirectionalGradients()
        }
    }
}

@Composable
fun BasicLinearGradientExample() {
    val gradient = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Blue),
        start = Offset(0f, 0f),
        end = Offset(300f, 300f)
    )

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(gradient)
    )
}

@Composable
fun DirectionalGradients() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Horizontal Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color.Magenta, Color.Cyan),
                        startX = 0f,
                        endX = 1000f
                    )
                )
        )

        // Vertical Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Green, Color.Yellow),
                        startY = 0f,
                        endY = 500f
                    )
                )
        )

        // Diagonal Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    Brush.linearGradient(
                        colors = listOf(Color.Red, Color.Blue),
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                )
        )
    }
}

@Composable
fun AdvancedLinearGradient() {
    val gradient = Brush.linearGradient(
        0.0f to Color.Red,
        0.3f to Color.Green,
        0.6f to Color.Blue,
        1.0f to Color.Magenta,
        start = Offset(0f, 0f),
        end = Offset(300f, 300f)
    )

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(gradient)
    )
}


@Composable
fun BasicRadialGradient() {
    val gradient = Brush.radialGradient(
        colors = listOf(Color.White, Color.Black),
        center = Offset(150f, 150f),
        radius = 200f
    )

    Box(
        modifier = Modifier
            .size(300.dp)
            .background(gradient)
    )
}

@Composable
fun MultiColorRadialGradient() {
    val gradient = Brush.radialGradient(
        colors = listOf(
            Color.Red,
            Color.Yellow,
            Color.Green,
            Color.Transparent
        ),
        center = Offset(150f, 150f),
        radius = 250f,
        tileMode = TileMode.Clamp
    )

    Box(
        modifier = Modifier
            .size(400.dp)
            .background(gradient)
    )
}

@Composable
fun BasicSweepGradient() {
    val gradient = Brush.sweepGradient(
        colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Red),
        center = Offset(150f, 150f)
    )

    Box(
        modifier = Modifier
            .size(300.dp)
            .background(gradient)
    )
}


@Composable
fun CircularProgressWithGradient(progress: Float) {
    val gradientColors = listOf(
        Color(0xFF6200EE),
        Color(0xFF03DAC5),
        Color(0xFF6200EE)
    )

    val brush = Brush.sweepGradient(
        colors = gradientColors,
        center = Offset(150f, 150f)
    )

    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(16.dp)
    ) {
        val strokeWidth = 20f
        val diameter = size.minDimension - strokeWidth

        drawArc(
            brush = brush,
            startAngle = 0f,
            sweepAngle = progress * 360f,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )
    }
}

@Composable
fun AnimatedGradient() {
    val colors = listOf(
        Color.Red,
        Color.Magenta,
        Color.Blue,
        Color.Cyan,
        Color.Green,
        Color.Yellow,
        Color.Red
    )

    val transition = rememberInfiniteTransition()
    val offset by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            //repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(
            x = offset * 1000f,
            y = 0f
        ),
        end = Offset(
            x = offset * 1000f + 1000f,
            y = 1000f
        ),
        tileMode = TileMode.Mirror
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
    )
}

@Composable
fun GradientText() {
    val gradientColors = listOf(Color(0xFF6200EE), Color(0xFF03DAC5))
    val colors = listOf(
        Color.Red,
        Color.Magenta,
        Color.Blue,
        Color.Cyan,
        Color.Green,
        Color.Yellow,
        Color.Red
    )
    Text(
        text = "Gradient Text Example",
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            brush = Brush.linearGradient(
                colors = colors
            )
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun CustomShapeGradient() {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF6200EE),
            Color(0xFF03DAC5)
        )
    )

    Canvas(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
    ) {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }

        drawPath(
            path = path,
            brush = gradientBrush
        )
    }
}

@Composable
fun OptimizedGradientExample() {
    // Cache gradient definition outside the composition
    val gradient = remember {
        Brush.linearGradient(
            colors = listOf(Color.Red, Color.Blue)
        )
    }

    // Use cached gradient
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(gradient)
    )
}

@Composable
fun AccessibleGradientText() {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF000000), // Dark color for better contrast
            Color(0xFF1A237E)  // Dark blue
        )
    )

    Box(
        modifier = Modifier
            .background(Color.White) // Light background
            .padding(16.dp)
    ) {
        Text(
            text = "Accessible Text",
            style = TextStyle(
                fontSize = 24.sp,
                brush = gradientBrush
            )
        )
    }
}

@Composable
fun AnimatedGradientBackground6() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp.value
    val screenHeight = configuration.screenHeightDp.dp.value

    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val transition = rememberInfiniteTransition(label = "gradient")

    val translateAnim by transition.animateFloat(
        initialValue = -screenWidth,
        targetValue = screenWidth + screenHeight,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "translate"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = colors,
                    start = Offset(0f, translateAnim),
                    end = Offset(screenWidth, translateAnim + screenHeight)
                )
            )
    )
}


@Composable
fun GradientBackgroundScreen() {
    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val gradientWithStops = Brush.linearGradient(
        0.0f to Color.Red,
        0.3f to Color.Green,
        1.0f to Color.Blue,
        start = Offset(0f, 0f),
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY) ,
       // tileMode = TileMode.Repeated
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = colors,
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                )
            )
    )
}

@Composable
fun AnimatedGradientBackground5() {
    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val transition = rememberInfiniteTransition(label = "gradient-animation")

    val offsetX by transition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "x-offset"
    )

    val offsetY by transition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "y-offset"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = colors,
                    start = Offset(offsetX, offsetY),
                    end = Offset(offsetX + 1500f, offsetY + 1500f)
                )
            )
    )
}

@Composable
fun AnimatedGradientBackground4() {
    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val transition = rememberInfiniteTransition(label = "animated-gradient")

    val offsetAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "offset"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = colors,
                    start = Offset(offsetAnim, offsetAnim),
                    end = Offset(offsetAnim + 1000f, offsetAnim + 1000f)
                )
            )
    )
}


@Composable
fun LinearRadialWaveAnimatedGradientBackground() {
    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val transition = rememberInfiniteTransition(label = "linear-radial-wave-gradient")

    val waveOffset by transition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = colors,
                    start = Offset(waveOffset, waveOffset),
                    end = Offset(waveOffset + 1500f, waveOffset + 1500f)
                )
            )
    )
}


@Composable
fun AnimatedGradientScreen1() {
    // Colors for the gradient
    val gradientColors = listOf(
        Color(0xFF4CAF50), // Green
        Color(0xFF2196F3), // Blue
        Color(0xFFFFC107)  // Yellow
    )

    // Create infinite animation
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val offsetY = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    // Create an animated brush
    val animatedBrush = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(offsetX.value, offsetY.value),
        end = Offset(offsetX.value - 500f, offsetY.value - 500f)
    )

    // Fullscreen Box with animated gradient background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(animatedBrush)
    ) {}
}
@Composable
fun AnimatedGradientBackground() {
    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val transition = rememberInfiniteTransition(label = "gradient")

    val translateAnim by transition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "translate"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = colors,
                    start = Offset(translateAnim, translateAnim),
                    end = Offset(translateAnim + 1000f, translateAnim + 1000f)
                )
            )
    )
}

@Composable
fun DiagonalWaveAnimatedGradientBackground() {
    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val transition = rememberInfiniteTransition(label = "diagonal-wave-gradient")

    val waveOffset by transition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = colors,
                    start = Offset(waveOffset, waveOffset),
                    end = Offset(waveOffset + 1000f, waveOffset + 1000f)
                )
            )
    )
}

@Composable
fun RadialWaveAnimatedGradientBackground() {
    val colors = listOf(
        Color(0xFF9C27B0),  // Purple
        Color(0xFF2196F3),  // Blue
        Color(0xFF4CAF50),  // Green
        Color(0xFFFFEB3B),  // Yellow
        Color(0xFFFF5722),  // Orange
        Color(0xFF9C27B0)   // Purple again for smooth transition
    )

    val transition = rememberInfiniteTransition(label = "radial-wave-gradient")

    val waveOffset by transition.animateFloat(
        initialValue = 0f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = colors,
                    center = Offset(waveOffset, waveOffset),
                    radius = waveOffset + 500f
                )
            )
    )
}



@Composable
fun AnimatedGradientScreen2() {
    // Colors for the gradient
    val gradientColors = listOf(
        Color(0xFF4CAF50), // Green
        Color(0xFF2196F3), // Blue
        Color(0xFFFFC107)  // Yellow
    )

    // Create infinite animation
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val offsetY = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    // Create an animated brush
    val animatedBrush = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(offsetX.value, offsetY.value),
        end = Offset(offsetX.value - 500f, offsetY.value - 500f)
    )

    // Fullscreen Box with animated gradient background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(animatedBrush)
    ) {}
}
@Composable
fun AnimatedGradientScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedGradientBackground()

        // Add your screen content here
        // Example:
        // Text(
        //     text = "Hello World",
        //     modifier = Modifier.align(Alignment.Center),
        //     color = Color.White
        // )
    }
}




@Composable
fun AnimatedFlowingGradientBorder() {
    // Infinite transition for animating the gradient position from start to end
    val infiniteTransition = rememberInfiniteTransition()

    // Animate the gradient position to move it from start to end smoothly
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    // Define the gradient colors for head and tail
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color.Cyan.copy(alpha = 0.8f),    // Head (starting color)
            Color.Red.copy(alpha = 0.6f),     // Middle color
            Color.Yellow.copy(alpha = 0.6f)   // Tail (ending color)
        ),
        startX = offset * 1500f,  // Animate start of the gradient (move it from left to right)
        endX = (offset + 1) * 1500f  // Animate end of the gradient (move it from left to right)
    )

    // Box with animated gradient border
    Box(
        modifier = Modifier
            .size(300.dp, 150.dp) // Size of the rectangle
            .border(
                width = 6.dp,
                brush = gradient,
                shape = RoundedCornerShape(16.dp) // Rounded corners
            )
            .padding(16.dp) // Padding for the content inside the border
    ) {
        // Example content inside the animated border
        Text(
            text = "Flowing Gradient Border",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.labelLarge
        )
    }
}
