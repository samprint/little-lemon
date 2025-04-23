package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier){
    Column(
        // Main Column
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
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
                    .fillMaxSize()
//                    .padding(top = 50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    Modifier.scale(0.35f)
//                        .fillMaxSize()
                        .align(Alignment.TopCenter)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    Modifier.scale(0.5f)
                        .align(Alignment.TopEnd)
                        .clickable {
                            navController.navigate("Profile")
                        }
                )
            }

        }
    }
//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//        ,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ){
//        Text(
//            text = "Home",
//            fontSize = 30.sp,
//            color = Color.Black,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//        )
//        Button(
//            onClick = { navController.navigate("Profile") },
//            modifier = Modifier
//                .padding(top = 30.dp)
//                .fillMaxWidth()
//                .padding(start = 75.dp, end = 75.dp)
//            ,
//            colors = ButtonDefaults
//                .buttonColors(
//                    Color(0xFFF4CE14),
//                ),
//            shape = RoundedCornerShape(8.dp),
//            border = BorderStroke(1.dp, Color(0xFFEE9972))
//        ) {
//            Text(
//                text = "Profile",
//                fontFamily = KarlaRegularFont,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black,
//                modifier = Modifier
//                    .padding(vertical = 4.dp)
//            )
//        }
//    }
}

@Preview
@Composable
fun HomePreview(){
    Home(NavHostController(LocalContext.current))
}