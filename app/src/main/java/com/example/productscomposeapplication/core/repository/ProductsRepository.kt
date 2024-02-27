package com.example.productscomposeapplication.core.repository

import com.example.productscomposeapplication.core.api.ProductApi
import com.example.productscomposeapplication.core.datasource.ProductsDataSource
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val apiInterface: ProductApi
) {
    fun getRemoteProductsDataSource(): ProductsDataSource = ProductsDataSource(apiInterface)
}