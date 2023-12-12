package com.example.newquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start: TextView = findViewById(R.id.btnstart)
        val edit : EditText = findViewById(R.id.edittext)

        start.setOnClickListener(){
            if (edit.text.isEmpty()) {
                Toast.makeText(this, "Enter Name ", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra("user_name",edit.text.toString())
                startActivity(intent)
                finish()

            }

        }
    }
}