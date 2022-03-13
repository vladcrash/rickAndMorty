package com.razgonyaev.rickandmortyapp.di.core.rx.di

import com.razgonyaev.rickandmortyapp.di.core.rx.RxSchedulers
import com.razgonyaev.rickandmortyapp.di.core.rx.RxSchedulersImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RxModule {

    @Singleton
    @Provides
    fun provideSchedulers(): RxSchedulers {
        return RxSchedulersImpl()
    }
}