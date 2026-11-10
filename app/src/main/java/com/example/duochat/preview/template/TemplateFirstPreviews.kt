package com.example.duochat.preview.template

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.duochat.model.navigation.getBottomMenuItemList
import com.example.duochat.template.UnifiedAuthButton
import com.example.duochat.template.UnifiedAvatar
import com.example.duochat.template.UnifiedBottonMenu
import com.example.duochat.template.UnifiedChatItem
import com.example.duochat.template.UnifiedIconButton
import com.example.duochat.template.UnifiedIconTextButton
import com.example.duochat.template.UnifiedLogo
import com.example.duochat.template.UnifiedNewChat
import com.example.duochat.ui.theme.DuoChatTheme
import com.example.duochat.ui.theme.avatarSizeSmall
import com.example.duochat.ui.theme.iconButtonSizeSmall

@PreviewLightDark
@Composable
fun UnifiedNewChatPreview() {
    DuoChatTheme {
        UnifiedNewChat(
            "Александр Ларин",
            null,
            4252352452,
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedAuthButtonPreview() {
    DuoChatTheme {
        UnifiedAuthButton(
            {},
            false,
            "Войти"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedAvatarPreview() {
    DuoChatTheme {
        UnifiedAvatar(
            "Ларин Александр",
            null,
            avatarSizeSmall
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedEmptyChatItemPreview() {
    DuoChatTheme {
        UnifiedChatItem(
            null,
            "Александр Ларин",
            "Привет! Как дела?",
            0,
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedBottomMenuPreview() {
    val menuItems = getBottomMenuItemList()

    DuoChatTheme {
        UnifiedBottonMenu(
            menuItems,
            menuItems[0].route,
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedNotEmptyChatItemPreview() {
    DuoChatTheme {
        UnifiedChatItem(
            null,
            "Александр Ларин",
            "Привет! Как дела?",
            2,
            {}
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedRegisterButtonPreview() {
    DuoChatTheme {
        UnifiedAuthButton(
            {},
            true,
            "Регистрация"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedIconButtonPreview() {
    DuoChatTheme {
        UnifiedIconButton(
            {},
            iconButtonSizeSmall,
            Icons.Default.Search,
            "",
            true
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedDisabledIconButtonPreview() {
    DuoChatTheme {
        UnifiedIconButton(
            {},
            iconButtonSizeSmall,
            Icons.AutoMirrored.Filled.Send,
            "",
            false
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedIconTextButtonPreview() {
    DuoChatTheme {
        UnifiedIconTextButton(
            {},
            MaterialTheme.colorScheme.error,
            Icons.AutoMirrored.Filled.ExitToApp,
            "Выйти"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedLogoPreview() {
    DuoChatTheme {
        UnifiedLogo()
    }
}