package com.example.productscomposeapplication.ui.components_data_product

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.example.productscomposeapplication.R

@Composable
fun ImageWithCoil(
    key: String, url: String, height: Int = 80, //width: Int = 80,
    marginVertical: Int = 24, marginHorizontal: Int = 16
) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(url)
            .crossfade(true)
            .diskCacheKey(key)
            .memoryCacheKey(key)
            .build(),
        placeholder = painterResource(R.drawable.broken_image),
        error = painterResource(R.drawable.broken_image),
        contentDescription = stringResource(R.string.title_products),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            //.width(width.dp)
            .height(height.dp)
            .padding(
                top = marginVertical.dp, start = marginHorizontal.dp, end = marginHorizontal.dp
            )
    )
}