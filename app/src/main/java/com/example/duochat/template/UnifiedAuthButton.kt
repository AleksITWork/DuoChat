package com.example.duochat.template

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.duochat.ui.theme.buttonHeight
import com.example.duochat.ui.theme.circularIndicatorSize
import com.example.duochat.ui.theme.radiusMedium
import com.example.duochat.ui.theme.strokeWidth

@Composable
fun UnifiedAuthButton(
    onClick: () -> Unit,
    loading: Boolean,
    buttonText: String,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(buttonHeight),
        onClick = onClick,
        enabled = !loading,
        shape = RoundedCornerShape(
            radiusMedium
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(circularIndicatorSize),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = strokeWidth
            )
        } else {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}