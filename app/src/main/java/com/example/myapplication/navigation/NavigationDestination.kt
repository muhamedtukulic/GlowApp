package com.example.myapplication.navigation


interface NavigationDestination {
    val route: String
    val title: String
}
object LoginDestination : NavigationDestination {
    override val route = "login"
    override val title = "Login"
}

object RegistrationDestination : NavigationDestination {
    override val route = "registration"
    override val title = "Registration"
}

object PostsDestination : NavigationDestination {
    override val route = "posts"
    override val title = "Posts"
}

object ProfileDestination : NavigationDestination {
    override val route = "profile"
    override val title = "Profile"
}

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val title = "Home"
}
object QuizDestination : NavigationDestination {
    override val route = "quiz"
    override val title = "Quiz"
}

object SkinDestination : NavigationDestination {
    override val route = "routine"
    override val title = "Routine"
}

