package com.example.quizapp.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.Adapaters.QuizAdapter
import com.example.quizapp.Model.DataBase
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        println("database is going to be read")
        val db = DataBase.getDatabase(application).tableDao().getAll()
        if(db == null){
            println("sdfsdfdsfdsfdsfdsfdsfsdfsdfdsfdsfdsf")
        }
        val adapter = QuizAdapter(this, db)
        viewActivityQaList.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        viewActivityQaList.layoutManager =layoutManager
        viewActivityQaList.setHasFixedSize(true)
    }
}