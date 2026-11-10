package com.example.duochat.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.duochat.ui.theme.counterSize

@Composable
fun UnifiedMessageCounter(
    count: Int
) {
    Box(
        modifier = Modifier
            .size(counterSize)
            .clip(CircleShape)
            .background(
                MaterialTheme.colorScheme.primaryContainer
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (count > 99) "99+" else count.toString(),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}