package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier){
    Column(
        // Main Column
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        //region Columns
        Column(
            // Logo Column
            modifier = Modifier
                .weight(1.25f)
                ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    Modifier
                        .scale(0.35f)
                        .align(Alignment.TopCenter)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    Modifier
                        .offset(
                            x = -35.dp,
//                            y = -10.dp
                        )
                        .scale(0.35f)
                        .align(Alignment.TopEnd)
                        .clickable {
                            navController.navigate("Profile")
                        }
                )
            }
        }
        Column ( // Hero and list sections
            modifier = Modifier
                .padding(start = 45.dp, end = 45.dp)
                .weight(8.75f)
                ,
        ){
            Column( // Hero Section
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .background(Color(0xFF495E57)),
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxHeight(0.18f)
                ){
                    Text(
                        text = "Little Lemon",
                        modifier = Modifier
                            .padding(top = 5.dp, start = 10.dp),
                        color = Color(0xFFF4CE14),
                        fontFamily = MarkaziTextRegularFont,
                        fontSize = 40.sp,
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Column (
                        modifier = Modifier
                            .fillMaxWidth(0.55f)
                    ){
                        Text(
                            text = "Chicago",
                            modifier = Modifier
                                .padding(start = 10.dp),
                            color = Color.White,
                            fontFamily = MarkaziTextRegularFont,
                            fontSize = 25.sp,
                        )
                        Text(
                            text = "We are a family-owned Mediterranean restaurant, " +
                                    "focused on traditional recipes served with a modern twist.",
                            modifier = Modifier
                                .padding(
                                    start = 10.dp,
                                    top = 16.dp
                                ),
                            style = TextStyle(
                                lineHeight = 14.sp,
                                platformStyle = PlatformTextStyle(includeFontPadding = false)
                            ),
                            color = Color.White,
                            fontFamily = KarlaRegularFont,
                            fontSize = 13.sp,
                        )
                    }
                    Column(
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hero_image),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .scale(0.7f)
                                .size(150.dp)
                                .clip(RoundedCornerShape(20.dp))
                                ,
                            contentScale = ContentScale.Crop,


                        )
                    }
                }
            }
            Column( // List Section
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(7f)
                    .background(Color.White),
            ) {
                Text("List")

            }
        }

    }
}

@Preview
@Composable
fun HomePreview(){
    Home(NavHostController(LocalContext.current))
}