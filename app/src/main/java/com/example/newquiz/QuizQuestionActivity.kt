package com.example.newquiz

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quiz.Constants


class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int =0

    private var progressBar : ProgressBar? = null
    private var pView: TextView? = null
    private var qView: TextView? = null
    private var img: ImageView? = null
    private var op1 : TextView? = null
    private var op2 : TextView? = null
    private var op3 : TextView? = null
    private var op4 : TextView? = null
    private var sub : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

       progressBar = findViewById(R.id.ProgressBar)
      pView = findViewById(R.id.tv_progress)
      qView = findViewById(R.id.tv_quest)
      img = findViewById(R.id.iv_Image)
      op1 = findViewById(R.id.optionOne)
      op2 = findViewById(R.id.optionTwo)
      op3 = findViewById(R.id.optionThree)
      op4 = findViewById(R.id.optionFour)
      sub = findViewById(R.id.btnSubmit)

      mQuestionList = Constants.getQuestion()
      setQuestion()
      defaultOptionView()
    }

    private fun setQuestion(){
        val question: Question=mQuestionList!![mCurrentPosition-1]

        img?.setImageResource(question.img)
        progressBar?.progress = mCurrentPosition
        pView?.text = "$mCurrentPosition / ${progressBar?.max}"
        qView?.text = question.questions
        op1?.text = question.optionOne
        op2?.text = question.optionTwo
        op3?.text = question.optionThree
        op4?.text = question.optionFour

        if (mCurrentPosition == mQuestionList!!.size){
            sub?.text= getString(R.string.finish)
        }else{
            sub?.text = getString(R.string.submit)
        }
    }


    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        op1?.let {
            options.add(0,it)
        }
        op2?.let {
            options.add(1,it)
        }
        op3?.let {
            options.add(2,it)
        }
        op4?.let {
            options.add(3,it)
        }

        for (item in options){
           item.setTextColor(Color.parseColor("#7A8089"))
        }
    }
    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}