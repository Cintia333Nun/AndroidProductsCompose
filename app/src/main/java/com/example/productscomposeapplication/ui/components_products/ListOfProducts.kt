package com.example.productscomposeapplication.ui.components_products

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.productscomposeapplication.core.pojos.ResponseProduct

@Composable
fun ListOfProducts(data: List<ResponseProduct>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(data) { item ->
            CardProduct(item, navController)
        }
    }
}