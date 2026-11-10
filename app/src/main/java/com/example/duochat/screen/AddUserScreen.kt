package com.example.duochat.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.duochat.R
import com.example.duochat.model.screen.UserItem
import com.example.duochat.model.screen.getFullName
import com.example.duochat.template.UnifiedBackButton
import com.example.duochat.template.UnifiedNewChat
import com.example.duochat.template.UnifiedTextBox
import com.example.duochat.ui.theme.spacingMedium

@Composable
fun AddUserScreen(
    text: String,
    onTextChanged: (String) -> Unit,
    users: List<UserItem>,
    onBack: () -> Unit,
    onOpenChat: () -> Unit
) {
    val userTextPlaceholder = stringResource(
        id = R.string.user_enter_placeholder
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                spacingMedium
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UnifiedBackButton(
                onBack = onBack
            )

            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                UnifiedTextBox(
                    value = text,
                    onValueChanged = onTextChanged,
                    placeholder = userTextPlaceholder,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            items(users) { user ->
                UnifiedNewChat(
                    fullName = getFullName(
                        lastName = user.lastName,
                        firstName = user.firstName
                    ),
                    uri = user.uri,
                    userId = user.id,
                    onClick = {
                        onOpenChat()
                    }
                )
            }
        }
    }
}