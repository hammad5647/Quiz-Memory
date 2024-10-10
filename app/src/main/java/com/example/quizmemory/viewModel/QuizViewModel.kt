package com.example.quizmemory.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizmemory.data.model.QuizQuestionModel
import com.example.quizmemory.domain.DataRepository
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private var questionData = MutableLiveData<MutableList<QuizQuestionModel>>()
    var question: LiveData<MutableList<QuizQuestionModel>> = questionData
    var selectedAnswer : String? = null

    var totalCorrectAnswers : Int = 0
    var totalWrongAnswers : Int = 0

    private var _quizNumber = MutableLiveData(0)
    var quizNumber: LiveData<Int> = _quizNumber

    private var repository = DataRepository()
    private var temp = mutableListOf<QuizQuestionModel>()

    var category: String = ""
    var difficulty: String = ""
    fun getData() {
        viewModelScope.launch {
            val quizList = repository.getQuizData(category = category, difficulty = difficulty)
            for (i in quizList?.results!!) {
                val options = i!!.incorrectAnswers
                options?.add(i.correctAnswer!!)
                options?.shuffle()
                temp.add(QuizQuestionModel(i.question!!, i.correctAnswer!!, options!!))
                questionData.value = temp
                Log.e("question", "getData: ${questionData.value}")
            }
        }
    }

    fun nextQuiz() {
        if (_quizNumber.value!! < 9) {
            correctAnswers()
            _quizNumber.value = _quizNumber.value!! + 1
        }
        else {
            correctAnswers()
//            Log.d("correctAnswers", "correctAnswers:  $totalCorrectAnswers")
//            Log.e("IncorrectAnswers", "IncorrectAnswers: $totalWrongAnswers")
        }
    }

    private fun correctAnswers() {
        if(question.value?.get(quizNumber.value!!)?.correctAnswer == selectedAnswer){
            totalCorrectAnswers++
        }else{
            totalWrongAnswers++
        }
    }

}