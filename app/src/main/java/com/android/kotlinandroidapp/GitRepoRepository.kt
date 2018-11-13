package com.android.kotlinandroidapp

import android.content.Context
import io.reactivex.Observable

class GitRepoRepository(private val netManager: NetManager) {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories() : Observable<ArrayList<Repository>> {
        netManager.isConnectedToInternet?.let {
            if (it) {
                //todo save those data to local data store
                return remoteDataSource.getRepositories()
            }
        }

        return localDataSource.getRepositories()
    }
}
