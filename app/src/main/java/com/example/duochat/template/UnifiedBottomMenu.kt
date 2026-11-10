package com.example.duochat.template

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.duochat.model.navigation.BottomMenuItem

@Composable
fun UnifiedBottonMenu(
    bottomMenuItems: List<BottomMenuItem>,
    selectedRoute: String,
    onItemSelected: (String) -> Unit
) {
    NavigationBar {
        bottomMenuItems.forEach { item ->
            val itemText = stringResource(
                id = item.textId
            )

            NavigationBarItem(
                selected = item.route == selectedRoute,
                onClick = {
                    onItemSelected(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = itemText
                    )
                },
                label = {
                    Text(
                        text = itemText,
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    }
}