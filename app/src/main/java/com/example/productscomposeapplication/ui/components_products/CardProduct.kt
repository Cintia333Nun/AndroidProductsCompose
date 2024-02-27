package com.example.productscomposeapplication.ui.components_products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.productscomposeapplication.core.pojos.ResponseProduct
import com.example.productscomposeapplication.core.utils.DestinationsUtils
import com.example.productscomposeapplication.ui.theme.colorPrimary

@Composable
fun CardProduct(item: ResponseProduct, navController: NavController) {
    Card(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        try {
                            navController.navigate(
                                "${DestinationsUtils.PRODUCTS_DATA}/${item.title}/${item.description}/${item.price}/?url=${item.thumbnail}"
                            )
                        } catch (exception: Exception) {
                            //exception.printStackTrace()
                        }
                    }
                )
            }
            .fillMaxWidth()
            .padding(all = 16.dp),
        border = BorderStroke(2.dp, colorPrimary),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        )
    ) {
        Column {
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                text = "Nombre: ${item.title}"
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
                text = item.description
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp),
                text = "Precio: ${item.price}"
            )
        }
    }
}