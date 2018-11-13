package com.android.kotlinandroidapp

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun providesMainViewModelFactory(gitRepoRepository: GitRepoRepository)
                : MainViewModelFactory {
            return MainViewModelFactory(gitRepoRepository)
        }
    }

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity

}