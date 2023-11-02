import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finaldesarrolloint.ui.theme.PurpleGrey40
import com.example.finaldesarrolloint.ui.theme.PurpleGrey80

@Composable
fun MyBottomNavigation(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = PurpleGrey80) {

        BottomNavigationItem(
            selected = false,
            onClick = { navController.navigate("MyPhotosMenu") },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "MyPhotos"
                )
            },
            label = { Text("MyPhotos") })

        BottomNavigationItem(
            selected = false,
            onClick = { navController.navigate("CoffeeShopsTopBar") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "CoffeeShops"
                )
            },
            label = { Text("CoffeeShops") })


        BottomNavigationItem(
            selected = false,
            onClick = {navController.navigate("ElSol")},
            icon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "ElSol"
                )
            },
            label = { Text("ElSol") })
    }
}




