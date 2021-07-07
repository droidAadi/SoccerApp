package com.droid.soccerapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * @author adityakhullar on 21/06/21.
 */
open class BaseViewModel : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}
