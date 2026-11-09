package com.example.duochat.template

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.duochat.ui.theme.buttonHeight
import com.example.duochat.ui.theme.iconSizeMedium
import com.example.duochat.ui.theme.radiusSmall
import com.example.duochat.ui.theme.spacingSmall

@Composable
fun UnifiedIconTextButton(
    onClick: () -> Unit,
    contentColor: Color,
    imageVector: ImageVector,
    buttonText: String,
) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(buttonHeight),
        onClick = onClick,
        shape = RoundedCornerShape(
            radiusSmall
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor
        )
    ) {
        Icon(
            modifier = Modifier
                .size(
                    iconSizeMedium
                ),
            imageVector = imageVector,
            contentDescription = null
        )

        Spacer(
            modifier = Modifier
                .width(
                    spacingSmall
                )
        )

        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}