package com.example.newquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.quiz.Constants
import com.example.quiz.Constants.USER_NAME


class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int =0
    private var mUserName: String? = null
    private var mCorrectAnswer: Int = 0



    private var progressBar : ProgressBar? = null
    private var pView: TextView? = null
    private var qView: TextView? = null
    private var img: ImageView? = null
    private var op1 : TextView? = null
    private var op2 : TextView? = null
    private var op3 : TextView? = null
    private var op4 : TextView? = null
    private var sub : TextView? = null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

      mUserName = intent.getStringExtra(Constants.USER_NAME)

      progressBar = findViewById(R.id.ProgressBar)
      pView = findViewById(R.id.tv_progress)
      qView = findViewById(R.id.tv_quest)
      img = findViewById(R.id.iv_Image)
      op1 = findViewById(R.id.optionOne)
      op2 = findViewById(R.id.optionTwo)
      op3 = findViewById(R.id.optionThree)
      op4 = findViewById(R.id.optionFour)
      sub = findViewById(R.id.btnSubmit)



        op1?.setOnClickListener(this)
        op2?.setOnClickListener(this)
        op3?.setOnClickListener(this)
        op4?.setOnClickListener(this)
        sub?.setOnClickListener(this)


      mQuestionList = Constants.getQuestion()
     setQuestion()

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        val question: Question=mQuestionList!![mCurrentPosition-1]
        defaultOptionView()
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

        for (option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
               option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv:TextView,selectionOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition = selectionOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.optionOne -> {
                op1?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.optionTwo -> {
                op2?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.optionThree -> {
                op3?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.optionFour -> {
                op4?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when {
                        mCurrentPosition<= mQuestionList!!.size->{
                            setQuestion()
                        }
                        else ->{
                            Toast.makeText(this, "You have made it till end", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTION,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else {
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctOption != mSelectedOptionPosition) {
                    answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctOption,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        sub?.text = "FINISH"
                    }else{
                        sub?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition =0
                }

            }
        }
    }
    private fun answerView (answer: Int,drawable:Int) {
        when (answer) {
            1 -> {
                op1?.background = ContextCompat.getDrawable(this, drawable)
            }

            2 -> {
                op2?.background = ContextCompat.getDrawable(this, drawable)
            }

            3 -> {
                op3?.background = ContextCompat.getDrawable(this, drawable)
            }

            4 -> {
                op4?.background = ContextCompat.getDrawable(this, drawable)
            }
        }
    }
}
