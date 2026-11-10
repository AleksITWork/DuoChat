package com.example.duochat.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.duochat.R
import com.example.duochat.model.navigation.getBottomMenuItemList
import com.example.duochat.model.screen.ChatItem
import com.example.duochat.model.screen.UserItem
import com.example.duochat.model.screen.getFullName
import com.example.duochat.template.UnifiedBottonMenu
import com.example.duochat.template.UnifiedChatItem
import com.example.duochat.template.UnifiedIconButton
import com.example.duochat.template.UnifiedLogo
import com.example.duochat.ui.theme.iconButtonSizeMedium
import com.example.duochat.ui.theme.radiusMedium
import com.example.duochat.ui.theme.spacingMedium
import com.example.duochat.ui.theme.spacingSmall

@Composable
fun ChatListScreen(
    users: List<UserItem>,
    chats: List<ChatItem>,
    onItemSelected: () -> Unit,
    onSearch: () -> Unit,
    onOpenChat: () -> Unit
) {
    val bottomMenuItems = getBottomMenuItemList()
    val searchButtonContentDescription = stringResource(
        id = R.string.search_button_content_description
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            UnifiedBottonMenu(
                bottomMenuItems = bottomMenuItems,
                selectedRoute = bottomMenuItems[0].route,
                onItemSelected = {
                    onItemSelected()
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        spacingMedium
                    ),
                shape = RoundedCornerShape(
                    radiusMedium
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            spacingSmall
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    UnifiedLogo()

                    UnifiedIconButton(
                        onClick = {
                            onSearch()
                        },
                        buttonSize = iconButtonSizeMedium,
                        imageVector = Icons.Default.Search,
                        contentDescription = searchButtonContentDescription
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(
                        spacingMedium
                    )
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(
                    chats
                ) { chat ->
                    val user = users.firstOrNull { user ->
                        user.id == chat.other
                    }

                    if (user != null) {
                        UnifiedChatItem(
                            uri = user.uri,
                            fullName = getFullName(
                                lastName = user.lastName,
                                firstName = user.firstName
                            ),
                            lastMessageText = chat.messages.last().text,
                            countNewMessages = chat.messages.count { message ->
                                !message.read
                            },
                            onClick = {
                                onOpenChat()
                            }
                        )
                    }
                }
            }
        }
    }
}