package com.example.littlelemon

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.Black_LL
import com.example.littlelemon.ui.theme.Gray_LL
import com.example.littlelemon.ui.theme.Green_LL
import com.example.littlelemon.ui.theme.KarlaRegularFont
import com.example.littlelemon.ui.theme.Pink_LL
import com.example.littlelemon.ui.theme.Yellow_LL

// Define constants for SharedPreferences keys and name
const val PREFS_NAME        = "MyAppPrefs"
const val FIRST_NAME_KEY    = "firstnameText"
const val LAST_NAME_KEY     = "lastnameText"
const val EMAIL_KEY         = "emailText"
const val IS_LOGGED_IN_KEY  = "isLoggedIn"

// Helper function to get SharedPreferences instance
fun getPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
}

@Composable
fun Onboarding(navController: NavHostController, modifier: Modifier = Modifier){

    var firstname by remember { mutableStateOf( "") }
    var lastname by remember { mutableStateOf( "") }
    var email by remember { mutableStateOf( "") }

    // Button interaction
    val interactionSource = remember { MutableInteractionSource() }
    var isPressed by remember { mutableStateOf(false) }

    // Listen to interactions
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction: Interaction ->
            when (interaction) {
                is PressInteraction.Press -> isPressed = true
                is PressInteraction.Release, is PressInteraction.Cancel -> isPressed = false
            }
        }
    }

    val context = LocalContext.current
    val sharedPreferences = remember { getPreferences(context) }

    // SharedPreferences --- Function to save data
    val saveData = {
        sharedPreferences.edit()
            .putString(FIRST_NAME_KEY, firstname)
            .putString(LAST_NAME_KEY, lastname)
            .putString(EMAIL_KEY, email)
            .putBoolean(IS_LOGGED_IN_KEY, true)
            .apply()
    }

    // Get the Focus Manager
    val focusManager = LocalFocusManager.current

    val scrollState = rememberScrollState() // Needed if content might exceed screen height

    Column(
        // Main Column
        modifier = Modifier
            .fillMaxSize()
            .background(Gray_LL),
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
                Modifier.scale(0.35f)
            )
        }
        Column(
            // Let's get to know you Column
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.25f)
                .background(Green_LL),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = stringResource(id = R.string.Lets_get_to_know_you),
                fontFamily = KarlaRegularFont,
                fontSize = 26.sp,
                color = Gray_LL,
            )
        }
        //endregion
        Column(
            // Registration Column
            modifier = Modifier
                .fillMaxWidth()
                .weight(7.5f)
                .background(Gray_LL)
                .padding(start = 15.dp, end = 15.dp)
                .imePadding() // Add padding equal to the IME height at the bottom
                .verticalScroll(scrollState),
        ) {
            //region TextFields
            Text(
                text = stringResource(id = R.string.Personal_information),
                fontFamily = KarlaRegularFont,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Black_LL,
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 70.dp)
            )
            Text(
                text = stringResource(id = R.string.First_name),
                fontFamily = KarlaRegularFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Black_LL,
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
            OutlinedTextField(
                value = firstname,
                onValueChange = { firstname = it },
                shape = RoundedCornerShape(8.dp),
                singleLine = true, // Often desired with a "Done" action
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    ,
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = KarlaRegularFont,
                    color = Black_LL,
                ),
                trailingIcon = {
                    // Use IconButton to make the icon clickable
                    IconButton(
                        onClick = {
                            // When clicked, move focus to the next focusable item downwards
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ) {
                        // The actual Icon visual
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Or ArrowForward
                            // Describe what the button does.
                            contentDescription = "Move focus to next field"
                        )
                    }
                }
            )
            Text(
                text = stringResource(id = R.string.Last_name),
                fontFamily = KarlaRegularFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Black_LL,
                modifier = Modifier
                    .padding(bottom = 5.dp, top = 35.dp)
            )
            OutlinedTextField(
                value = lastname,
                onValueChange = { lastname = it },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    ,
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = KarlaRegularFont,
                    color = Black_LL,
                ),
                trailingIcon = {
                    // Use IconButton to make the icon clickable
                    IconButton(
                        onClick = {
                            // When clicked, move focus to the next focusable item downwards
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ) {
                        // The actual Icon visual
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Or ArrowForward
                            // Describe what the button does.
                            contentDescription = "Move focus to next field"
                        )
                    }
                }
            )
            Text(
                text = stringResource(id = R.string.Email),
                fontFamily = KarlaRegularFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Black_LL,
                modifier = Modifier
                    .padding(bottom = 5.dp, top = 35.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    ,
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = KarlaRegularFont,
                    color = Black_LL,
                ),
                // --- Add KeyboardOptions/Actions for consistency ---
                keyboardOptions = KeyboardOptions(
                    // Set the keyboard action button to "Done"
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    // When "Done" is pressed on the keyboard
                    onDone = {
                        focusManager.clearFocus() // Clear focus to hide keyboard
                    }
                ),
                // --- Add Trailing Icon to Hide Keyboard ---
                trailingIcon = {
                    IconButton(
                        onClick = {
                            // When the icon button is clicked:
                            focusManager.clearFocus() // <<--- This hides the keyboard
                            // You might also trigger form submission logic here
                            println("Done action triggered from icon")
                        }
                    ) {
                        Icon(
                            // Choose an icon like Done or KeyboardHide
                            imageVector = Icons.Default.Done, // Or Icons.Default.KeyboardHide
                            contentDescription = "Done / Hide keyboard" // Describe the action
                        )
                    }
                }
            )
            //endregion
            Button(
                onClick = {
                    // Making sure the data is not empty
                    if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()){
                        Toast.makeText(context,
                            "Registration unsuccessful. Please enter all data.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else if (!validateEmail(email) && (firstname.isNotEmpty() && lastname.isNotEmpty() && email.isNotEmpty()))
                    {
                        Toast.makeText(context,
                            "Registration unsuccessful. Please enter a valid email.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else{
                        Toast.makeText(context,
                            "Registration successful!",
                            Toast.LENGTH_LONG
                        ).show()

                        // Save login data
                        saveData()

                        navController.navigate("Home")
                        // To prevent back navigation to Onboarding after logging in.
                        {
                            popUpTo("Onboarding") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier
                    .padding(top = 130.dp)
                    .fillMaxWidth()
                    ,
                colors = ButtonDefaults
                            .buttonColors(
                                // Button interaction
                                if (isPressed) Green_LL else Yellow_LL,
                            ),
                // Button interaction
                interactionSource = interactionSource,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Pink_LL)
            ) {
                Text(
                    text = stringResource(id = R.string.Register),
                    fontFamily = KarlaRegularFont,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    // Button interaction
                    color = if (isPressed) Gray_LL else Black_LL,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun OnboardingPreview(){
    Onboarding(NavHostController(LocalContext.current))
}