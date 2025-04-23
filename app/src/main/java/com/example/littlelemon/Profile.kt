package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Profile(navController: NavHostController, modifier: Modifier = Modifier){

    var firstname by remember { mutableStateOf( "") }
    var lastname by remember { mutableStateOf( "") }
    var email by remember { mutableStateOf( "") }

    val context = LocalContext.current
    val sharedPreferences = remember { getPreferences(context) }

    // --- SharedPreferences ---

    // Function to save data
//    val saveData = {
//        sharedPreferences.edit()
//            .putString(FIRST_NAME_KEY, firstname)
//            .putString(LAST_NAME_KEY, lastname)
//            .putString(EMAIL_KEY, email)
//            .putBoolean(IS_LOGGED_IN_KEY, true)
//            .apply() // Use apply() for asynchronous saving
//    }
    // Function to load data
    val loadData = {
        firstname = sharedPreferences.getString(FIRST_NAME_KEY, "") ?: ""
        lastname = sharedPreferences.getString(LAST_NAME_KEY, "") ?: ""
        email = sharedPreferences.getString(EMAIL_KEY, "") ?: ""
    }

    // Function to save data
    val eraseData = {
        sharedPreferences.edit()
            .putString(FIRST_NAME_KEY, "")
            .putString(LAST_NAME_KEY, "")
            .putString(EMAIL_KEY, "")
            .putBoolean(IS_LOGGED_IN_KEY, false)
            .apply() // Use apply() for asynchronous saving
    }

    // --- Load data when the composable first launches ---
    LaunchedEffect(Unit) { // Executes once when the composable enters the composition
        loadData()
    }

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
                .weight(1.25f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                Modifier.scale(0.5f)
            )
        }
        Column(
            // Let's get to know you Column
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.25f)
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Let's get to know you",
                fontFamily = KarlaRegularFont,
                fontSize = 26.sp,
                color = Color.White,
            )
        }
        //endregion
        Column(
            // Registration Column
            modifier = Modifier
                .fillMaxWidth()
                .weight(7.5f)
                .background(Color.White)
                .padding(start = 15.dp, end = 15.dp),
        ) {
            //region TextFields
            Text(
                text = "Personal information",
                fontFamily = KarlaRegularFont,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 70.dp)
            )
            Text(
                text = "First name",
                fontFamily = KarlaRegularFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
            OutlinedTextField(
                value = firstname,
                onValueChange = { firstname = it },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = KarlaRegularFont,
                    color = Color.Black,
                )
            )
            Text(
                text = "Last name",
                fontFamily = KarlaRegularFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 5.dp, top = 35.dp)
            )
            OutlinedTextField(
                value = lastname,
                onValueChange = { lastname = it },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = KarlaRegularFont,
                    color = Color.Black,
                )
            )
            Text(
                text = "Email",
                fontFamily = KarlaRegularFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 5.dp, top = 35.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = KarlaRegularFont,
                    color = Color.Black,
                )
            )
            //endregion
            Button(
                onClick = {

                    Toast.makeText(context,
                        "You logged out successfully!",
                        Toast.LENGTH_LONG
                    ).show()
                    // Save login state to SharedPreferences
//                    val prefs = context.
//                    getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
//                    prefs.edit().putBoolean("isLoggedIn", false).apply()

                    // Erase data from SharedPreferences
                    eraseData()
                    navController.navigate("onBoarding")
//                    // Making sure the data is not empty
//                    if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()){
//                        Toast.makeText(context,
//                            "Registration unsuccessful. Please enter all data.",
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                    else{
//                        Toast.makeText(context,
//                            "Registration successful!",
//                            Toast.LENGTH_LONG
//                        ).show()
//
//                        // load login data
//                        loadData()
//
//                        navController.navigate("Home")
//                        // To prevent back navigation to Onboarding after logging in.
//                        {
//                            popUpTo("Onboarding") { inclusive = true }
//                        }
//                    }
                },
                modifier = Modifier
                    .padding(top = 130.dp)
                    .fillMaxWidth()
                ,
                colors = ButtonDefaults
                    .buttonColors(
                        Color(0xFFF4CE14),
                    ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFEE9972))
            ) {
                Text(
                    text = "Log out",
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
}

@Preview
@Composable
fun ProfilePreview(){
    Profile(NavHostController(LocalContext.current))
}