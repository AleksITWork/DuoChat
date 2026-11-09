package com.example.duochat.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import coil3.compose.AsyncImage
import com.example.duochat.R

private fun String.toInitials(): String {
    val parts = this
        .trim()
        .split(
            Regex("\\s+")
        )
        .filter {
            it.isNotBlank()
        }

    return when {
        parts.isEmpty() -> "?"
        parts.size == 1 -> {
            val part = parts[0].take(1).uppercase()
            "$part."
        }
        else -> {
            val first = parts[0].take(1)
            val second = parts[1].take(1)
            "$first. $second.".uppercase()
        }
    }
}

@Composable
private fun FullNameAvatar(
    fullName: String,
    modifier: Modifier
) {
    val initials = remember(fullName) {
        fullName.toInitials()
    }

    Box(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.primaryContainer
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun UnifiedAvatar(
    fullName: String,
    uri: String?,
    size: Dp,
    contentDescription: String
) {
    val modifier = Modifier
        .size(size)
        .clip(CircleShape)

    if (uri == null) {
        FullNameAvatar(
            fullName,
            modifier
        )
    } else {
        AsyncImage(
            modifier = modifier,
            contentScale = ContentScale.Crop,
            model = uri,
            contentDescription = contentDescription,
            error = painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            fallback = painterResource(
                id = R.drawable.ic_launcher_foreground
            )
        )
    }
}