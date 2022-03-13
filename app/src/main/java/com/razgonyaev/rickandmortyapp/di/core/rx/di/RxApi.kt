package com.razgonyaev.rickandmortyapp.di.core.rx.di

import com.razgonyaev.rickandmortyapp.di.core.rx.RxSchedulers

interface RxApi {

    fun getRxSchedulers(): RxSchedulers
}