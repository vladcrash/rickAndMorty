package com.razgonyaev.rickandmortyapp.di.core.network.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent : NetworkApi {

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}