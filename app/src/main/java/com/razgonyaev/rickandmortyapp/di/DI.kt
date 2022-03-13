package com.razgonyaev.rickandmortyapp.di

object DI {

    private lateinit var featureHolderContainer: FeatureHolderContainer

    fun initialize(featureHolderContainer: FeatureHolderContainer) {
        DI.featureHolderContainer = featureHolderContainer
    }

    fun <T : Any> getFeature(key: Class<T>): T =
        featureHolderContainer.getFeature(key)

    fun <T : Any> releaseFeature(key: Class<T>) {
        featureHolderContainer.releaseFeature(key)
    }
}