package com.razgonyaev.rickandmortyapp.entrypoint

import androidx.fragment.app.FragmentManager
import com.razgonyaev.rickandmortyapp.R
import com.razgonyaev.rickandmortyapp.feature.character_list.presentation.CharacterListFragment
import com.razgonyaev.rickandmortyapp.feature.character_location.presentation.CharacterLocationFragment

object Navigator {

    fun navigateToCharacterList(fragmentManager: FragmentManager) {
        fragmentManager
            .beginTransaction()
            .replace(CONTAINER_ID_BODY, CharacterListFragment.newInstance())
            .commit()
    }

    fun navigateToCharacterLocation(fragmentManager: FragmentManager, characterId: Int) {
        fragmentManager
            .beginTransaction()
            .replace(CONTAINER_ID_BODY, CharacterLocationFragment.newInstance(characterId))
            .addToBackStack(null)
            .commit()
    }

    private const val CONTAINER_ID_BODY = R.id.fragment_container
}