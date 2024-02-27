package com.example.productscomposeapplication.ui.components_products

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.productscomposeapplication.R
import com.example.productscomposeapplication.ui.theme.ProductsComposeApplicationTheme
import com.example.productscomposeapplication.ui.theme.backgroundTransparent
import com.example.productscomposeapplication.ui.theme.colorPrimary
import com.example.productscomposeapplication.viewModels.ProductViewModel

@Composable
fun ProductsScreen(viewModel: ProductViewModel, navController: NavController) {
    val productsState by viewModel.products.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = stringResource(id = R.string.title_products),
            color = colorPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        ListOfProducts(data = productsState, navController = navController)
    }

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = backgroundTransparent)
                .clickable {},
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexPreview() {
    ProductsComposeApplicationTheme {
        ProductsScreen(
            viewModel = viewModel(),
            navController = rememberNavController()
        )
    }
}