package com.example.newquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quiz.Constants

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.name)
        val tvScore:TextView = findViewById(R.id.score)
        val btn:TextView = findViewById(R.id.finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val totalQue = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text = "Your Score is $correctAns out of  $totalQue"
        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}