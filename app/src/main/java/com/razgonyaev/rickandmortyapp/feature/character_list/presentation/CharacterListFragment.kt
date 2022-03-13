package com.razgonyaev.rickandmortyapp.feature.character_list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.razgonyaev.rickandmortyapp.core.base.BaseFragment
import com.razgonyaev.rickandmortyapp.core.view.gone
import com.razgonyaev.rickandmortyapp.core.view.visible
import com.razgonyaev.rickandmortyapp.databinding.FragmentCharacterListBinding
import com.razgonyaev.rickandmortyapp.di.DI
import com.razgonyaev.rickandmortyapp.feature.character_list.di.CharacterListApi

class CharacterListFragment : BaseFragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var viewModel: CharacterListViewModel

    override fun resolveDependencies() {
        viewModel = ViewModelProvider(
            requireActivity(),
            DI.getFeature(CharacterListApi::class.java).getCharacterListViewModelFactory()
        )[CharacterListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterListBinding
        .inflate(layoutInflater, container, false)
        .also {
            _binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.adapterLiveData.observe(requireActivity()) { adapter ->
            binding.characterList.adapter = adapter
        }
        viewModel.characterListState.observe(requireActivity(), ::render)
    }

    override fun onResume() {
        super.onResume()
        viewModel.onScreenVisible()
    }

    private fun render(state: CharacterListState) {
        when (state) {
            Uninitialized -> toInitialState()
            Loading -> toLoadingState()
            Success -> toSuccessState()
            Error -> toErrorState()
        }
    }

    private fun toInitialState() {
        with(binding) {
            characterList.gone()
            progressBar.gone()
            errorImage.gone()
            errorText.gone()
        }
    }

    private fun toLoadingState() {
        with(binding) {
            characterList.gone()
            progressBar.visible()
            errorImage.gone()
            errorText.gone()
        }
    }

    private fun toSuccessState() {
        with(binding) {
            characterList.visible()
            progressBar.gone()
            errorImage.gone()
            errorText.gone()
        }
    }

    private fun toErrorState() {
        with(binding) {
            characterList.gone()
            progressBar.gone()
            errorImage.visible()
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
        fun newInstance(): CharacterListFragment = CharacterListFragment()
    }
}