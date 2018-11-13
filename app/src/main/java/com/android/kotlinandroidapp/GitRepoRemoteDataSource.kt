package com.android.kotlinandroidapp

import android.os.Handler
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GitRepoRemoteDataSource {

    fun getRepositories() : Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First from remote", "Owner 1", 100, false))
        arrayList.add(Repository("Second from remote", "Owner 2", 30, true))
        arrayList.add(Repository("Third from remote", "Owner 3", 430, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }
}
