package com.example.duochat.template

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.duochat.R

@Composable
fun UnifiedLogo() {
    Text(
        text = stringResource(
            id = R.string.app_name
        ),
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary
    )
}