package com.razgonyaev.rickandmortyapp.feature.character_list.presentation

import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.CharacterList
import com.xwray.groupie.Section

class CharacterListFactory {
    fun createBody(characterList: CharacterList, clickListener: (id: Int) -> Unit): List<Section> {
        return mutableListOf<Section>().apply {
            add(
                characterList.characterList.mapIndexed { index, character ->
                    CharacterItem(
                        character,
                        isDividerVisible = index != characterList.characterList.lastIndex,
                        clickListener,
                    )
                }.let(::Section)
            )
        }
    }
}