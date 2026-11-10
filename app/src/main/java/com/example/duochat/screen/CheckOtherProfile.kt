package com.example.duochat.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.duochat.model.screen.UserItem
import com.example.duochat.model.screen.getFullName
import com.example.duochat.template.UnifiedBackButton
import com.example.duochat.template.UnifiedProfileCard
import com.example.duochat.ui.theme.spacingMedium

@Composable
fun CheckOtherProfile(
    user: UserItem,
    onBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        spacingMedium
                    ),
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
            UnifiedProfileCard(
                fullName = getFullName(
                    lastName = user.lastName,
                    firstName = user.firstName
                ),
                uri = user.uri,
                userId = user.id,
                email = user.email
            )
        }
    }
}