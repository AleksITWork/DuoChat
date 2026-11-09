package com.example.duochat.preview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.duochat.model.template.MessageOwner
import com.example.duochat.template.UnifiedMessage
import com.example.duochat.template.UnifiedMessageCounter
import com.example.duochat.template.UnifiedTextBox
import com.example.duochat.template.UnifiedNavigationButton
import com.example.duochat.template.UnifiedOutlinedTextField
import com.example.duochat.template.UnifiedProfileCard
import com.example.duochat.template.UnifiedUserFullNameText
import com.example.duochat.ui.theme.DuoChatTheme
import com.example.duochat.ui.theme.buttonHeight
import com.example.duochat.ui.theme.radiusMedium

@RequiresApi(Build.VERSION_CODES.O)
@PreviewLightDark
@Composable
fun UnifiedYourMessageTemplate() {
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
fun UnifiedOtherMessageTemplate() {
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
fun UnifiedMessageCounterTemplate() {
    DuoChatTheme {
        UnifiedMessageCounter(
            1
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedNavigationButtonTemplate() {
    DuoChatTheme {
        UnifiedNavigationButton(
            {},
            "Зарегистрироваться"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedOutlinedTextFieldTemplate() {
    DuoChatTheme {
        UnifiedOutlinedTextField(
            "Текст",
            {value: String -> },
            "Имя",
            "Введите имя",
            Icons.Default.AccountBox,
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedProfileCardTemplate() {
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
fun UnifiedTextBoxTemplate() {
    DuoChatTheme {
        UnifiedTextBox(
            Modifier
                .heightIn(
                    min = buttonHeight
                ),
            "",
            {value: String ->},
            "Введите сообщение"
        )
    }
}

@PreviewLightDark
@Composable
fun UnifiedUserFullNameTextTemplate() {
    DuoChatTheme {
        UnifiedUserFullNameText(
            Modifier,
            radiusMedium,
            {},
            "Александр Ларин"
        )
    }
}