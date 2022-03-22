package com.razgonyaev.rickandmortyapp.feature.character_list.presentation

import com.xwray.groupie.Section

sealed class CharacterListState

object Uninitialized : CharacterListState()
object Loading : CharacterListState()
data class Success(val list: List<Section>) : CharacterListState()
object Error : CharacterListState()