package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.merge

@Composable
fun MenuItems(
    items: List<MenuItemRoom>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 20.dp)
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MenuItem(menuItem)
                }
            }
        )
    }
}

@Composable
fun MenuItem( item: MenuItemRoom
){
    Column (
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
    ){
        Text(
            item.title,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
            ,
            fontFamily = KarlaRegularFont,
            fontWeight = FontWeight.Bold,
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column (
                modifier = Modifier.weight(0.8f)
            ){
                Text(
                    item.description,
                    color = Color.Black,
                )
                Text(
                    "%.2f".format(item.price),
                    color = Color.Black,
                )
            }
            Column {
                Image(
                    painter = rememberAsyncImagePainter(model = item.image),
                    contentDescription = item.title,
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuItemsPreview(){
    MenuItems( items = listOf() )
}