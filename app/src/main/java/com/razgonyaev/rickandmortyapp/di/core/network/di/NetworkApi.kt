package com.razgonyaev.rickandmortyapp.di.core.network.di

import retrofit2.Retrofit

interface NetworkApi {

    fun getRetrofit(): Retrofit
}