package com.example.quizmemory.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmemory.R
import com.example.quizmemory.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private var selectedCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickInit()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun clickInit() {
        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.gkBtn.setOnClickListener {
            binding.gkBtn.background = getDrawable(R.drawable.category_bg2)
            binding.booksBtn.background = getDrawable(R.drawable.option_bg)
            binding.filmBtn.background = getDrawable(R.drawable.option_bg)
            binding.musicBtn.background = getDrawable(R.drawable.option_bg)
            binding.randomBtn.background = getDrawable(R.drawable.option_bg)
            binding.theatreBtn.background = getDrawable(R.drawable.option_bg)
            binding.televisionBtn.background = getDrawable(R.drawable.option_bg)
            binding.gamesBtn.background = getDrawable(R.drawable.option_bg)

            binding.ctgOkBtn.visibility = View.VISIBLE
            selectedCategory = "9"
        }
        binding.booksBtn.setOnClickListener {
            binding.booksBtn.background = getDrawable(R.drawable.category_bg2)
            binding.gkBtn.background = getDrawable(R.drawable.option_bg)
            binding.filmBtn.background = getDrawable(R.drawable.option_bg)
            binding.musicBtn.background = getDrawable(R.drawable.option_bg)
            binding.randomBtn.background = getDrawable(R.drawable.option_bg)
            binding.theatreBtn.background = getDrawable(R.drawable.option_bg)
            binding.televisionBtn.background = getDrawable(R.drawable.option_bg)
            binding.gamesBtn.background = getDrawable(R.drawable.option_bg)


            binding.ctgOkBtn.visibility = View.VISIBLE
            selectedCategory = "10"
        }
        binding.filmBtn.setOnClickListener {
            binding.filmBtn.background = getDrawable(R.drawable.category_bg2)
            binding.gkBtn.background = getDrawable(R.drawable.option_bg)
            binding.booksBtn.background = getDrawable(R.drawable.option_bg)
            binding.musicBtn.background = getDrawable(R.drawable.option_bg)
            binding.randomBtn.background = getDrawable(R.drawable.option_bg)
            binding.theatreBtn.background = getDrawable(R.drawable.option_bg)
            binding.televisionBtn.background = getDrawable(R.drawable.option_bg)
            binding.gamesBtn.background = getDrawable(R.drawable.option_bg)

            binding.ctgOkBtn.visibility = View.VISIBLE
            selectedCategory = "11"
        }
        binding.musicBtn.setOnClickListener {
            binding.musicBtn.background = getDrawable(R.drawable.category_bg2)
            binding.gkBtn.background = getDrawable(R.drawable.option_bg)
            binding.filmBtn.background = getDrawable(R.drawable.option_bg)
            binding.booksBtn.background = getDrawable(R.drawable.option_bg)
            binding.randomBtn.background = getDrawable(R.drawable.option_bg)
            binding.theatreBtn.background = getDrawable(R.drawable.option_bg)
            binding.televisionBtn.background = getDrawable(R.drawable.option_bg)
            binding.gamesBtn.background = getDrawable(R.drawable.option_bg)

            binding.ctgOkBtn.visibility = View.VISIBLE
            selectedCategory = "12"

        }
        binding.theatreBtn.setOnClickListener {
            binding.theatreBtn.background = getDrawable(R.drawable.category_bg2)
            binding.gkBtn.background = getDrawable(R.drawable.option_bg)
            binding.filmBtn.background = getDrawable(R.drawable.option_bg)
            binding.musicBtn.background = getDrawable(R.drawable.option_bg)
            binding.randomBtn.background = getDrawable(R.drawable.option_bg)
            binding.booksBtn.background = getDrawable(R.drawable.option_bg)
            binding.televisionBtn.background = getDrawable(R.drawable.option_bg)
            binding.gamesBtn.background = getDrawable(R.drawable.option_bg)

            binding.ctgOkBtn.visibility = View.VISIBLE
            selectedCategory = "13"

        }
        binding.televisionBtn.setOnClickListener {
            binding.televisionBtn.background = getDrawable(R.drawable.category_bg2)
            binding.gkBtn.background = getDrawable(R.drawable.option_bg)
            binding.filmBtn.background = getDrawable(R.drawable.option_bg)
            binding.musicBtn.background = getDrawable(R.drawable.option_bg)
            binding.randomBtn.background = getDrawable(R.drawable.option_bg)
            binding.booksBtn.background = getDrawable(R.drawable.option_bg)
            binding.theatreBtn.background = getDrawable(R.drawable.option_bg)
            binding.gamesBtn.background = getDrawable(R.drawable.option_bg)

            binding.ctgOkBtn.visibility = View.VISIBLE
            selectedCategory = "14"

        }
        binding.gamesBtn.setOnClickListener {
            binding.gamesBtn.background = getDrawable(R.drawable.category_bg2)
            binding.gkBtn.background = getDrawable(R.drawable.option_bg)
            binding.filmBtn.background = getDrawable(R.drawable.option_bg)
            binding.musicBtn.background = getDrawable(R.drawable.option_bg)
            binding.randomBtn.background = getDrawable(R.drawable.option_bg)
            binding.booksBtn.background = getDrawable(R.drawable.option_bg)
            binding.theatreBtn.background = getDrawable(R.drawable.option_bg)
            binding.televisionBtn.background = getDrawable(R.drawable.option_bg)

            binding.ctgOkBtn.visibility = View.VISIBLE
            selectedCategory = "15"

        }
        binding.randomBtn.setOnClickListener {
            if (binding.randomBtn.background == getDrawable(R.drawable.category_bg2)) {
                binding.randomBtn.background = getDrawable(R.drawable.option_bg)
                binding.ctgOkBtn.visibility = View.GONE
                selectedCategory = ""
            } else {
                binding.randomBtn.background = getDrawable(R.drawable.category_bg2)
                binding.gkBtn.background = getDrawable(R.drawable.option_bg)
                binding.filmBtn.background = getDrawable(R.drawable.option_bg)
                binding.musicBtn.background = getDrawable(R.drawable.option_bg)
                binding.booksBtn.background = getDrawable(R.drawable.option_bg)
                binding.ctgOkBtn.visibility = View.VISIBLE
                selectedCategory = ""

            }
        }
        binding.ctgOkBtn.setOnClickListener {
            val intent = Intent(this, DifficultyActivity::class.java)
            intent.putExtra("category", selectedCategory)
            startActivity(intent)
        }
    }
}