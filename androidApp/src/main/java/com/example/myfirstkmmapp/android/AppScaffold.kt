package com.example.myfirstkmmapp.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstkmmapp.android.screens.AboutScreen
import com.example.myfirstkmmapp.android.screens.ArticlesScreen
import com.example.myfirstkmmapp.android.screens.Screens
import com.example.myfirstkmmapp.android.screens.SourcesScreen

@Composable
fun AppScaffold() {
    /*
    rememberNavController(): This is a function provided by Jetpack Compose to create a NavController,
    which is used for navigating between composables.
     */
    val navController = rememberNavController()
    /*
    Scaffold: This is a composable function provided by Jetpack Compose that implements the basic material design visual layout structure of the app.
    It typically includes an app bar, floating action button, and body content.
     */
    Scaffold {  ///import androidx.compose.material3.Scaffold
        AppNavHost(navController = navController, modifier = Modifier
            .fillMaxSize()
            .padding(it))
    }
}

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    /*
    NavHost: This is a composable function provided by Jetpack Compose for defining a navigation graph.
    It hosts multiple destinations (screens) that can be navigated to.
    It takes a NavHostController and a start destination as parameters.
    Define the NavHost with two destinations - ARTICLES and ABOUT_DEVICE
     */
    NavHost(navController = navController, startDestination = Screens.ARTICLES.route, modifier = modifier) {
        // Define the ARTICLES destination and its associated composable
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) }, onSourcesButtonClick = { navController.navigate(Screens.SOURCES.route) })
        }

        composable(Screens.SOURCES.route) {
            SourcesScreen(onUpButtonClick = { navController.popBackStack()})
        }

        // Define the ABOUT_DEVICE destination and its associated composable
        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(onUpButtonClick = { navController.popBackStack() })
        }


    }
}
