package com.razgonyaev.rickandmortyapp.feature.character_location.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulers
import com.razgonyaev.rickandmortyapp.db.di.DatabaseApi
import com.razgonyaev.rickandmortyapp.feature.character_location.data.api.CharacterLocationApi
import com.razgonyaev.rickandmortyapp.feature.character_location.data.mapper.CharacterLocationDataMapper
import com.razgonyaev.rickandmortyapp.feature.character_location.data.mapper.CharacterLocationResponseMapper
import com.razgonyaev.rickandmortyapp.feature.character_location.data.repository.CharacterLocationRepositoryImpl
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.interactor.CharacterLocationInteractor
import com.razgonyaev.rickandmortyapp.feature.character_location.presentation.CharacterLocationFactory
import com.razgonyaev.rickandmortyapp.feature.character_location.presentation.CharacterLocationViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
object CharacterLocationModule {

    @CharacterLocationViewModelQualifier
    @Singleton
    @Provides
    fun provideCharacterLocationViewModelFactory(
        interactor: CharacterLocationInteractor,
        rxSchedulers: RxSchedulers,
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return if (modelClass == CharacterLocationViewModel::class.java) {
                    CharacterLocationViewModel(
                        interactor, rxSchedulers, CharacterLocationFactory()
                    ) as T
                } else {
                    throw IllegalArgumentException("viewModel $modelClass is not found")
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideCharacterLocationInteractor(
        retrofit: Retrofit,
        databaseApi: DatabaseApi,
    ): CharacterLocationInteractor {
        val apiMapper = CharacterLocationResponseMapper()
        val api = retrofit.create(CharacterLocationApi::class.java)
        val dataMapper = CharacterLocationDataMapper()
        val repository =
            CharacterLocationRepositoryImpl(
                api,
                apiMapper,
                databaseApi.getCharacterLocationDao(),
                dataMapper
            )
        return CharacterLocationInteractor(
            repository
        )
    }
}

@Qualifier
annotation class CharacterLocationViewModelQualifier