package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


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
        //    GlideImage(
        //        item.image, // The URL string
        //        contentDescription = "Image fetched from URL", // Essential for accessibility
        //        modifier = Modifier.size(200.dp), // Set your desired size/constraints
        //        contentScale = ContentScale.Crop,
        //    )
    }
}