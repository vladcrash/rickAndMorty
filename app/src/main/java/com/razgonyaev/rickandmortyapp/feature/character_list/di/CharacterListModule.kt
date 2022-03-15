package com.razgonyaev.rickandmortyapp.feature.character_list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulers
import com.razgonyaev.rickandmortyapp.db.di.DatabaseApi
import com.razgonyaev.rickandmortyapp.feature.character_list.data.api.CharacterListApi
import com.razgonyaev.rickandmortyapp.feature.character_list.data.mapper.CharacterListDataMapper
import com.razgonyaev.rickandmortyapp.feature.character_list.data.mapper.CharacterListResponseMapper
import com.razgonyaev.rickandmortyapp.feature.character_list.data.repository.CharacterListRepositoryImpl
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.interactor.CharacterListInteractor
import com.razgonyaev.rickandmortyapp.feature.character_list.presentation.CharacterListFactory
import com.razgonyaev.rickandmortyapp.feature.character_list.presentation.CharacterListViewModel
import com.xwray.groupie.GroupieAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object CharacterListModule {

    @Singleton
    @Provides
    fun provideCharacterListViewModelFactory(
        interactor: CharacterListInteractor,
        rxSchedulers: RxSchedulers,
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return if (modelClass == CharacterListViewModel::class.java) {
                    CharacterListViewModel(
                        interactor, rxSchedulers, CharacterListFactory(), GroupieAdapter()
                    ) as T
                } else {
                    throw IllegalArgumentException("viewModel $modelClass is not found")
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideCharacterListInteractor(
        retrofit: Retrofit,
        databaseApi: DatabaseApi,
    ): CharacterListInteractor {
        val apiMapper = CharacterListResponseMapper()
        val dataMapper = CharacterListDataMapper()
        val api = retrofit.create(CharacterListApi::class.java)
        val repository =
            CharacterListRepositoryImpl(api, apiMapper, databaseApi.getCharacterDao(), dataMapper)
        return CharacterListInteractor(
            repository
        )
    }
}