package com.razgonyaev.rickandmortyapp.feature.character_location.presentation

sealed class CharacterLocationState

object Uninitialized : CharacterLocationState()
object Loading : CharacterLocationState()
data class Success(val locationInfo: String) : CharacterLocationState()
object Error : CharacterLocationState()