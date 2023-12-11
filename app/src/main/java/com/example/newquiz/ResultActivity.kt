package com.example.newquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quiz.Constants

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name: TextView = findViewById(R.id.name)
        val score:TextView = findViewById(R.id.score)
        val btn:TextView = findViewById(R.id.finish)

        name.text = intent.getStringExtra(Constants.USER_NAME)
        score.text = intent.getStringExtra("${Constants.CORRECT_ANSWERS}/${Constants.TOTAL_QUESTION}")
        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}