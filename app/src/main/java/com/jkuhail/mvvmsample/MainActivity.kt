package com.jkuhail.mvvmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = UsersRepository(UsersApi())

        GlobalScope.launch(Dispatchers.Main) {
            val users = repository.getUsers()
            Toast.makeText(this@MainActivity, users.data.size.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}