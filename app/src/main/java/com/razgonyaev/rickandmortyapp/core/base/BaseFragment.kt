package com.razgonyaev.rickandmortyapp.core.base

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract fun resolveDependencies()
    abstract fun releaseDependencies()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resolveDependencies()
    }

    override fun onStop() {
        super.onStop()
        if (isRemoving) {
            releaseDependencies()
        }
    }
}