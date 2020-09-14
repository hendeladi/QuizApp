package com.example.quizapp.Model

import androidx.lifecycle.LiveData

class QuizRepository(private val dao: TableDao) {

    val allQuizes: LiveData<List<Table>> = dao.getAll()

    suspend fun insert(table: Table){
        dao.insert(table)
    }

    suspend fun getAllNotLive(): List<Table>{
       return dao.getAllNotLive()
    }

    suspend fun delete(table: Table){
        dao.delete(table)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
    suspend fun getData(): LiveData<List<Table>>{
        return dao.getAll()
    }
}