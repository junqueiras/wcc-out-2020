package com.wcc.todayscocktail.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wcc.todayscocktail.network.Cocktail
import com.wcc.todayscocktail.network.CocktailsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CocktailsListRepository() {
    private val cocktailListResponse = MutableLiveData<List<Cocktail>>()

    val  cocktailList: LiveData<List<Cocktail>>
        get() = cocktailListResponse

    init {
        getCocktailsList()
    }

    private fun getCocktailsList() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listResult = CocktailsApi.retrofitService.getCocktails().cocktailsList
                cocktailListResponse.postValue(listResult)

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    cocktailListResponse.postValue(listOf())
                }
            }
        }
    }

}
