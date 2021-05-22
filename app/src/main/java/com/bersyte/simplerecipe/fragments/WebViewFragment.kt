package com.bersyte.simplerecipe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bersyte.simplerecipe.R
import com.bersyte.simplerecipe.databinding.FragmentWebViewBinding
import com.bersyte.simplerecipe.model.Result


class WebViewFragment : Fragment(R.layout.fragment_web_view) {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!
    private val args: WebViewFragmentArgs by navArgs()
    private lateinit var recipe: Result

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWebViewBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipe = args.recipeWebview

        setUpWebView()
    }

    private fun setUpWebView(){

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(recipe.href)
        }


    }

}