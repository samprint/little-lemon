package com.example.littlelemon

class FilterHelper {

    fun filterProducts(type: FilterType, menuItems: List<MenuItemRoom>) : List<MenuItemRoom> {
        return when (type) {
            FilterType.All -> menuItems
            FilterType.Mains -> menuItems.filter { it.category == "mains" }
            FilterType.Desserts -> menuItems.filter { it.category == "desserts" }
            FilterType.Starters -> menuItems.filter { it.category == "starters" }
        }
    }

}