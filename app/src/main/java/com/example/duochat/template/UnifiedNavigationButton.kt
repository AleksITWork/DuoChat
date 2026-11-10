package com.example.duochat.template

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.duochat.ui.theme.buttonHeight

@Composable
fun UnifiedNavigationButton(
    onClick: () -> Unit,
    buttonText: String
) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(buttonHeight),
        onClick = onClick
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}