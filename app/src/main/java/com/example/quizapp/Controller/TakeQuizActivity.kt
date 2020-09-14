package com.example.quizapp.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.quizapp.Model.QuizViewModel
import com.example.quizapp.Model.Table
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_take_quiz.*
import java.util.*

class TakeQuizActivity : AppCompatActivity() {

    private val random = Random()

    private var allQuizes: List<Table> = emptyList()
    private var chosenQuiz: Table? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val model = QuizViewModel(application)
        model?.allQuizes?.observe(this, Observer<List<Table>>{quizes ->
            allQuizes = quizes
            if(allQuizes.size > 0){
                if(chosenQuiz == null){
                    val quizNum = random.nextInt(allQuizes.size)
                    chosenQuiz = allQuizes[quizNum]
                }
                takeQuizActivityQuestionText.text = "Question: " + chosenQuiz?.question
                takeQuizActivityAnswerText.text = "Answer :"
            }

        })
        setContentView(R.layout.activity_take_quiz)

        if(allQuizes.size == 0){
            Toast.makeText(this, "You haven't added any quizzes yet", Toast.LENGTH_LONG).show()
        }
    }

    fun setText(){
        if(allQuizes.size == 0){
            return
        }
        val quizNum = random.nextInt(allQuizes.size)
        chosenQuiz = allQuizes[quizNum]
        takeQuizActivityQuestionText.text = "Question :" + chosenQuiz?.question
        takeQuizActivityAnswerText.text = "Answer :"
    }

    fun showAnswerClicked(view: View){
        if(chosenQuiz != null){
            takeQuizActivityAnswerText.text = "Answer: " + chosenQuiz?.answer
        }
    }

    fun nextQuestionClicked(view: View){
        setText()
    }
}