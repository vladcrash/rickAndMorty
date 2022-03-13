package com.razgonyaev.rickandmortyapp.core.rx.di

import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulers

interface RxApi {

    fun getRxSchedulers(): RxSchedulers
}