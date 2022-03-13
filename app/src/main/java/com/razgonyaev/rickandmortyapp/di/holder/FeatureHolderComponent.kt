package com.razgonyaev.rickandmortyapp.di.holder

import android.app.Application
import com.razgonyaev.rickandmortyapp.di.FeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FeatureHolderModule::class])
interface FeatureHolderComponent {

    fun getFeatureHolders(): Map<Class<*>, FeatureHolder<*>>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance featureHolderContainer: FeatureHolderContainer,
        ): FeatureHolderComponent
    }
}