package com.example.quizapp.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TableDao {
    @Query("SELECT * from qa_table")
    fun getAll(): List<Table>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(table: Table)

    @Query("DELETE FROM qa_table")
    fun deleteAll()
}