package com.bersyte.simplerecipe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.bersyte.simplerecipe.R
import com.bersyte.simplerecipe.databinding.FragmentDetailBinding
import com.bersyte.simplerecipe.model.Result


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var recipe: Result

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe = args.recipe

        populateUI()

    }

    private fun populateUI() {
        binding.apply {

            tvTitleRecipeDetails.text = recipe.title
            tvIngredientsDetails.text = recipe.ingredients
            ivDetails.load(recipe.thumbnail) {
                crossfade(true)
                crossfade(1000)
            }

            btnOpenWebView.setOnClickListener { mView ->

                val directions = DetailFragmentDirections
                    .actionDetailFragment2ToWebViewFragment(recipe)

                mView.findNavController().navigate(directions)

            }


        }
    }

}






















