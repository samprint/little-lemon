package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//var menuItems: List<MenuItemRoom> = listOf()

class MainActivity : ComponentActivity() {

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                // add databaseMenuItems code here
                val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())

                // add orderMenuItems variable here
                var orderMenuItems by rememberSaveable { mutableStateOf(false) }

//                lifecycleScope.launch(Dispatchers.IO) {
//                    if (database.menuItemDao().isEmpty()) {
//                        // add code here
//                        val menuItemsNetwork = fetchMenu()
//                        saveMenuToDatabase(menuItemsNetwork)
//                    }
//                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyNavigation(
                        modifier = Modifier.padding(innerPadding),
                        menuItems = databaseMenuItems,
                    )
                }

//                // add databaseMenuItems code here
//                val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())
//
//                // add orderMenuItems variable here
//                var orderMenuItems by rememberSaveable { mutableStateOf(false) }
//
//                // add menuItems variable here
//                val menuItems = databaseMenuItems
//
//                MenuItems(items = menuItems)
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {
                // add code here
                val menuItemsNetwork = fetchMenu()
                saveMenuToDatabase(menuItemsNetwork)
            }
        }


    }

    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        val itemsListMenu = httpClient
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body<MenuNetwork>()

        return itemsListMenu.menu
    }

    private fun saveMenuToDatabase(menuItemsNetwork: List<MenuItemNetwork>) {
        val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
        database.menuItemDao().insertAll(*menuItemsRoom.toTypedArray())
    }
}

@Composable
fun MyNavigation(modifier: Modifier = Modifier, menuItems: List<MenuItemRoom>) {
    val navController = rememberNavController()
    Navigation(navController = navController, menuItems = menuItems, modifier = modifier,)
}