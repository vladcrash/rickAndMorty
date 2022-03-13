package com.razgonyaev.rickandmortyapp.entrypoint

import androidx.fragment.app.FragmentManager
import com.razgonyaev.rickandmortyapp.R
import com.razgonyaev.rickandmortyapp.feature.character_list.presentation.CharacterListFragment

class Navigator {

    fun navigateToCharacterList(fragmentManager: FragmentManager) {
        fragmentManager
            .beginTransaction()
            .replace(CONTAINER_ID_BODY, CharacterListFragment.newInstance())
            .commit()
    }

    private companion object {
        val CONTAINER_ID_BODY = R.id.fragment_container
    }
}