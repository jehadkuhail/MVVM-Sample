package com.jkuhail.mvvmsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.jkuhail.mvvmsample.databinding.UserItemBinding

import com.jkuhail.mvvmsample.model.User

class UsersAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.user_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userItem.user = users[position]
    }

    override fun getItemCount() = users.size

    inner class UserViewHolder(
        val userItem: UserItemBinding
    ): RecyclerView.ViewHolder(userItem.root)
}