package com.example.duochat.template

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.duochat.ui.theme.radiusLarge

@Composable
fun UnifiedTextBox(
    value: String,
    onValueChanged: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLines: Int = 1
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions,
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(
            radiusLarge
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,

            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,

            focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,

            cursorColor = MaterialTheme.colorScheme.primary
        ),
        maxLines = maxLines
    )
}