package com.vinitchuri.roadsafe

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.home.HomeScreen
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.music.MusicScreen
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.profile.ProfileScreen
import com.vinitchuri.roadsafe.feature_roadsafe.presentation.util.Screen
import com.vinitchuri.roadsafe.ui.theme.RoadSafeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            RoadSafeApp()
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Composable
fun RoadSafeApp() {
    RoadSafeTheme {
        val items = listOf(
            Screen.HomeScreen,
            Screen.MusicScreen,
            Screen.ProfileScreen
        )
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        val selected = currentDestination?.hierarchy?.any {
                            it.route == screen.route
                        } == true
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = if (selected) screen.icon_filled else screen.icon_outlined,
                                    contentDescription = screen.label.toString()
                                )
                            },
                            label = { Text(stringResource(screen.label)) },
                            selected = selected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to avoid
                                    // building up a large stack of destinations on the back stack
                                    // as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController,
                startDestination = Screen.HomeScreen.route,
                Modifier.padding(innerPadding)
            ) {
                composable(route = Screen.HomeScreen.route) {
                    HomeScreen()
                }
                composable(route = Screen.MusicScreen.route) {
                    MusicScreen()
                }
                composable(route = Screen.ProfileScreen.route) {
                    ProfileScreen()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@Preview(
    showBackground = true, name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showBackground = true, name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    name = "Day mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)
@Composable
fun DefaultPreview() {
    RoadSafeApp()
}