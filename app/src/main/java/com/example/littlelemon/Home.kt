package com.example.littlelemon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Home",
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = { navController.navigate("Profile") },
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .padding(start = 75.dp, end = 75.dp)
            ,
            colors = ButtonDefaults
                .buttonColors(
                    Color(0xFFF4CE14),
                ),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFFEE9972))
        ) {
            Text(
                text = "Profile",
                fontFamily = KarlaRegularFont,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(vertical = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    Home(NavHostController(LocalContext.current))
}