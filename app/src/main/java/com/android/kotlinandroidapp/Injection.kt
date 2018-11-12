package com.android.kotlinandroidapp

import android.content.Context

object Injection {

    private fun provideNetManager(context: Context) : NetManager {
        return NetManager(context)
    }

    private fun gitRepoRepository(netManager: NetManager) :GitRepoRepository {
        return GitRepoRepository(netManager)
    }

    fun provideMainViewModelFactory(context: Context): MainViewModelFactory {
        val netManager = provideNetManager(context)
        val repository = gitRepoRepository(netManager)
        return MainViewModelFactory(repository)
    }
}