package com.example.navigationarguments

// Declaring multiple arguments placeholders
/*
NavHost(navController, startDestination = "profile/{userId}/{username}/{address}") {       // or startDestination = "home"

    composable(
        "profile/{userId}/{username}/{address}",                    // declaring placeholder in String route
        arguments = listOf(                                         // declaring argument type
            navArgument("userId") { type = NavType.IntType },
            navArgument("username") { type = NavType.StringType },
            navArgument("address") { type = NavType.StringType }
        )
    ) { backStackEntry ->

        // Extracting exact values and passing it to Profile() screen
        val userId = backStackEntry.arguments?.getInt("userId")
        val username = backStackEntry.arguments?.getString("username")
        val address = backStackEntry.arguments?.getString("address")

        Profile(navController, userId, username, address)
    }
}*/
