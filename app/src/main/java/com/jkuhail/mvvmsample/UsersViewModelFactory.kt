package com.jkuhail.mvvmsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * This class is responsible for creating an instance of UsersViewModel
 */

@Suppress("UNCHECKED_CAST")
class UsersViewModelFactory(
    private val repository: UsersRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(repository) as T
    }
}