package com.razgonyaev.rickandmortyapp.db.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface DatabaseComponent : DatabaseApi {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DatabaseComponent
    }
}