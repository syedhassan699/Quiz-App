package com.example.quiz

import com.example.newquiz.Question
import com.example.newquiz.R

object Constants {
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_argentina,
            "America",
            "Afghanistan",
            "Iran",
            "Argentina",
            4
        )
        questionList.add(que1)
        val que2 = Question(
            2, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_australia,
            "America",
            "Australia",
            "Iran",
            "Argentina",
            2
        )
        questionList.add(que2)
        val que3 = Question(
            3, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_belgium,
            "America",
            "Afghanistan",
            "Belgium",
            "Argentina",
            3
        )
        questionList.add(que3)
        val que4 = Question(
            4, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_brazil,
            "brazil",
            "Afghanistan",
            "Iran",
            "Argentina",
            1
        )
        questionList.add(que4)

        val que5 = Question(
            5, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_fiji,
            "America",
            "fiji",
            "Iran",
            "Argentina",
            2
        )
        questionList.add(que5)

        val que6 = Question(
            6, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Afghanistan",
            "Iran",
            "Argentina",
            1
        )
        questionList.add(que6)

        val que7 = Question(
            7, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_india,
            "America",
            "Afghanistan",
            "India",
            "Argentina",
            3
        )
        questionList.add(que7)

        val que8 = Question(
            8, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Afghanistan",
            "Iran",
            "Argentina",
            1
        )
        questionList.add(que8)

        val que9 = Question(
            9, "This Flag Belongs to which Country?",
            R.drawable.ic_flag_of_germany,
            "America",
            "Germany",
            "Iran",
            "Argentina",
            2
        )
        questionList.add(que9)

        return questionList
    }

}