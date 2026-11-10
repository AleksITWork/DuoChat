package com.example.duochat.model.screen

data class MessageItem(
    val id: Long,
    val text: String,
    val time: Long,
    val user: Long,
    val read: Boolean
)

fun getMessageItemList(): List<MessageItem> = listOf(
    MessageItem(
        id = 1,
        text = "Как дела?",
        time = 1794238666316,
        user = 1,
        read = true
    ),
    MessageItem(
        id = 2,
        text = "Узнаю насчет практики в Postgres Professional",
        time = 1794238672316,
        user = 2,
        read = false
    )
)
