package com.example.practice

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Animation(){
    //Let's animate the size of our box by increasing the dps with animation thanks to the line 24
    var sizeState by remember { mutableStateOf(200.dp) }
    val size by animateDpAsState(
        targetValue = sizeState,
        //This parameter to animate more specifically, for instance, to add delay (theres one more 'spring' to make it bouncy)
        tween(
            durationMillis = 3000,
            delayMillis = 300,
            easing = LinearOutSlowInEasing
        ), label = ""
    )

    //Infinite animation in this case of color of the box
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Gray,
        targetValue = Color.Black,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 2000
            ),
            //This parameter to make the animation smooth gray - black - gray ...
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )


    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .size(size)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    sizeState += 50.dp
                }
            ) {
                Text(text = "Increase size")
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun AnimationPreview(){
    Animation()
}
