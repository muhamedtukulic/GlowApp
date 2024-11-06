import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.items
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.LoginScreen
import com.example.myapplication.ui.screens.PagerScreen
import com.example.myapplication.ui.screens.PagerScreenSecond
import com.example.myapplication.ui.screens.PagerScreenThird
import com.example.myapplication.ui.screens.QuizzScreen
import com.example.myapplication.ui.screens.RegistrationScreen
import com.example.myapplication.ui.screens.SkinRoutine
import com.example.myapplication.ui.screens.SkinType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    val navController = rememberNavController()


    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.title)
                        },
                        label = { Text(text = item.title) },
                        alwaysShowLabel = false,
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = "Quiz", Modifier.padding(innerPadding)) {
            composable("Quiz") { QuizzScreen(navController = navController) }
            composable("Posts") { HomeScreen(navController = navController) }
            composable("Profile") { com.example.myapplication.ui.screens.ProfileScreen() }
            composable("Login") { LoginScreen() }
            composable("home") {
                HomeScreen(navController = navController)
            }
            composable("pager") {
                PagerScreen()
            }
            composable("pagerSecond") {
                PagerScreenSecond()
            }
            composable("pagerThird") {
                PagerScreenThird() }
            composable("login") {
                LoginScreen() }
            composable("Registration") { RegistrationScreen() }
            composable("skinRoutine/{skinType}") { backStackEntry ->
                val skinType = SkinType.valueOf(backStackEntry.arguments?.getString("skinType") ?: "")
                SkinRoutine(skinType = skinType)
            }

        }
    }
}






