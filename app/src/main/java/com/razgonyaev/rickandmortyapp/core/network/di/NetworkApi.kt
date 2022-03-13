package com.razgonyaev.rickandmortyapp.core.network.di

import retrofit2.Retrofit

interface NetworkApi {

    fun getRetrofit(): Retrofit
}