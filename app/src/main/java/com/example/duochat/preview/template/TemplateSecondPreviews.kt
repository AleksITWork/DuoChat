package com.example.duochat.preview.template

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.duochat.model.screen.MessageOwner
import com.example.duochat.template.UnifiedMessage
import com.example.duochat.template.UnifiedMessageCounter
import com.example.duochat.template.UnifiedNavigationButton
import com.example.duochat.template.UnifiedOutlinedTextField
import com.example.duochat.template.UnifiedProfileCard
import com.example.duochat.template.UnifiedTextBox
import com.example.duochat.template.UnifiedUserFullNameText
import com.example.duochat.ui.theme.DuoChatTheme

@RequiresApi(Build.VERSION_CODES.O)
@PreviewLightDark
@Composable
fun UnifiedYourMessagePreview() {
    DuoChatTheme {
        UnifiedMessage(
            "Привет! Как дела?",
            1794238666316,
            MessageOwner.ME
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@PreviewLightDark
@Composable
fun UnifiedOtherMessagePreview() {
    DuoChatTheme {
        UnifiedMessage(
            "Привет! Как дела?",
            1794238666316,
            MessageOwner.OTHER
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedMessageCounterPreview() {
    DuoChatTheme {
        UnifiedMessageCounter(
            1
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedNavigationButtonPreview() {
    DuoChatTheme {
        UnifiedNavigationButton(
            {},
            "Зарегистрироваться"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedOutlinedTextFieldPreview() {
    DuoChatTheme {
        UnifiedOutlinedTextField(
            "Текст",
            { value: String -> },
            "Имя",
            "Введите имя",
            Icons.Default.AccountBox,
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedProfileCardPreview() {
    DuoChatTheme {
        UnifiedProfileCard(
            "Александр Ларин",
            null,
            1794238666316,
            "test@test.com"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedTextBoxPreview() {
    DuoChatTheme {
        UnifiedTextBox(
            "",
            { value: String -> },
            "Введите сообщение"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedUserFullNameTextPreview() {
    DuoChatTheme {
        UnifiedUserFullNameText(
            {},
            "Александр Ларин"
        )
    }
}