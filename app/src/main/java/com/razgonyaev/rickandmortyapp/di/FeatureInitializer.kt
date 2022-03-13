package com.razgonyaev.rickandmortyapp.di

import android.app.Application
import com.razgonyaev.rickandmortyapp.di.holder.DaggerFeatureHolderComponent

class FeatureInitializer(
    private val application: Application,
    private val featureHolderContainer: FeatureHolderContainer
) {

    fun initialize(): Map<Class<*>, FeatureHolder<*>> {
        return DaggerFeatureHolderComponent.factory()
            .create(
                application,
                featureHolderContainer,
            ).getFeatureHolders()
    }
}