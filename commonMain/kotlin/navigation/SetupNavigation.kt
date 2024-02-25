package navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import screens.Home

@Composable
fun SetupNavigation(){
    Navigator(
        screen = Home(id =  "home")
    ){navigator ->
        ScaleTransition(navigator)


    }
}