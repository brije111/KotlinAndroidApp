package com.android.kotlinandroidapp

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class MainViewModelFactory(private val repository: GitRepoRepository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}