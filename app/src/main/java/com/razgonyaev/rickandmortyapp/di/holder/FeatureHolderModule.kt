package com.razgonyaev.rickandmortyapp.di.holder

import com.razgonyaev.rickandmortyapp.di.FeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer
import com.razgonyaev.rickandmortyapp.di.core.network.di.NetworkApi
import com.razgonyaev.rickandmortyapp.di.core.network.di.NetworkFeatureHolder
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
object FeatureHolderModule {

    @Singleton
    @Provides
    @IntoMap
    @ClassKey(NetworkApi::class)
    fun provideNetworkApiFeatureHolder(featureHolderContainer: FeatureHolderContainer): FeatureHolder<*> {
        return NetworkFeatureHolder(featureHolderContainer)
    }
}