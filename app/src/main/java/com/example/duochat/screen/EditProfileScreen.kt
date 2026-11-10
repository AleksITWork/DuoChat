package com.example.duochat.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.duochat.R
import com.example.duochat.model.screen.UserItem
import com.example.duochat.model.screen.getFullName
import com.example.duochat.template.UnifiedAuthButton
import com.example.duochat.template.UnifiedAvatar
import com.example.duochat.template.UnifiedBackButton
import com.example.duochat.template.UnifiedOutlinedTextField
import com.example.duochat.template.UnifiedUserFullNameText
import com.example.duochat.ui.theme.avatarSizeLarge
import com.example.duochat.ui.theme.spacingLarge
import com.example.duochat.ui.theme.spacingSmall

@Composable
fun EditProfileScreen(
    lastName: String,
    onLastNameChanged: (String) -> Unit,
    firstName: String,
    onFirstNameChanged: (String) -> Unit,
    email: String,
    onEmailChanged: (String) -> Unit,
    loading: Boolean,
    user: UserItem,
    onBack: () -> Unit,
    onEditProfile: () -> Unit
) {
    val lastNameLabelText = stringResource(
        id = R.string.last_name_placeholder
    )
    val lastNamePlaceholderText = stringResource(
        id = R.string.last_name_enter_placeholder
    )

    val firstNameLabelText = stringResource(
        id = R.string.first_name_placeholder
    )
    val firstNamePlaceholderText = stringResource(
        id = R.string.first_name_enter_placeholder
    )

    val emailLabelText = stringResource(
        id = R.string.email_placeholder
    )
    val emailPlaceholderText = stringResource(
        id = R.string.email_enter_placeholder
    )

    val applyEditAccountButtonText = stringResource(
        id = R.string.apply_edit_profile_button_text
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                UnifiedBackButton(
                    onBack = onBack
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    paddingValues = innerPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            UnifiedAvatar(
                fullName = getFullName(
                    lastName = user.lastName,
                    firstName = user.firstName
                ),
                uri = user.uri,
                size = avatarSizeLarge
            )

            Spacer(
                modifier = Modifier
                    .height(
                        spacingSmall
                    )
            )

            UnifiedUserFullNameText(
                null,
                "ID = ${user.id}"
            )

            Spacer(
                modifier = Modifier
                    .height(
                        spacingLarge
                    )
            )

            UnifiedOutlinedTextField(
                value = lastName,
                onValueChanged = onLastNameChanged,
                labelText = lastNameLabelText,
                placeholderText = lastNamePlaceholderText,
                leadingIcon = Icons.Default.AccountBox,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.PersonName
                )
            )

            Spacer(
                modifier = Modifier
                    .height(
                        spacingSmall
                    )
            )

            UnifiedOutlinedTextField(
                value = firstName,
                onValueChanged = onFirstNameChanged,
                labelText = firstNameLabelText,
                placeholderText = firstNamePlaceholderText,
                leadingIcon = Icons.Default.AccountBox,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.PersonName
                )
            )

            Spacer(
                modifier = Modifier
                    .height(
                        spacingSmall
                    )
            )

            UnifiedOutlinedTextField(
                value = email,
                onValueChanged = onEmailChanged,
                labelText = emailLabelText,
                placeholderText = emailPlaceholderText,
                leadingIcon = Icons.Default.Email,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            Spacer(
                modifier = Modifier
                    .height(
                        spacingLarge
                    )
            )

            UnifiedAuthButton(
                onClick = {
                    onEditProfile()
                },
                loading = loading,
                buttonText = applyEditAccountButtonText
            )
        }
    }
}