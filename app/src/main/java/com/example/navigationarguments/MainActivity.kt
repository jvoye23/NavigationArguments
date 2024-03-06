package com.example.navigationarguments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationarguments.ui.theme.NavigationArgumentsTheme
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationArgumentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNavigation()
                }
            }
        }
    }
}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{firstName}/{lastName}",
            arguments = listOf(
                navArgument("firstName"){
                    type = NavType.StringType
                },
                navArgument("lastName") {
                    type = NavType.StringType
                }
            )
        ) {
            val firstName = it.arguments?.getString("firstName") ?:""
            val lastName = it.arguments?.getString("lastName") ?:""
            
            DetailScreen(firstName = firstName, lastName = lastName)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {

    var firstNameText by remember {
        mutableStateOf("")
    }

    var lastNameText by remember {
        mutableStateOf("")
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        TextField(
            value = firstNameText,
            onValueChange = { firstNameText = it },
            label = { Text("First Name") }
        )

        TextField(
            value = lastNameText,
            onValueChange = { lastNameText = it },
            label = { Text("Last Name") }
        )

        Button(onClick = {
            navController.navigate(Screen.DetailScreen.withArgs(firstNameText, lastNameText))
        }) {
            Text(text = "Click Me")
        }
    }

}

@Composable
fun DetailScreen (firstName: String, lastName: String) {
    

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Row {
            Text(text = "$firstName")
            Text(text = " ")
            Text(text = "$lastName")
        }
    }
}