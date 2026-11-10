package com.example.duochat.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.duochat.R
import com.example.duochat.model.navigation.getBottomMenuItemList
import com.example.duochat.model.screen.UserItem
import com.example.duochat.model.screen.getFullName
import com.example.duochat.template.UnifiedBottonMenu
import com.example.duochat.template.UnifiedIconTextButton
import com.example.duochat.template.UnifiedProfileCard

@Composable
fun ProfileScreen(
    user: UserItem,
    onEditProfile: () -> Unit,
    onExit: () -> Unit,
    onItemSelected: () -> Unit
) {
    val bottomMenuItems = getBottomMenuItemList()

    val editProfileButtonText = stringResource(
        id = R.string.edit_profile_button_text,
    )
    val exitAccountButtonText = stringResource(
        id = R.string.exit_account_button_text
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
                .padding(
                    paddingValues = innerPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
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

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                UnifiedIconTextButton(
                    onClick = {
                        onEditProfile()
                    },
                    contentColor = MaterialTheme.colorScheme.primary,
                    imageVector = Icons.Default.Create,
                    buttonText = editProfileButtonText
                )

                UnifiedIconTextButton(
                    onClick = {
                        onExit()
                    },
                    contentColor = MaterialTheme.colorScheme.error,
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    buttonText = exitAccountButtonText
                )
            }
        }
    }
}