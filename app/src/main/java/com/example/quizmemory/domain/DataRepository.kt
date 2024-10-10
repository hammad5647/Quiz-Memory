package com.example.quizmemory.domain

import com.example.quizmemory.data.helper.ApiHelper

class DataRepository  {
    companion object{
        var repository = DataRepository()

    }
    private var helper = ApiHelper()
    suspend fun getQuizData(category: String, difficulty: String) = helper.getQuizApi(category = category, difficulty = difficulty)



}