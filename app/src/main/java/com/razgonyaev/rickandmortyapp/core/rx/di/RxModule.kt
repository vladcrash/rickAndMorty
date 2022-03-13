package com.razgonyaev.rickandmortyapp.core.rx.di

import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulers
import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulersImpl
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