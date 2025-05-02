package com.budgete.teamapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(private var transactionList: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    // ViewHolder class to hold references to the views in the transaction card
    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textTransactionTitle)
        val subtitleTextView: TextView = itemView.findViewById(R.id.textTransactionSubtitle)
        val amountTextView: TextView = itemView.findViewById(R.id.textAmount)
    }

    // Inflate the layout for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    // Bind data to the views in the transaction card
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactionList[position]
        holder.titleTextView.text = transaction.title
        holder.subtitleTextView.text = transaction.subtitle
        holder.amountTextView.text = transaction.amount
    }

    // Return the number of items in the list
    override fun getItemCount(): Int {
        return transactionList.size
    }

    /**
     * Updates the adapter with a new list of transactions.
     */
    fun updateData(newList: List<Transaction>) {
        transactionList = newList
        notifyDataSetChanged()
    }
}