package com.example.finaldesarrolloint

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class BottomBarItem(
    val label: String,
    val route: String,
    val icon: ImageVector
)

@Composable
fun BottomBar(
    items: List<BottomBarItem>,
    navController: NavHostController,
    currentRoute: String
) {
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        backgroundColor = MaterialTheme.colorScheme.primary
    ) {
        val currentRouteSection = currentRoute.substringBefore("/")
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(text = item.label) },
                selected = currentRouteSection == item.route,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}