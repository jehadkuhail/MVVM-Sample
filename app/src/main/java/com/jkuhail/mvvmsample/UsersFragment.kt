package com.jkuhail.mvvmsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class UsersFragment : Fragment() {

    private lateinit var factory: UsersViewModelFactory
    private lateinit var viewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.users_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = UsersRepository(UsersApi())
        factory = UsersViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(UsersViewModel::class.java)

    }


}