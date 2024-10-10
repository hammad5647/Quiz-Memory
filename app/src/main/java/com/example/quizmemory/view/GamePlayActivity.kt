package com.example.quizmemory.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmemory.R
import com.example.quizmemory.databinding.ActivityGamePlayBinding
import com.example.quizmemory.viewModel.QuizViewModel

class GamePlayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGamePlayBinding
    private val viewModel by viewModels<QuizViewModel>()
    private lateinit var dialog: Dialog
    var countDown: CountDownTimer? = null


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGamePlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.questionNumber.text = "${viewModel.quizNumber.value?.plus(1)}/10"
        observers()
        timerCountdown()
        getIntentData()
        loadingDialog()
        initClick()

    }

    private fun observers() {
        viewModel.question.observe(this) {
            binding.textView.text = it[0].question
            binding.txtOptA.text = it[0].options[0]
            binding.txtOptB.text = it[0].options[1]
            binding.txtOptC.text = it[0].options[2]
            binding.txtOptD.text = it[0].options[3]
            dialog.dismiss()
            countDown!!.start()

        }
        viewModel.quizNumber.observe(this) {
            binding.textView.text = viewModel.question.value?.get(it)?.question
            binding.txtOptA.text = viewModel.question.value?.get(it)?.options?.get(0)
            binding.txtOptB.text = viewModel.question.value?.get(it)?.options?.get(1)
            binding.txtOptC.text = viewModel.question.value?.get(it)?.options?.get(2)
            binding.txtOptD.text = viewModel.question.value?.get(it)?.options?.get(3)
        }
    }

    private fun timerCountdown() {
        countDown = object : CountDownTimer(30000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                binding.quizSeconds.text = (millisUntilFinished / 1000).toString()
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                binding.quizSeconds.text = "0"
                viewModel.nextQuiz()
                countDown!!.cancel()
                countDown!!.start()
            }
        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun initClick() {
        binding.backBtn.setOnClickListener {
            val dialog = Dialog(this)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setContentView(R.layout.dialog_layout)
            dialog.show()

            val noBtn = dialog.findViewById<TextView>(R.id.noBtn)
            val yesBtn = dialog.findViewById<TextView>(R.id.yesBtn)

            noBtn.setOnClickListener {
                dialog.dismiss()
            }
            yesBtn.setOnClickListener {
                dialog.dismiss()
                finish()
            }
        }
        binding.optionALayout.setOnClickListener {
            binding.optionALayout.setBackgroundResource(R.drawable.option_selected_bg)
            binding.optionBLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionCLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionDLayout.setBackgroundResource(R.drawable.option_bg)
            viewModel.question
            viewModel.selectedAnswer =
                viewModel.question.value?.get(viewModel.quizNumber.value!!)?.options?.get(0)

        }

        binding.optionBLayout.setOnClickListener {
            binding.optionBLayout.setBackgroundResource(R.drawable.option_selected_bg)
            binding.optionALayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionCLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionDLayout.setBackgroundResource(R.drawable.option_bg)
            viewModel.question
            viewModel.selectedAnswer =
                viewModel.question.value?.get(viewModel.quizNumber.value!!)?.options?.get(1)
        }
        binding.optionCLayout.setOnClickListener {
            binding.optionCLayout.setBackgroundResource(R.drawable.option_selected_bg)
            binding.optionBLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionALayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionDLayout.setBackgroundResource(R.drawable.option_bg)
            viewModel.question
            viewModel.selectedAnswer =
                viewModel.question.value?.get(viewModel.quizNumber.value!!)?.options?.get(2)

        }
        binding.optionDLayout.setOnClickListener {
            binding.optionDLayout.setBackgroundResource(R.drawable.option_selected_bg)
            binding.optionBLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionCLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionALayout.setBackgroundResource(R.drawable.option_bg)
            viewModel.question
            viewModel.selectedAnswer = binding.txtOptD.text.toString()
            viewModel.selectedAnswer =
                viewModel.question.value?.get(viewModel.quizNumber.value!!)?.options?.get(3)

        }
        binding.nextQtnBtn.setOnClickListener {
            viewModel.nextQuiz()
            binding.questionNumber.text = "${viewModel.quizNumber.value!!+1}/10"
            countDown!!.cancel()
            countDown!!.start()
            binding.optionBLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionALayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionDLayout.setBackgroundResource(R.drawable.option_bg)
            binding.optionCLayout.setBackgroundResource(R.drawable.option_bg)

            if (viewModel.quizNumber.value == 9) {
                binding.submitBtn.visibility = View.VISIBLE
            }
        }
        binding.submitBtn.setOnClickListener {
            viewModel.nextQuiz()
            val intent = Intent(this,ResultActivity::class.java)
            Log.e("correct", "initClick: ${viewModel.totalCorrectAnswers}", )
            Log.e("incorrect", "initClick: ${viewModel.totalWrongAnswers}",)

            intent.putExtra("correctAnswer",viewModel.totalCorrectAnswers)
            intent.putExtra("incorrectAnswer",viewModel.totalWrongAnswers)
            startActivity(intent)
        }
    }

    private fun getIntentData() {
        val intent = intent
        val category = intent.getStringExtra("category")
        val difficulty = intent.getStringExtra("difficulty")
        viewModel.category = category!!
        viewModel.difficulty = difficulty!!
        viewModel.getData()
    }

    private fun loadingDialog() {

        dialog = Dialog(this)
        dialog.setContentView(R.layout.loading_layout)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }
}