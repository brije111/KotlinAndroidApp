package com.android.kotlinandroidapp

import android.content.Context
import io.reactivex.Observable
import javax.inject.Inject

class GitRepoRepository@Inject constructor(var netManager: NetManager) {

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
