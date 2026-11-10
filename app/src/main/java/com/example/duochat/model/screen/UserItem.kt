package com.example.duochat.model.screen

data class UserItem(
    val id: Long,
    val lastName: String,
    val firstName: String,
    val email: String?,
    val uri: String?
)

fun getUserItemList(): List<UserItem> = listOf(
    UserItem(
        id = 1,
        lastName = "Ларин",
        firstName = "Александр",
        email = "test@test.com",
        uri = null
    ),
    UserItem(
        id = 2,
        lastName = "Прокудин",
        firstName = "Александр",
        email = "test2@test.com",
        uri = null
    )
)

fun getFullName(
    lastName: String,
    firstName: String
): String = "$lastName $firstName"
