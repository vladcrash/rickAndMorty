package com.razgonyaev.rickandmortyapp.feature.character_list.presentation

sealed class CharacterListState

object Uninitialized : CharacterListState()
object Loading : CharacterListState()
object Success : CharacterListState()
object Error : CharacterListState()