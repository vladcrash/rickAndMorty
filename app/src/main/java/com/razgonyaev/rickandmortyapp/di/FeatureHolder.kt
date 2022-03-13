package com.razgonyaev.rickandmortyapp.di

abstract class FeatureHolder<T>(
    private val featureHolderContainer: FeatureHolderContainer
) {

    private var feature: T? = null

    fun getFeature(): T {
        if (feature == null) {
            feature = buildFeature()
        }

        return feature!!
    }

    protected fun <D : Any> getDependency(key: Class<D>): D =
        featureHolderContainer.getFeature(key)

    fun releaseFeature() {
        feature = null
    }

    abstract fun buildFeature(): T
}