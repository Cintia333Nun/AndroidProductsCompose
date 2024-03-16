package com.example.productscomposeapplication.ui.components_data_product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productscomposeapplication.R
import com.example.productscomposeapplication.ui.theme.black
import com.example.productscomposeapplication.ui.theme.colorPrimary
import com.example.productscomposeapplication.ui.theme.white

@Composable
fun ProductDataScreen(
    name: String, description: String, price: String, url: String, onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            text = name,
            textAlign = TextAlign.Center,
            color = black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        ImageWithCoil(
            key = name, url = url, height = 300//, width = 300
        )
        Text(
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            text = description,
        )
        Text(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 32.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = price,
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 24.dp),
            onClick = { onBackPressed.invoke() },
            border = BorderStroke(1.dp, color = colorPrimary),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                contentColor = colorPrimary,
                containerColor = white
            ),
        ) {
            Text(text = stringResource(id = R.string.button_back))
        }
    }
}