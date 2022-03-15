package com.razgonyaev.rickandmortyapp.db.di

import android.content.Context
import com.razgonyaev.rickandmortyapp.di.FeatureHolder
import com.razgonyaev.rickandmortyapp.di.FeatureHolderContainer

class DatabaseFeatureHolder(
    private val context: Context,
    featureHolderContainer: FeatureHolderContainer,
) : FeatureHolder<DatabaseApi>(featureHolderContainer) {

    override fun buildFeature(): DatabaseApi {
        return DaggerDatabaseComponent
            .factory()
            .create(context)
    }
}