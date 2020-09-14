package com.example.quizapp.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TableDao {
    @Query("SELECT * from qa_table")
    fun getAll(): LiveData<List<Table>>

    @Query("SELECT * from qa_table")
    suspend fun getAllNotLive(): List<Table>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(table: Table)

    @Query("DELETE FROM qa_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(table: Table)
}