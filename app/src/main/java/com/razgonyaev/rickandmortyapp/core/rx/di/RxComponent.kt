package com.razgonyaev.rickandmortyapp.core.rx.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RxModule::class])
interface RxComponent : RxApi {

    @Component.Factory
    interface Factory {
        fun create(): RxComponent
    }
}