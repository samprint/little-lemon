package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun MenuItems(
//    items: List<MenuItemRoom>
){
    Text("List")
}

@Composable
fun MenuItem( item: MenuItemRoom
){
    Column {
        Text(item.title)
        Text(item.description)
        Text("%.2f".format(item.price))
        Image(
            painter = rememberAsyncImagePainter(model = item.image),
            contentDescription = item.title,
            modifier = Modifier,
            contentScale = ContentScale.Crop
        )
    }
}