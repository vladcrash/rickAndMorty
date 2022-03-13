package com.razgonyaev.rickandmortyapp.feature.character_list.presentation

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.razgonyaev.rickandmortyapp.R
import com.razgonyaev.rickandmortyapp.databinding.CharacterListItemBinding
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.Character
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem

class CharacterItem(
    private val character: Character,
    private val isDividerVisible: Boolean,
) : BindableItem<CharacterListItemBinding>() {

    override fun bind(binding: CharacterListItemBinding, position: Int) {
        with(binding) {
            title.text = character.name
            value.text = character.status
            divider.visibility = if (isDividerVisible) VISIBLE else GONE
            icon.clipToOutline = true
            Picasso.get()
                .load(character.imageUrl)
                .error(R.drawable.ill_200_error_outline)
                .resizeDimen(R.dimen.icon_size, R.dimen.icon_size)
                .centerCrop()
                .into(icon)
        }
    }

    override fun getLayout(): Int = R.layout.character_list_item

    override fun initializeViewBinding(view: View): CharacterListItemBinding =
        CharacterListItemBinding.bind(view)
}