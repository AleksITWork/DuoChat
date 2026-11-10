package com.example.duochat.template

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.duochat.ui.theme.radiusMedium
import com.example.duochat.ui.theme.spacingLarge

@Composable
fun UnifiedUserFullNameText(
    onClick: (() -> Unit)?,
    fullName: String,
) {
    val modifier = if (onClick == null) {
        Modifier
            .fillMaxWidth()
    } else {
        Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    }

    Card(
        modifier = modifier,
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
                .padding(spacingLarge),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = fullName,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}