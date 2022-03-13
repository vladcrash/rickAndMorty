package com.razgonyaev.rickandmortyapp.feature.character_list.di

import com.razgonyaev.rickandmortyapp.core.network.di.NetworkApi
import com.razgonyaev.rickandmortyapp.core.rx.di.RxApi
import com.razgonyaev.rickandmortyapp.di.FeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer

class CharacterListFeatureHolder(
    featureHolderContainer: FeatureHolderContainer
) : FeatureHolder<CharacterListApi>(featureHolderContainer) {

    override fun buildFeature(): CharacterListApi =
        DaggerCharacterListComponent.factory().create(
            getDependency(RxApi::class.java),
            getDependency(NetworkApi::class.java)
        )
}