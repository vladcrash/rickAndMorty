package com.razgonyaev.rickandmortyapp.feature.character_list.di

import com.razgonyaev.rickandmortyapp.core.network.di.NetworkApi
import com.razgonyaev.rickandmortyapp.core.rx.di.RxApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CharacterListModule::class],
    dependencies = [RxApi::class, NetworkApi::class]
)
interface CharacterListComponent : CharacterListApi {

    @Component.Factory
    interface Factory {
        fun create(
            rxApi: RxApi,
            networkApi: NetworkApi,
        ): CharacterListComponent
    }
}