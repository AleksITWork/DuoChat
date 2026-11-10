package com.example.duochat.template

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import com.example.duochat.ui.theme.radiusSmall

@Composable
fun UnifiedOutlinedTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    labelText: String,
    placeholderText: String,
    leadingIcon: ImageVector,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChanged,
        label = {
            Text(
                text = labelText
            )
        },
        placeholder = {
            Text(
                text = placeholderText
            )
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,

            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,

            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,

            focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,

            focusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,

            errorBorderColor = MaterialTheme.colorScheme.error,
            errorTextColor = MaterialTheme.colorScheme.onSurface,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorLeadingIconColor = MaterialTheme.colorScheme.error,

            cursorColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(
            radiusSmall
        ),
        textStyle = MaterialTheme.typography.bodyLarge,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
    )
}