package com.example.bodyhubfitnessapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun DiagonalBackground(content: @Composable BoxScope.() -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Bottom layer - Orange
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFF8600))
        )

        // Top layer - Blue rotated diagonally
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationZ = 45f
                    translationX = -400f
                }
                .background(Color(0xFF27187E))
        )

        // Foreground content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            content = content
        )
    }
}