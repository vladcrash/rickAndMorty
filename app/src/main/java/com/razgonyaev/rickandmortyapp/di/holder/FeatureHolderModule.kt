package com.razgonyaev.rickandmortyapp.di.holder

import android.app.Application
import com.razgonyaev.rickandmortyapp.core.network.di.NetworkApi
import com.razgonyaev.rickandmortyapp.core.network.di.NetworkFeatureHolder
import com.razgonyaev.rickandmortyapp.core.rx.di.RxApi
import com.razgonyaev.rickandmortyapp.core.rx.di.RxFeatureHolder
import com.razgonyaev.rickandmortyapp.db.di.DatabaseApi
import com.razgonyaev.rickandmortyapp.db.di.DatabaseFeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer
import com.razgonyaev.rickandmortyapp.feature.character_list.di.CharacterListApi
import com.razgonyaev.rickandmortyapp.feature.character_list.di.CharacterListFeatureHolder
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

    @Singleton
    @Provides
    @IntoMap
    @ClassKey(RxApi::class)
    fun provideRxFeatureHolder(featureHolderContainer: FeatureHolderContainer): FeatureHolder<*> {
        return RxFeatureHolder(featureHolderContainer)
    }

    @Singleton
    @Provides
    @IntoMap
    @ClassKey(CharacterListApi::class)
    fun provideCharacterListFeatureHolder(featureHolderContainer: FeatureHolderContainer): FeatureHolder<*> {
        return CharacterListFeatureHolder(featureHolderContainer)
    }

    @Singleton
    @Provides
    @IntoMap
    @ClassKey(DatabaseApi::class)
    fun provideDatabaseFeatureHolder(
        application: Application,
        featureHolderContainer: FeatureHolderContainer
    ): FeatureHolder<*> {
        return DatabaseFeatureHolder(application, featureHolderContainer)
    }
}