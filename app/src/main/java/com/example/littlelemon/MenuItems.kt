package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

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
        Text( // Title
            item.title,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
            ,
            fontFamily = KarlaRegularFont,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column (
                modifier = Modifier.weight(0.8f)
            ){
                Text( // Description
                    item.description,
                    color = Color.Gray,
                    fontFamily = KarlaRegularFont,
//                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp

                )
                Text(
                    "$" + "%.2f".format(item.price),
                    color = Color.Black,
                    fontFamily = KarlaRegularFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(
                            top = 10.dp,
                            bottom = 10.dp,
                        )
                        ,

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
        HorizontalDivider(
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}

@Preview
@Composable
fun MenuItemsPreview(){
    MenuItems( items = listOf() )
}