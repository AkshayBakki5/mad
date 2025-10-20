package com.example.wordsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count
    fun increment() {
        // Get current value or 0 if null, add 1, and post the new value
        _count.value = (_count.value ?: 0) + 1
    }
}