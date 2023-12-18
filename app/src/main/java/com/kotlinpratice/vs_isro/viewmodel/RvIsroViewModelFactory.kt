package com.kotlinpratice.vs_isro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlinpratice.vs_isro.repository.IsroApiRepository

class RvIsroViewModelFactory(private val isroApiRepository: IsroApiRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RvIsroViewModel(isroApiRepository) as T
    }

}