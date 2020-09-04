package com.example.quizapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "qa_table")
class Table (

    @PrimaryKey val question: String,
    @ColumnInfo(name = "answer") val answer: String?
)