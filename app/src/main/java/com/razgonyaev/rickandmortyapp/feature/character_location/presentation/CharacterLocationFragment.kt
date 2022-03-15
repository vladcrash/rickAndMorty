package com.razgonyaev.rickandmortyapp.feature.character_location.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.razgonyaev.rickandmortyapp.core.base.BaseFragment
import com.razgonyaev.rickandmortyapp.core.view.gone
import com.razgonyaev.rickandmortyapp.core.view.visible
import com.razgonyaev.rickandmortyapp.databinding.FragmentCharacterLocationBinding
import com.razgonyaev.rickandmortyapp.di.DI
import com.razgonyaev.rickandmortyapp.feature.character_list.di.CharacterListApi

class CharacterLocationFragment : BaseFragment() {

    private var _binding: FragmentCharacterLocationBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var viewModel: CharacterLocationViewModel
    private var characterId: Int = 0

    override fun resolveDependencies() {
        viewModel = ViewModelProvider(
            this,
            DI.getFeature(CharacterListApi::class.java).getCharacterLocationViewModelFactory()
        )[CharacterLocationViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        characterId = arguments?.getInt(CHARACTER_ID_PARAM) ?: error("no characterId is provided")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterLocationBinding
        .inflate(layoutInflater, container, false)
        .also {
            _binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.characterLocationState.observe(viewLifecycleOwner, ::render)
    }

    override fun onResume() {
        super.onResume()
        viewModel.onScreenVisible(characterId)
    }

    private fun render(state: CharacterLocationState) {
        when (state) {
            Uninitialized -> toInitialState()
            Loading -> toLoadingState()
            is Success -> toSuccessState(state)
            Error -> toErrorState()
        }
    }

    private fun toInitialState() {
        with(binding) {
            locationTextInfo.gone()
            progressBar.gone()
            errorText.gone()
        }
    }

    private fun toLoadingState() {
        with(binding) {
            locationTextInfo.gone()
            progressBar.visible()
            errorText.gone()
        }
    }

    private fun toSuccessState(successState: Success) {
        with(binding) {
            locationTextInfo.visible()
            progressBar.gone()
            errorText.gone()

            locationTextInfo.text = successState.locationInfo
        }
    }

    private fun toErrorState() {
        with(binding) {
            locationTextInfo.gone()
            progressBar.gone()
            errorText.visible()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun releaseDependencies() {
        DI.releaseFeature(CharacterListApi::class.java)
    }

    companion object {
        private const val CHARACTER_ID_PARAM = "character_id_param"

        fun newInstance(characterId: Int): CharacterLocationFragment =
            CharacterLocationFragment().apply {
                arguments = Bundle().apply {
                    putInt(CHARACTER_ID_PARAM, characterId)
                }
            }
    }
}