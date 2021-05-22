package com.bersyte.simplerecipe.api

import com.bersyte.simplerecipe.model.RecipeResponse
import com.bersyte.simplerecipe.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getRecipe(): Response<RecipeResponse>

}