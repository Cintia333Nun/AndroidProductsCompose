package com.example.productscomposeapplication.core.datasource

import com.example.productscomposeapplication.core.api.ProductApi
import com.example.productscomposeapplication.core.pojos.ResponseProduct
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsDataSource(private val apiInterface: ProductApi) {
    suspend fun getProducts(): Flow<Result<List<ResponseProduct>>> = flow {
        try {
            val response = apiInterface.getProductsFromServer()
            val data = response.listProducts
            emit(Result.success(data))
        } catch (exception: Exception) {
            emit(Result.failure(exception))
        }
    }
}