package com.example.quizapp.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.Model.DataBase
import com.example.quizapp.Model.Table
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_add_question.*

class AddQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
    }

    fun addQuestionClicked(view: View){
        val question = addQuestionActivityQuestionText.text.toString()
        val answer = addQuestionActivityAnswerText.text.toString()
        val table = Table(question, answer)
        val db = DataBase.getDatabase(application).tableDao().insert(table)

        addQuestionActivityQuestionText.text.clear()
        addQuestionActivityAnswerText.text.clear()
    }

}