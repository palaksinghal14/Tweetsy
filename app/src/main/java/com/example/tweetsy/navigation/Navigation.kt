package com.example.tweetsy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsy.screens.CategoryScreen
import com.example.tweetsy.screens.detailScreen
import java.util.Locale.Category

//✅ STEP 7: SetUp Navigation between screens
@Composable
fun App(){
    val navController= rememberNavController() // method to create a new navcrontroller
   NavHost(navController =navController , startDestination ="category" ){
      composable(route="category"){
          CategoryScreen{
              navController.navigate("Tweets/${it}")
          }
      }
       //here we will also pass the parameter
       composable(route="Tweets/{category}", arguments = listOf(
           navArgument("category"){
               type= NavType.StringType
           }
       )){
           detailScreen()
       }
   }
}
