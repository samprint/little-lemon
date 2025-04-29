package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.Black_LL
import com.example.littlelemon.ui.theme.Category_Btn_LL
import com.example.littlelemon.ui.theme.Gray_LL
import com.example.littlelemon.ui.theme.Green_LL
import com.example.littlelemon.ui.theme.Order_Divider_LL
import com.example.littlelemon.ui.theme.Yellow_LL
import com.example.littlelemon.ui.theme.KarlaRegularFont
import com.example.littlelemon.ui.theme.MarkaziTextRegularFont

@Composable
fun Home(
        navController: NavHostController,
        menuItems: List<MenuItemRoom>,
        modifier: Modifier = Modifier,
){
    // add searchPhrase variable here
    var searchPhrase by rememberSaveable { mutableStateOf("") }

    var menuItems1 by rememberSaveable { mutableStateOf(menuItems) }

    var filterFlag by rememberSaveable { mutableStateOf(false) }

    Column(
        // Main Column
        modifier = Modifier
            .fillMaxSize()
            .background(Gray_LL)
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
                    painter = painterResource(id = R.drawable.profile2),
                    contentDescription = "Profile",
                    Modifier
//                        .offset(
//                            x = (-35).dp,
//                        )
                        .size(120.dp)
                        .scale(0.5f)
                        .align(Alignment.TopEnd)
                        .clickable {
                            navController.navigate("Profile")
                        },
                    contentScale = ContentScale.Crop,
                )
            }
        }
        Column ( // Hero and list sections
            modifier = Modifier
                .weight(8.75f)
                ,
        ){
            Column( // Hero Section
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.44f)
                    .background(Green_LL),
            ) {
                Row ( // Title
                    modifier = Modifier
                        .fillMaxHeight(0.212f)
                        .padding(start = 15.dp, end = 15.dp),
                ){
                    Text(
                        text = stringResource(id = R.string.Little_Lemon),
                        modifier = Modifier
                            .padding(
                                top = 5.dp,
                                ),
                        color = Yellow_LL,
                        fontFamily = MarkaziTextRegularFont,
                        fontSize = 60.sp,
                    )
                }
                Row ( // Text and hero image
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 15.dp,
                            end = 15.dp,
                            top = 10.dp,
                        ),
                ){
                    Column (
                        modifier = Modifier
                            .fillMaxWidth(0.60f)
                    ){
                        Text(
                            text = stringResource(id = R.string.Chicago),
                            modifier = Modifier
                                ,
                            color = Gray_LL,
                            fontFamily = MarkaziTextRegularFont,
                            fontSize = 38.sp,
                        )
                        Text(
                            text = stringResource(id = R.string.Hero_About),
                            modifier = Modifier
                                .padding(
                                    top = 10.dp
                                ),
                            style = TextStyle(
                                lineHeight = 20.sp,
                                platformStyle = PlatformTextStyle(includeFontPadding = false)
                            ),
                            color = Gray_LL,
                            fontFamily = KarlaRegularFont,
                            fontSize = 17.sp,
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 10.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hero_image),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .scale(0.95f)
                                .size(150.dp)
                                .clip(RoundedCornerShape(20.dp))
                                ,
                            contentScale = ContentScale.Crop,


                        )
                    }
                }
                Row ( // Search Text field

                )
                {
                    // Add OutlinedTextField
                    OutlinedTextField(
                        value = searchPhrase,
                        onValueChange = { searchPhrase = it },
                        label = {
                                    Text(
                                        stringResource(id = R.string.Enter_Search_Phrase),
                                    )
                                },
                        shape = RoundedCornerShape(8.dp),
                        // if singleLine = true, no need for keyboard options or actions
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 15.dp,
                                end = 15.dp,
                            )
                            ,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Gray_LL,
                            unfocusedContainerColor = Gray_LL,
                            disabledContainerColor = Color.LightGray, // Optional: for disabled state
                            // You might also want to adjust indicator colors if needed
//                            focusedIndicatorColor = MaterialTheme.colorScheme.primary, // Border color when focused
//                            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f) // Border color when unfocused
                        ),
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = KarlaRegularFont,
                            color = Black_LL,
                        ),
                        leadingIcon = { Icon( imageVector = Icons.Default.Search, contentDescription = "") },
                        trailingIcon = {
                            if (searchPhrase.isNotEmpty()) {
                                IconButton(onClick = { searchPhrase = "" }) {
                                    Icon(
                                        imageVector = Icons.Filled.Clear,
                                        contentDescription = "Clear text"
                                    )
                                }
                            }
                        }

                    )

                }
            }
            Column( // Filter Section
                modifier = Modifier
                    .weight(0.21f)
                    .padding(start = 15.dp, end = 15.dp),

                ){
                Row {
                    Text(
                        stringResource(id = R.string.Order_For_Delivery),
                        color = Black_LL,
                        fontFamily = KarlaRegularFont,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(top = 40.dp, bottom = 10.dp)
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Button(
                        onClick = {
                            // resetting
                            menuItems1 = menuItems
                            menuItems1 = FilterHelper().filterProducts(FilterType.Starters, menuItems1 )
                            filterFlag = true
                        },
                        contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                Category_Btn_LL,
                            ),
                        )
                    {
                        Text(
                            text = stringResource(id = R.string.Starters),
                            color = Black_LL,
                            fontFamily = KarlaRegularFont,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    }
                    Button(
                        onClick = {
                            // resetting
                            menuItems1 = menuItems
                            menuItems1 = FilterHelper().filterProducts(FilterType.Mains, menuItems1 )
                            filterFlag = true
                        },
                        contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                Category_Btn_LL,
                            ),
                        )
                    {
                        Text(
                            text = stringResource(id = R.string.Mains),
                            color = Black_LL,
                            fontFamily = KarlaRegularFont,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            )
                    }
                    Button(
                        onClick = {
                            // resetting
                            menuItems1 = menuItems
                            menuItems1 = FilterHelper().filterProducts(FilterType.Desserts, menuItems1 )
                            filterFlag = true
                        },
                        contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                Category_Btn_LL,
                            ),
                        )
                    {
                        Text(
                            text = stringResource(id = R.string.Desserts),
                            color = Black_LL,
                            fontFamily = KarlaRegularFont,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            )
                    }
                    Button(
                        onClick = {
                            // resetting
                            menuItems1 = menuItems
                            menuItems1 = FilterHelper().filterProducts(FilterType.Drinks, menuItems1 )
                            filterFlag = true
                        },
                        contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                Category_Btn_LL,
                            ),
                        )
                    {
                        Text(
                            text = stringResource(id = R.string.Drinks),
                            color = Black_LL,
                            fontFamily = KarlaRegularFont,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            )
                    }
                    Button(
                        onClick = {
                            // resetting
                            menuItems1 = menuItems
                            menuItems1 = FilterHelper().filterProducts(FilterType.All, menuItems1 )
                            filterFlag = true
                        },
                        contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                Category_Btn_LL,
                            ),
                        )
                    {
                        Text(
                            text = stringResource(id = R.string.All),
                            color = Black_LL,
                            fontFamily = KarlaRegularFont,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 30.dp),
                    color = Order_Divider_LL,
                    thickness = 0.5.dp
                )
            }
            Column( // List Section
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.35f)
                    .background(Gray_LL),
            ) {
                // the search can be applied on the filtered list
                if (searchPhrase.isNotEmpty()) {
                    MenuItems(
                        items =
                            (menuItems1
                                .filter {
                                    it.title.contains( searchPhrase, ignoreCase = true )
                                }).sortedBy{ it.title }
                    )
                }
                // display all the filtered items if search is empty
                else {
                    // to make sure menuItems1 is not empty
                    if (menuItems1.isEmpty() && (filterFlag == false)) menuItems1 = menuItems.sortedBy{ it.title }

                    MenuItems(items = menuItems1.sortedBy{ it.title })
                }

            }
        }

    }
}

@Preview
@Composable
fun HomePreview(
){
    Home(
        navController = NavHostController(LocalContext.current),
        menuItems = listOf()
    )
}