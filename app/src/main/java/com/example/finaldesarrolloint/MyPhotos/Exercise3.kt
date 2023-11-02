package com.example.finaldesarrolloint.MyPhotos

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.SAVED_STATE_REGISTRY_OWNER_KEY
import com.example.finaldesarrolloint.R


data class Pictur(
    @DrawableRes var photo: Int
)

@Preview(showBackground = true)
@Composable
fun Exercise3() {
    Column(Modifier.fillMaxSize()) {
        var selectedPictur: Pictur? by remember { mutableStateOf(null) }
        LazyRow() {
            items(getPictur()) { superPictur ->
                ItemPictur(
                    Pictur = superPictur) {selectedPictur = it
                }
            }
        }
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            selectedPictur?.let { painterResource(id = it.photo) }?.let {
                Image(
                    painter = it,
                    contentDescription = "Pictur",
                    modifier =
                    Modifier
                        .size(500.dp)
                        .padding(5.dp)
                )
            }
        }
    }
}

@Composable
fun ItemPictur(Pictur: Pictur, onItemSelected: (Pictur) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(Pictur)}) {
        Image(
            painter = painterResource(id = Pictur.photo),
            contentDescription = "Picturs",
            contentScale = ContentScale.Inside,
            modifier = Modifier.padding(5.dp)
        )
    }
}


fun getPictur(): List<Pictur> {
    return listOf(
        Pictur(
            R.drawable.image1
        ),
        Pictur(
            R.drawable.image2
        ),
        Pictur(
            R.drawable.image3
        ),
        Pictur(
            R.drawable.image4
        ),
        Pictur(
            R.drawable.image5
        ),
        Pictur(
            R.drawable.image6
        ),
        Pictur(
            R.drawable.image7
        ),
        Pictur(
            R.drawable.image8
        ),
    )
}