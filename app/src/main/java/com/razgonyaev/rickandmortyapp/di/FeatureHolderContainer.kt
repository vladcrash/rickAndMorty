package com.razgonyaev.rickandmortyapp.di

class FeatureHolderContainer {

    private val featureHolders = HashMap<Class<*>, FeatureHolder<*>>()

    fun initialize(featureInitializer: FeatureInitializer) {
        featureHolders.putAll(featureInitializer.initialize())
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getFeature(key: Class<T>): T {
        return featureHolders.getValue(key).getFeature() as T
    }

    fun <T : Any> releaseFeature(key: Class<T>) {
        featureHolders.getValue(key).releaseFeature()
    }
}