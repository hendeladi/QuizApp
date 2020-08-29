package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun quizStartClicked(view: View){
        val takeQuizIntent = Intent(this,TakeQuizActivity::class.java)
        startActivity(takeQuizIntent)
    }

    fun addQuestionClicked(view: View){
        val addQuestionIntent = Intent(this,AddQuestionActivity::class.java)
        startActivity(addQuestionIntent)
    }

    fun viewQuestionClicked(view: View){

    }
}