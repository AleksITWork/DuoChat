package com.example.duochat.template

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.duochat.R
import com.example.duochat.ui.theme.iconButtonSizeMedium

@Composable
fun UnifiedBackButton(
    onBack: () -> Unit
) {
    val backButtonContentDescription = stringResource(
        id = R.string.back_button_content_description
    )

    UnifiedIconButton(
        onClick = {
            onBack()
        },
        buttonSize = iconButtonSizeMedium,
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = backButtonContentDescription
    )
}