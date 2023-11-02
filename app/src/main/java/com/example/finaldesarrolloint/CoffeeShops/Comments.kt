package com.example.finaldesarrolloint.CoffeeShops

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.finaldesarrolloint.ui.theme.FontTittle

data class Comments(
    var comment: String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainComments(navControllerName:String, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val nombreCafeteria = navBackStackEntry?.arguments?.getString("cafeteriaName") ?: ""
    val listState = rememberLazyStaggeredGridState()
    var isMenuVisible by remember { mutableStateOf(false) }
    val buttonVisible = remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.padding(20.dp))
        }

        Row(Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Text(text = nombreCafeteria,
                fontFamily = FontTittle,
                fontSize = 35.sp,
                color = Color.Black)
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            state = listState,
            content = {
                items(getComment().size) { indice ->
                    var comments = getComment()
                    Card(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(10.dp)
                    ) {
                        Text(text = comments[indice].comment,
                            modifier = Modifier.padding(10.dp))
                    }
                }
            }
        )

        val scrollOffset = listState.firstVisibleItemScrollOffset
        if (scrollOffset > 0 && buttonVisible.value) {
            buttonVisible.value = false
        } else if (scrollOffset == 0 && !buttonVisible.value) {
            buttonVisible.value = true
        }
    }
    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter) {
        if (!buttonVisible.value) {
            Button(
                onClick = {  },
                modifier = Modifier
                    .padding(16.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(Color.Yellow),
            ) {
                Text(text = "Add new comment",
                    color = Color.Black
                )
            }
        }
    }
}

fun getComment(): List<Comments> {
    return listOf(
        Comments("Servicio algo flojo, aún así lo recomiendo"),
        Comments("Céntrica y acogedora. Volveremos seguro"),
        Comments("La ambientacion muy buena, pero en la planta de arriba un poco escasa."),
        Comments(
            "La comida estaba deliciosa y bastante bien de precio, mucha variedad de platos.\n" +
                    "El personal muy amable, nos permitieron ver todo el establecimiento.\n"
        ),
        Comments("Muy bueno"),
        Comments("Excelente. Destacable la extensa carta de cafés."),
        Comments("Buen ambiente y buen servicio. Lo recomiendo."),
        Comments("En días festivos demasiado tiempo de espera."),
        Comments("Los camareros/as no dan abasto."),
        Comments("No lo recomiendo."),
        Comments("No volveré."),
        Comments("Repetiremos."),
        Comments("Gran selección de tartas y cafés."),
        Comments(
            "La vajilla muy bonita todo de diseño que en el entorno del bar queda ideal." + "\n" +
                    "Puntos negativos: el servicio es muy lento y los precios son un poco elevados.",),
        Comments("Todo lo que he probado en la cafetería está riquísimo, dulce o salado.")
    )
}
