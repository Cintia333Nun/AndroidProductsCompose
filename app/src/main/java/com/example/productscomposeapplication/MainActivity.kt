package com.example.productscomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productscomposeapplication.core.utils.DestinationsUtils
import com.example.productscomposeapplication.core.utils.ParamsProductsData
import com.example.productscomposeapplication.core.utils.RoutesUtils
import com.example.productscomposeapplication.ui.components_data_product.ProductDataScreen
import com.example.productscomposeapplication.ui.components_products.ProductsScreen
import com.example.productscomposeapplication.ui.theme.ProductsComposeApplicationTheme
import com.example.productscomposeapplication.viewModels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val onBackCallback = { onBackPressedDispatcher.onBackPressed() }
        viewModel.getProducts()
        setContent {
            ProductsComposeApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddNavigation(viewModel, onBackCallback)
                }
            }
        }
    }
}

@Composable
fun AddNavigation(viewModel: ProductViewModel, onBackPressed: () -> Unit) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DestinationsUtils.PRODUCTS) {
        composable(route = DestinationsUtils.PRODUCTS) {
            ProductsScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = RoutesUtils.PRODUCTS_TO_PRODUCTS_DATA) {
            val name = it.arguments?.getString(ParamsProductsData.PRODUCT_NAME) ?: ""
            val description = it.arguments?.getString(ParamsProductsData.PRODUCT_DESCRIPTION) ?: ""
            val price = it.arguments?.getString(ParamsProductsData.PRODUCT_PRICE) ?: ""
            val url = it.arguments?.getString(ParamsProductsData.PRODUCT_URL) ?: ""
            ProductDataScreen(
                name = name, description = description, price = price,
                url = url, onBackPressed = onBackPressed
            )
        }
    }
}