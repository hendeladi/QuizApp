package com.example.quizapp.Model

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuizViewModel(application: Application): AndroidViewModel(application) {

    private  val repository: QuizRepository

    val allQuizes: LiveData<List<Table>>

    init{
        val tableDao = DataBase.getDatabase(application).tableDao()
        repository = QuizRepository(tableDao)
        allQuizes = repository.allQuizes
    }

    fun insert(table:Table) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(table)
    }

    fun delete(table:Table) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(table)
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO){
        repository.deleteAll()
    }

    fun getQuizes(): LiveData<List<Table>>{
      return allQuizes
    }

}