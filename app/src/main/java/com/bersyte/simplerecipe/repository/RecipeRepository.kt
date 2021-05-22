package com.bersyte.simplerecipe.repository

import com.bersyte.simplerecipe.api.ApiService
import javax.inject.Inject


class RecipeRepository
@Inject constructor(private val apiService: ApiService) {

    suspend fun getRecipe() = apiService.getRecipe()

}