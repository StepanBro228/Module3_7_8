package com.example.module2_7_8.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.module2_7_8.presentation.ui.screen.TodoDetailScreen
import com.example.module2_7_8.presentation.ui.screen.TodoListScreen
import com.example.module2_7_8.presentation.viewmodel.TodoViewModel

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: TodoViewModel = viewModel()

    NavHost(navController = navController, startDestination = "list", modifier = modifier) {
        composable("list") {
            TodoListScreen(viewModel, onTodoClick = { id -> navController.navigate("detail/$id") })
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            TodoDetailScreen(viewModel, id, onBack = { navController.popBackStack() })
        }
    }
}
