package com.example.duochat.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.duochat.model.navigation.Destination
import com.example.duochat.model.navigation.getBottomMenuItemList
import com.example.duochat.model.navigation.getBottomNavRoutes
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
import com.example.duochat.template.UnifiedBottonMenu

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DuoChatNavHost(
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomMenuItems = getBottomMenuItemList()
    val showBottomMenu = currentRoute in bottomMenuItems.map {
        it.route
    }

    Scaffold(
        bottomBar = {
            if (showBottomMenu) {
                val bottomMenuItems = getBottomMenuItemList()

                val selectedRoute = when (currentRoute) {
                    Destination.AddNewUser.route -> Destination.AddNewUser.route
                    Destination.Profile.route -> Destination.Profile.route
                    else -> Destination.ChatList.route
                }

                UnifiedBottonMenu(
                    bottomMenuItems = bottomMenuItems,
                    selectedRoute = selectedRoute,
                    onItemSelected = { route ->
                        navController.navigate(route) {
                            popUpTo(
                                navController
                                    .graph
                                    .findStartDestination()
                                    .id
                            ) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destination.Auth.route,
            modifier = Modifier
                .padding(
                    paddingValues = innerPadding
                )
        ) {
            composable(
                route = Destination.Auth.route
            ) {
                AuthScreen(
                    email = "",
                    onEmailChanged = {},
                    password = "",
                    onPasswordChanged = {},
                    loading = false,
                    onLogin = {
                        navController.navigate(
                            Destination.ChatList.route
                        ) {
                            popUpTo(
                                Destination.Auth.route
                            ) {
                                inclusive = true
                            }
                        }
                    },
                    onRegister = {
                        navController.navigate(
                            Destination.Register.route
                        )
                    }
                )
            }

            composable(
                Destination.Register.route
            ) {
                RegisterScreen(
                    lastName = "",
                    firstName = "",
                    email = "",
                    password = "",
                    onLastNameChanged = {},
                    onFirstNameChanged = {},
                    onEmailChanged = {},
                    onPasswordChanged = {},
                    loading = false,
                    onLogin = {
                        navController.popBackStack()
                    },
                    onRegister = {
                        navController.navigate(
                            Destination.ChatList.route
                        ) {
                            popUpTo(
                                Destination.Auth.route
                            ) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(Destination.ChatList.route) {
                ChatListScreen(
                    users = getUserItemList(),
                    chats = getChatItemList(),
                    onSearch = {
                        navController.navigate(
                            Destination.AddNewUser.route
                        )
                    },
                    onOpenChat = {
                        navController.navigate(
                            Destination.Chat.createRoute(1L)
                        )
                    }
                )
            }

            composable(Destination.AddNewUser.route) {
                AddUserScreen(
                    text = "",
                    onTextChanged = {},
                    users = getUserItemList().filter {
                        user -> user.id == 2L
                    },
                    onBack = {
                        navController.popBackStack()
                    },
                    onOpenChat = {
                        navController.navigate(
                            Destination.Chat.createRoute(2L)
                        )
                    }
                )
            }

            composable(
                route = Destination.Chat.route,
                arguments = listOf(
                    navArgument("chatId") {
                        type = NavType.LongType
                    }
                )
            ) { backStackEntry ->
                val chatId = backStackEntry
                    .arguments
                    ?.getLong("chatId") ?: 1L

                val chat = getChatItemList().find { it.id == chatId } ?: getChatItemList().first()
                val user = getUserItemList().find { it.id == chat.other } ?: getUserItemList().first()

                ChatScreen(
                    chat = chat,
                    user = user,
                    userMessage = "",
                    onUserMessageChanged = {},
                    onSendMessage = {},
                    onBack = {
                        navController.popBackStack()
                    },
                    onOpenProfile = {
                        navController.navigate(
                            Destination.CheckOtherProfile.createRoute(user.id)
                        )
                    }
                )
            }

            composable(
                route = Destination.CheckOtherProfile.route,
                arguments = listOf(
                    navArgument("userId") {
                        type = NavType.LongType
                    }
                )
            ) { backStackEntry ->
                val userId = backStackEntry
                    .arguments
                    ?.getLong("userId") ?: 1L
                val user = getUserItemList()
                    .find {
                        it.id == userId
                    } ?: getUserItemList()
                        .first()

                CheckOtherProfile(
                    user = user,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            composable(Destination.Profile.route) {
                val currentUser = getUserItemList().first()

                ProfileScreen(
                    user = currentUser,
                    onEditProfile = {
                        navController.navigate(Destination.EditProfile.route)
                    },
                    onExit = {
                        navController.navigate(Destination.Auth.route) {
                            popUpTo(0) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(Destination.EditProfile.route) {
                val currentUser = getUserItemList().first()

                EditProfileScreen(
                    lastName = currentUser.lastName,
                    firstName = currentUser.firstName,
                    email = currentUser.email ?: "",
                    onLastNameChanged = {},
                    onFirstNameChanged = {},
                    onEmailChanged = {},
                    loading = false,
                    user = currentUser,
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditProfile = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}