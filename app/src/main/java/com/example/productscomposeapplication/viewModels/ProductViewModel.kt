package com.example.productscomposeapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productscomposeapplication.core.pojos.ResponseProduct
import com.example.productscomposeapplication.core.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(repository: ProductsRepository) : ViewModel() {
    private val repositoryRemoteProducts = repository.getRemoteProductsDataSource()

    private val _products = MutableStateFlow(emptyList<ResponseProduct>())
    val products = _products.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private fun setLoading(status: Boolean) {
        _isLoading.value = status
    }

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryRemoteProducts.getProducts().collect { result ->
                if (result.isSuccess) {
                    val tempList = result.getOrNull()
                    if (!tempList.isNullOrEmpty()) {
                        setLoading(status = true)
                        _products.value = tempList
                        setLoading(status = false)
                    }
                }
            }
        }
    }
}