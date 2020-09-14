package com.example.quizapp.Adapaters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.Model.Table

import com.example.quizapp.R

class QuizAdapter(val context: Context): RecyclerView.Adapter<QuizAdapter.Holder>()  {
    private var tableList = emptyList<Table>()

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val questionTextView = itemView.findViewById<TextView>(R.id.qa_questionTextView)
        val answerTextView = itemView.findViewById<TextView>(R.id.qa_answerTextView)

        fun bindTable(table: Table?, context: Context){
            if(table == null){
                return
            }
            questionTextView?.text = table.question
            answerTextView?.text = table.answer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.qa_row,parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        if(tableList.isNullOrEmpty()){
            return 0
        }
        else{
            return tableList.count()
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var tableItem: Table?
        if(tableList.isNullOrEmpty()){
            tableItem = null
        }
        else{
            tableItem = tableList[position]
        }
        holder.bindTable(tableItem, context)
    }

    internal fun setQuizes(tables: List<Table>){
        this.tableList = tables
        notifyDataSetChanged()
    }
}