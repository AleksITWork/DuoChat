package com.example.duochat.model.navigation

import com.example.duochat.model.navigation.Destination.AddNewUser
import com.example.duochat.model.navigation.Destination.ChatList
import com.example.duochat.model.navigation.Destination.Profile

sealed class Destination(
    val route: String
) {
    object Auth : Destination("auth")
    object Register : Destination("register")
    object ChatList : Destination("chats")
    object AddNewUser : Destination("add_user")
    object Profile : Destination("profile")
    object EditProfile : Destination("edit_profile")

    object Chat : Destination("chat/{chatId}") {
        fun createRoute(chatId: Long) = "chat/$chatId"
    }

    object CheckOtherProfile : Destination("check_profile/{userId}") {
        fun createRoute(userId: Long) = "check_profile/$userId"
    }
}

fun getBottomNavRoutes(): List<String> = listOf(
    ChatList.route,
    AddNewUser.route,
    Profile.route
)