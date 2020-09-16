package com.example.quizapp.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizapp.Model.QuizViewModel
import com.example.quizapp.Model.Table
import com.example.quizapp.R
import com.example.quizapp.utilities.EXTRA_QUIZ
import kotlinx.android.synthetic.main.activity_add_question.*
import kotlinx.android.synthetic.main.activity_edit_quiz.*

class EditQuizActivity : AppCompatActivity() {
    lateinit var originalQuiz: Table
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_quiz)

        val bundle = intent.getBundleExtra("Bundle")

        originalQuiz = bundle?.getParcelable<Table>(EXTRA_QUIZ)?: throw IllegalStateException("parcelable got null quiz")
        editQuizActivityQuestionText.setText(originalQuiz.question)
        editQuizActivityAnswerText.setText(originalQuiz.answer)

    }
    fun saveQuestionClicked(view: View){
        val question = editQuizActivityQuestionText.text.toString()
        val answer = editQuizActivityAnswerText.text.toString()
        val newQuiz = Table(question, answer)
        val model = QuizViewModel(application)
        model.delete(originalQuiz)
        model.insert(newQuiz)
        originalQuiz = newQuiz
        Toast.makeText(this, "Quiz was updated",Toast.LENGTH_SHORT).show()
    }
}