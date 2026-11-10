package com.example.duochat.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.duochat.R
import com.example.duochat.ui.theme.avatarSizeLarge
import com.example.duochat.ui.theme.radiusMedium
import com.example.duochat.ui.theme.spacingExtraSmall
import com.example.duochat.ui.theme.spacingLarge
import com.example.duochat.ui.theme.spacingMedium

@Composable
fun UnifiedProfileCard(
    fullName: String,
    uri: String?,
    userId: Long,
    email: String?
) {
    val emailText = email ?: "-"

    Card(
        modifier = Modifier
            .fillMaxWidth(),
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
                    spacingLarge
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UnifiedAvatar(
                fullName,
                uri,
                avatarSizeLarge,
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
                    style = MaterialTheme.typography.titleLarge,
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
                    text = stringResource(
                        R.string.user_id_place,
                        userId
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            spacingExtraSmall
                        )
                )

                Text(
                    text = stringResource(
                        id = R.string.user_email_place,
                        emailText
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}