package com.example.quizmemory.data.helper

import android.util.Log
import com.example.quizmemory.data.model.QuizModel
import com.example.quizmemory.data.network.ApiInterface
import com.example.quizmemory.data.network.RetroClient.Companion.getQuiz
import retrofit2.awaitResponse

class ApiHelper {
    suspend fun getQuizApi(category: String , difficulty: String): QuizModel? {

        val apiInterface: ApiInterface = getQuiz().create(ApiInterface::class.java)
        val response = apiInterface.getApi(category = category, difficulty = difficulty).awaitResponse()
        if (response.isSuccessful){
            Log.e("Success", "getQuizApi:${response.body()} ", )
            return response.body()
        }
        return null
    }
}