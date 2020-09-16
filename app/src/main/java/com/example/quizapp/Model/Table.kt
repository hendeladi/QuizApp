package com.example.quizapp.Model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "qa_table")
class Table (

    @PrimaryKey val question: String,
    @ColumnInfo(name = "answer") val answer: String?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: throw IllegalStateException("parcelable read null value as primary key"),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(answer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Table> {
        override fun createFromParcel(parcel: Parcel): Table {
            return Table(parcel)
        }

        override fun newArray(size: Int): Array<Table?> {
            return arrayOfNulls(size)
        }
    }

}