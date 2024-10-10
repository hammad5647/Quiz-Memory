package com.example.quizmemory.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmemory.R
import com.example.quizmemory.databinding.ActivityDifficultyBinding

class DifficultyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDifficultyBinding
    private var selectedDifficulty: String? = null
    var category = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDifficultyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickInit()
        getIntentData()


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun clickInit() {
        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.easyBtn.setOnClickListener {
            binding.easyBtn.background = getDrawable(R.drawable.category_bg2)
            binding.mediumBtn.background = getDrawable(R.drawable.option_bg)
            binding.hardBtn.background = getDrawable(R.drawable.option_bg)
            selectedDifficulty = "easy"
            binding.difficultyOkBtn.visibility = View.VISIBLE
        }
        binding.mediumBtn.setOnClickListener {
            binding.mediumBtn.background = getDrawable(R.drawable.category_bg2)
            binding.easyBtn.background = getDrawable(R.drawable.option_bg)
            binding.hardBtn.background = getDrawable(R.drawable.option_bg)
            selectedDifficulty = "medium"
            binding.difficultyOkBtn.visibility = View.VISIBLE
        }
        binding.hardBtn.setOnClickListener {
            binding.hardBtn.background = getDrawable(R.drawable.category_bg2)
            binding.easyBtn.background = getDrawable(R.drawable.option_bg)
            binding.mediumBtn.background = getDrawable(R.drawable.option_bg)
            selectedDifficulty = "hard"
            binding.difficultyOkBtn.visibility = View.VISIBLE
        }
        binding.difficultyOkBtn.setOnClickListener {
            val intent = Intent(this, GamePlayActivity::class.java)
            intent.putExtra("difficulty", selectedDifficulty)
            intent.putExtra("category", category)
            startActivity(intent)
        }
    }

    private fun getIntentData() {
        val intent = intent
        category = intent.getStringExtra("category").toString()
    }
}