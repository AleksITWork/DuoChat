package com.example.duochat.template

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.duochat.ui.theme.avatarSizeMedium
import com.example.duochat.ui.theme.counterSize
import com.example.duochat.ui.theme.radiusMedium
import com.example.duochat.ui.theme.spacingExtraSmall
import com.example.duochat.ui.theme.spacingMedium
import com.example.duochat.ui.theme.spacingSmall

@Composable
fun UnifiedChatItem(
    uri: String?,
    fullName: String,
    lastMessageText: String,
    countNewMessages: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(
            radiusMedium
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    spacingMedium
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UnifiedAvatar(
                fullName,
                uri,
                avatarSizeMedium,
                "Аватар $fullName"
            )

            Spacer(
                modifier = Modifier
                    .width(
                        spacingMedium
                    )
            )

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = fullName,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            spacingExtraSmall
                        )
                )

                Text(
                    text = lastMessageText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(
                modifier = Modifier
                    .width(
                        spacingSmall
                    )
            )

            if (countNewMessages > 0) {
                UnifiedMessageCounter(
                    countNewMessages
                )
            }
        }
    }
}