package com.example.productscomposeapplication.core.api

import com.example.productscomposeapplication.core.pojos.ResponseProductGeneric
import retrofit2.http.GET

interface ProductApi {
    @GET("/products")
    suspend fun getProductsFromServer(): ResponseProductGeneric
}