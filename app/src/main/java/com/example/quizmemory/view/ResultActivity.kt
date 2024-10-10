package com.example.quizmemory.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizmemory.R
import com.example.quizmemory.databinding.ActivityResultBinding
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickInit()
        val intent = intent
        binding.correctAnswer.text = intent.getIntExtra("correctAnswer", 0).toString()
        binding.incorrectAnswer.text = intent.getIntExtra("incorrectAnswer", 0).toString()

        if (binding.correctAnswer.text.toString().toInt() >= 6) {
            partyTime()
        }else{
            binding.imageView4.setImageResource(R.drawable.won)
            partyTime()
        }
    }
    private fun clickInit(){
        binding.restartBtn.setOnClickListener{
            startActivity(Intent(this,CategoryActivity::class.java))
        }
    }

    private fun partyTime() {
        val party = Party(
            speed = 30f,
            maxSpeed = 60f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 3, TimeUnit.SECONDS).perSecond(100),
            position = Position.Relative(0.0, 0.0)

        )
        binding.konfettiView.start(party)

        val party2 = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 3, TimeUnit.SECONDS).perSecond(100),
            position = Position.Relative(1.0, 0.0)

        )
        binding.konfettiView.start(party2)

        val party3 = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 3, TimeUnit.SECONDS).perSecond(100),
            position = Position.Relative(0.0, 0.5)

        )
        binding.konfettiView.start(party3)
        val party4 = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 3, TimeUnit.SECONDS).perSecond(100),
            position = Position.Relative(1.0, 0.5)

        )
        binding.konfettiView.start(party4)
    }
}