package com.example.duochat.model.screen

data class ChatItem(
    val id: Long,
    val me: Long,
    val other: Long,
    val messages: List<MessageItem>,
)

fun getChatItemList(): List<ChatItem> = listOf(
    ChatItem(
        id = 1,
        me = 1,
        other = 2,
        messages = getMessageItemList()
    )
)
