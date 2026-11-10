package com.example.duochat.template

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.duochat.model.screen.MessageOwner
import com.example.duochat.ui.theme.radiusLarge
import com.example.duochat.ui.theme.radiusSmall
import com.example.duochat.ui.theme.spacingExtraSmall
import com.example.duochat.ui.theme.spacingMedium
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
private fun formatTime(
    time: Long
): String {
    val dateTime = LocalDateTime.ofInstant(
        Instant.ofEpochMilli(time),
        ZoneId.systemDefault()
    )
    return dateTime.format(
        DateTimeFormatter.ofPattern(
            "dd.MM.yyyy HH:mm"
        )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UnifiedMessage(
    messageText: String,
    time: Long,
    messageOwner: MessageOwner
) {
    val alignment = if (messageOwner == MessageOwner.ME) {
        Alignment.CenterEnd
    } else {
        Alignment.CenterStart
    }

    val background = if (messageOwner == MessageOwner.ME) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }

    val foreground = if (messageOwner == MessageOwner.ME) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    val formattedTime = remember(time) {
        formatTime(time)
    }

    val arrangement = if (messageOwner == MessageOwner.ME) {
        Arrangement.End
    } else {
        Arrangement.Start
    }

    val bottomStartRadius = if (messageOwner == MessageOwner.ME) {
        radiusLarge
    } else {
        radiusSmall
    }

    val bottomEndRadius = if (messageOwner == MessageOwner.ME) {
        radiusSmall
    } else {
        radiusLarge
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = arrangement
    ) {
        Card(
            modifier = Modifier
                .widthIn(
                    max = 280.dp
                )
                .fillMaxWidth(
                    0.6f
                ),
            shape = RoundedCornerShape(
                topStart = radiusLarge,
                topEnd = radiusLarge,
                bottomStart = bottomStartRadius,
                bottomEnd = bottomEndRadius
            ),
            colors = CardDefaults.cardColors(
                containerColor = background
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        spacingMedium
                    )
            ) {
                Text(
                    text = messageText,
                    style = MaterialTheme.typography.bodyLarge,
                    color = foreground
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            spacingExtraSmall
                        )
                )

                Text(
                    modifier = Modifier
                        .align(
                            Alignment.End
                        ),
                    text = formattedTime,
                    style = MaterialTheme.typography.bodySmall,
                    color = foreground.copy(
                        alpha = 0.7f
                    ),
                )
            }
        }
    }
}