package com.example.duochat.preview.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.duochat.model.screen.getChatItemList
import com.example.duochat.model.screen.getUserItemList
import com.example.duochat.screen.AddUserScreen
import com.example.duochat.screen.AuthScreen
import com.example.duochat.screen.ChatListScreen
import com.example.duochat.screen.ChatScreen
import com.example.duochat.screen.CheckOtherProfile
import com.example.duochat.screen.EditProfileScreen
import com.example.duochat.screen.ProfileScreen
import com.example.duochat.screen.RegisterScreen
import com.example.duochat.ui.theme.DuoChatTheme

@PreviewLightDark
@Composable
fun AuthScreenPreview() {
    DuoChatTheme {
        AuthScreen(
            "test@test.com",
            { value: String -> },
            "",
            { value: String -> },
            {},
            {},
            false
        )
    }
}

@PreviewLightDark
@Composable
fun RegisterScreenPreview() {
    DuoChatTheme {
        RegisterScreen(
            "Ларин",
            { value: String -> },
            "Александр",
            { value: String -> },
            "test@test.com",
            { value: String -> },
            "password",
            { value: String -> },
            {},
            {},
            false
        )
    }
}

@PreviewLightDark
@Composable
fun ChatListScreenPreview() {
    DuoChatTheme {
        ChatListScreen(
            getUserItemList(),
            getChatItemList(),
            {},
            {},
            {}
        )
    }
}

@PreviewLightDark
@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun ChatScreenPreview() {
    DuoChatTheme {
        val chatItem = getChatItemList()[1]
        val userItem = getUserItemList().first { user ->
            user.id == chatItem.other
        }

        ChatScreen(
            chatItem,
            userItem,
            "Готово же...",
            { value: String -> },
            {},
            {},
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun AddUserScreenPreview() {
    val userId = 2L
    val userItem = getUserItemList().filter { user ->
        user.id == userId
    }

    DuoChatTheme {
        AddUserScreen(
            userId.toString(),
            { value: String -> },
            userItem,
            {},
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun ProfileScreenPreview() {
    val user = getUserItemList().first { user ->
        user.id == 1L
    }

    DuoChatTheme {
        ProfileScreen(
            user,
            {},
            {},
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun EditProfileScreenPreview() {
    val user = getUserItemList().first { user ->
        user.id == 1L
    }

    DuoChatTheme {
        EditProfileScreen(
            "Ларин",
            { value: String -> },
            "Александр",
            { value: String -> },
            "test@test.com",
            { value: String -> },
            false,
            user,
            {},
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun CheckOtherProfilePreview() {
    val user = getUserItemList().first { user ->
        user.id == 2L
    }

    DuoChatTheme {
        CheckOtherProfile(
            user,
            {}
        )
    }
}