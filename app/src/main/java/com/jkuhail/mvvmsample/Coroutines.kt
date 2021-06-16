package com.jkuhail.mvvmsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    //This function allows us to fetch users in the IO thread, and update the UI in the Main thread
    fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) =

        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }

}