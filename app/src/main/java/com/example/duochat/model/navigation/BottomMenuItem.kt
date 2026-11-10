package com.example.duochat.model.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.duochat.R

data class BottomMenuItem(
    val route: String,
    val icon: ImageVector,
    val textId: Int
)

fun getBottomMenuItemList(): List<BottomMenuItem> = listOf(
    BottomMenuItem(
        route = "chats",
        icon = Icons.Default.MailOutline,
        textId = R.string.chats_bottom_menu
    ),
    BottomMenuItem(
        route = "add_user",
        icon = Icons.Default.Add,
        textId = R.string.add_user_bottom_menu
    ),
    BottomMenuItem(
        route = "profile",
        icon = Icons.Default.AccountCircle,
        textId = R.string.profile_bottom_menu
    )
)