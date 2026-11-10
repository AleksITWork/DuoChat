package com.example.duochat.template

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

@Composable
fun UnifiedIconButton(
    onClick: () -> Unit,
    buttonSize: Dp,
    imageVector: ImageVector,
    contentDescription: String,
    enabled: Boolean = true
) {
    IconButton(
        modifier = Modifier
            .size(
                buttonSize
            ),
        onClick = onClick,
        enabled = enabled
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.38f
                )
            }
        )
    }
}