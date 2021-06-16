package com.jkuhail.mvvmsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jkuhail.mvvmsample.model.User
import kotlinx.coroutines.Job

class UsersViewModel(
    private val repository: UsersRepository
) : ViewModel() {

    private lateinit var job: Job

    //We did this to make sure that users list is editable only in the viewModel
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    fun getUsers() {
        job = Coroutines.ioThenMain(
            { repository.getUsers() },
            {
                _users.value = it!!.data
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}