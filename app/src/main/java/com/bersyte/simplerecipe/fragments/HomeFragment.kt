package com.bersyte.simplerecipe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bersyte.simplerecipe.R
import com.bersyte.simplerecipe.adapter.RecipeAdapter
import com.bersyte.simplerecipe.databinding.FragmentHomeBinding
import com.bersyte.simplerecipe.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recipeAdapter: RecipeAdapter
    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRv()

    }

    private fun setUpRv() {
        recipeAdapter = RecipeAdapter()
        binding.rvRecipe.apply {
            layoutManager = GridLayoutManager(activity, 2)
            setHasFixedSize(true)
            adapter = recipeAdapter
        }


        viewModel.recipeResponse.observe(requireActivity(),
            { result ->
                binding.tvTitle.text = result.title
                recipeAdapter.recipe = result.results
            })

    }

}


























