package com.example.quizmemory.data.model

data class QuizQuestionModel(
    var question: String,
    val correctAnswer: String,
    val options: MutableList<String?>

)