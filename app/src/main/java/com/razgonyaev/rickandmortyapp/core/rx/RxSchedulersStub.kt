package com.razgonyaev.rickandmortyapp.core.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class RxSchedulersStub : RxSchedulers {
    override fun io(): Scheduler = Schedulers.trampoline()
    override fun computation(): Scheduler = Schedulers.trampoline()
    override fun mainThread(): Scheduler = Schedulers.trampoline()
}