package com.example.quizapp.Controller

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.Adapaters.QuizAdapter
import com.example.quizapp.Model.DataBase
import com.example.quizapp.Model.QuizViewModel
import com.example.quizapp.Model.Table
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    private var model: QuizViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        println("database is going to be read")

        val adapter = QuizAdapter(this)
        viewActivityQaList.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        viewActivityQaList.layoutManager =layoutManager
        viewActivityQaList.setHasFixedSize(true)

        model =  QuizViewModel(application)
        model?.allQuizes?.observe(this, Observer<List<Table>>{quizes ->
            adapter.setQuizes(quizes)
        })
    }

    fun deleteAllBtnClicked(view: View){
        model?.deleteAll()
        Toast.makeText(this,"Deleted all quizzes", Toast.LENGTH_SHORT).show()
    }
}