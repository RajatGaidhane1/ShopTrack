package eu.tutorials.mywishlistapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import eu.tutorials.mywishlistapp.HomeView
import eu.tutorials.mywishlistapp.ui.theme.ItemViewModel

@Composable
fun Navigation(
    viewModel: ItemViewModel = viewModel(),
    navController: NavHostController = androidx.navigation.compose.rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeView(viewModel, navController)
        }
        composable(
            route = Screen.AddScreen.route + "/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.LongType
                defaultValue = 0L
                nullable = false
            })
        ) { entry ->
            val id = entry.arguments?.getLong("id") ?: 0L
            AddEditDetailView(
                id = id,
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}
