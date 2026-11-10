package com.example.duochat.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.duochat.R
import com.example.duochat.model.screen.ChatItem
import com.example.duochat.model.screen.MessageOwner
import com.example.duochat.model.screen.UserItem
import com.example.duochat.model.screen.getFullName
import com.example.duochat.template.UnifiedAvatar
import com.example.duochat.template.UnifiedBackButton
import com.example.duochat.template.UnifiedIconButton
import com.example.duochat.template.UnifiedMessage
import com.example.duochat.template.UnifiedTextBox
import com.example.duochat.template.UnifiedUserFullNameText
import com.example.duochat.ui.theme.avatarSizeMedium
import com.example.duochat.ui.theme.iconButtonSizeMedium
import com.example.duochat.ui.theme.spacingMedium
import com.example.duochat.ui.theme.spacingSmall

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatScreen(
    chat: ChatItem,
    user: UserItem,
    userMessage: String,
    onUserMessageChanged: (String) -> Unit,
    onSendMessage: () -> Unit,
    onBack: () -> Unit,
    onOpenProfile: () -> Unit
) {
    val sendButtonContentDescription = stringResource(
        id = R.string.send_button_content_description
    )

    val messageTextPlaceholder = stringResource(
        id = R.string.message_enter_placeholder
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                )
                .padding(
                    spacingMedium
                ),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    reverseLayout = true,
                    contentPadding = PaddingValues(
                        horizontal = spacingMedium,
                        vertical = spacingSmall
                    )
                ) {
                    items(chat.messages) { message ->
                        UnifiedMessage(
                            messageText = message.text,
                            time = message.time,
                            messageOwner = if (message.user == chat.me) {
                                MessageOwner.ME
                            } else {
                                MessageOwner.OTHER
                            }
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        UnifiedTextBox(
                            value = userMessage,
                            onValueChanged = onUserMessageChanged,
                            placeholder = messageTextPlaceholder,
                            maxLines = 50
                        )
                    }

                    UnifiedIconButton(
                        onClick = {
                            onSendMessage()
                        },
                        buttonSize = iconButtonSizeMedium,
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = sendButtonContentDescription,
                        enabled = true
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                verticalAlignment = Alignment.CenterVertically
            ) {
                UnifiedBackButton(
                    onBack = onBack
                )

                val fullName = getFullName(
                    lastName = user.lastName,
                    firstName = user.firstName
                )

                UnifiedAvatar(
                    fullName = fullName,
                    uri = user.uri,
                    size = avatarSizeMedium
                )

                Spacer(
                    modifier = Modifier
                        .width(
                            spacingSmall
                        )
                        .weight(1f)
                )

                UnifiedUserFullNameText(
                    onClick = {
                        onOpenProfile()
                    },
                    fullName = fullName
                )
            }
        }
    }
}