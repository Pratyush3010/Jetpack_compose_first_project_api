package com.sb.localassignment.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
  import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sb.localassignment.R
import kotlin.math.sin

@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    val items = listOf(
        BottomNavItem.Jobs,
        BottomNavItem.Bookmarks
    )

    BottomNavigation(
        backgroundColor = Color.White, // Background color of the bottom navigation bar
        contentColor = Color.Black, // Default color for unselected items
        modifier = modifier
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(item.iconId),
                        modifier = Modifier.size(20.dp),
                        contentDescription = item.title,
                        tint = if (currentRoute == item.screen_route) Color.Blue else Color.Gray // Change icon color based on selection
                    )
                },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Blue, // Change the color of the selected item
                unselectedContentColor = Color.Gray, // Color for unselected items
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        // Avoid multiple copies of the same destination
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Restore state when reselecting a previously selected item
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    // Use a dummy NavController for preview
    BottomNavigationBar(navController = NavController(context = LocalContext.current))
}
