package com.razgonyaev.rickandmortyapp.application

import android.app.Application
import com.razgonyaev.rickandmortyapp.di.DI
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer
import com.razgonyaev.rickandmortyapp.di.FeatureInitializer

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        DI.initialize(buildContainer())
    }

    private fun buildContainer(): FeatureHolderContainer {
        val featureHolderContainer = FeatureHolderContainer()
        val featureInitializer = FeatureInitializer(this, featureHolderContainer)
        featureHolderContainer.initialize(featureInitializer)
        return featureHolderContainer
    }
}