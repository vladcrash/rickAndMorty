package com.razgonyaev.rickandmortyapp.di.core.network.di

import com.razgonyaev.rickandmortyapp.di.FeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer

class NetworkFeatureHolder(
    featureHolderContainer: FeatureHolderContainer
) : FeatureHolder<NetworkApi>(featureHolderContainer) {

    override fun buildFeature(): NetworkApi =
        DaggerNetworkComponent.factory().create()
}