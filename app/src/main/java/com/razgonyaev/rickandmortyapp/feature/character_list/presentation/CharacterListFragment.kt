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
import com.razgonyaev.rickandmortyapp.entrypoint.Navigator
import com.razgonyaev.rickandmortyapp.feature.character_list.di.CharacterListApi
import com.xwray.groupie.GroupieAdapter

class CharacterListFragment : BaseFragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var viewModel: CharacterListViewModel
    private var _adapter: GroupieAdapter? = null
    private val adapter
        get() = _adapter!!

    override fun resolveDependencies() {
        viewModel = ViewModelProvider(
            this,
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
        _adapter = GroupieAdapter()
        binding.characterList.adapter = adapter

        viewModel.characterListState.observe(viewLifecycleOwner, ::render)
        viewModel.characterClickedId.observe(viewLifecycleOwner) { id ->
            Navigator.navigateToCharacterLocation(
                requireActivity().supportFragmentManager,
                characterId = id
            )
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onScreenVisible()
    }

    private fun render(state: CharacterListState) {
        when (state) {
            Uninitialized -> toInitialState()
            Loading -> toLoadingState()
            is Success -> toSuccessState(state)
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

    private fun toSuccessState(state: Success) {
        with(binding) {
            characterList.visible()
            progressBar.gone()
            errorImage.gone()
            errorText.gone()

            adapter.addAll(state.list)
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
        _adapter = null
    }

    override fun releaseDependencies() {
        DI.releaseFeature(CharacterListApi::class.java)
    }

    companion object {
        fun newInstance(): CharacterListFragment = CharacterListFragment()
    }
}