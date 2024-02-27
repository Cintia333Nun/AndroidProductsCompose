package com.example.productscomposeapplication.core.utils

object RoutesUtils {
    const val PRODUCTS_TO_PRODUCTS_DATA = "${DestinationsUtils.PRODUCTS_DATA}/" +
            "{${ParamsProductsData.PRODUCT_NAME}}/" +
            "{${ParamsProductsData.PRODUCT_DESCRIPTION}}/" +
            "{${ParamsProductsData.PRODUCT_PRICE}}/" +
            "?url={${ParamsProductsData.PRODUCT_URL}}"
}

object DestinationsUtils {
    const val PRODUCTS = "PRODUCTS"
    const val PRODUCTS_DATA = "PRODUCTS_DATA"
}

object ParamsProductsData {
    const val PRODUCT_NAME = "PRODUCT_NAME"
    const val PRODUCT_URL = "PRODUCT_URL"
    const val PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION"
    const val PRODUCT_PRICE = "PRODUCT_PRICE"
}