package com.razgonyaev.rickandmortyapp.core.rx.di

import com.razgonyaev.rickandmortyapp.di.FeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer

class RxFeatureHolder(
    featureHolderContainer: FeatureHolderContainer
) : FeatureHolder<RxApi>(featureHolderContainer) {

    override fun buildFeature(): RxApi {
        return DaggerRxComponent.factory().create()
    }
}