package com.example.lineup_contests

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContestViewModel : ViewModel() {
    private val _allContests = MutableLiveData<ArrayList<ContestsItem>>()
     val allContests:MutableLiveData<ArrayList<ContestsItem>> = _allContests
    fun getRecipes(){
        viewModelScope.launch {
            val apiResult = RetroFitHelper.apiService.getRecipe()
            _allContests.value = apiResult.body()
        }
    }
}