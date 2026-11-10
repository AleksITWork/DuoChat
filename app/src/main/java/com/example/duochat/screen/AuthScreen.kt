package com.example.duochat.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.duochat.R
import com.example.duochat.template.UnifiedAuthButton
import com.example.duochat.template.UnifiedLogo
import com.example.duochat.template.UnifiedNavigationButton
import com.example.duochat.template.UnifiedOutlinedTextField
import com.example.duochat.ui.theme.spacingExtraLarge
import com.example.duochat.ui.theme.spacingMedium
import com.example.duochat.ui.theme.spacingSmall

@Composable
fun AuthScreen(
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    onLogin: () -> Unit,
    onRegister: () -> Unit,
    loading: Boolean
) {
    val emailLabelText = stringResource(
        id = R.string.email_placeholder
    )
    val emailPlaceholder = stringResource(
        id = R.string.email_enter_placeholder
    )

    val passwordLabelText = stringResource(
        id = R.string.password_placeholder
    )
    val passwordPlaceholder = stringResource(
        id = R.string.password_enter_placeholder
    )

    val loginButtonText = stringResource(
        id = R.string.login_main_text_button
    )
    val registerButtonText = stringResource(
        id = R.string.register_second_text_button
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        spacingMedium
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                UnifiedLogo()

                Spacer(
                    modifier = Modifier
                        .height(
                            spacingExtraLarge
                        )
                )

                UnifiedOutlinedTextField(
                    value = email,
                    onValueChanged = onEmailChanged,
                    labelText = emailLabelText,
                    placeholderText = emailPlaceholder,
                    leadingIcon = Icons.Default.MailOutline,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            spacingSmall
                        )
                )

                UnifiedOutlinedTextField(
                    value = password,
                    onValueChanged = onPasswordChanged,
                    labelText = passwordLabelText,
                    placeholderText = passwordPlaceholder,
                    leadingIcon = Icons.Default.Lock,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            spacingExtraLarge
                        )
                )

                UnifiedAuthButton(
                    onClick = onLogin,
                    loading = loading,
                    buttonText = loginButtonText
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            spacingSmall
                        )
                )

                UnifiedNavigationButton(
                    onClick = onRegister,
                    buttonText = registerButtonText
                )
            }
        }
    }
}