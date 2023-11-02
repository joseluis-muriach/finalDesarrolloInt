package com.example.finaldesarrolloint

import MyBottomNavigation
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finaldesarrolloint.ui.theme.FinalDesarrolloIntTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.elsol.Cover
import com.example.elsol.Email
import com.example.elsol.Info
import com.example.finaldesarrolloint.CoffeeShops.MainComments
import com.example.finaldesarrolloint.CoffeeShops.MenuShop
import com.example.finaldesarrolloint.CoffeeShops.MyTopAppBar
import com.example.finaldesarrolloint.MyPhotos.Exercise3

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint(
        "UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FinalDesarrolloIntTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { MyBottomNavigation(navController) }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = ("finalDesarrolloInt")
                    ) {
                        //myProjects
                        composable("finalDesarrolloInt") { CoverF(navController) }

                        //myPhotos
                        composable("MyPhotosMenu") { Exercise3() }

                        //elSol
                        composable("ElSol") {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                val navController = rememberNavController() //Esto es lo que faltaba para que funcionase
                                NavHost(navController = navController, startDestination = "Cover") {
                                    composable("Cover") { Cover(navController = navController) }
                                    composable("Filled.Email") { Email() }
                                    composable("Filled.Info") { Info() }
                                    composable("Filled.Build") { Cover(navController = navController) }
                                }
                            }
                        }

                        //coffeeShops
                        composable("CoffeeShopsTopBar") {
                            Scaffold(
                                topBar = {
                                    MyTopAppBar()
                                }
                            ) {
                                val navController = rememberNavController()
                                NavHost(
                                    navController = navController,
                                    startDestination = "MenuShop"
                                ) {
                                    composable("MenuShop") { MenuShop(navController = navController) }
                                    composable(
                                        route = "MainComments/{cafeteriaName}",
                                        arguments = listOf(navArgument("cafeteriaName") {
                                            type = NavType.StringType
                                        })
                                    ) { backStackEntry ->
                                        MainComments(
                                            backStackEntry.arguments?.getString("cafeteriaName")
                                                ?: "", navController
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
