package com.budgete.teamapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TransactionHistoryActivity : AppCompatActivity() {

    private lateinit var transactionRecyclerView: RecyclerView
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_history)

        // Initialize RecyclerView
        transactionRecyclerView = findViewById(R.id.transactionRecyclerView)
        transactionRecyclerView.layoutManager = LinearLayoutManager(this)

        // Simulated transaction data
        val transactionList: List<Transaction> = listOf(
            Transaction("Groceries", "Oct 1, 2023", "-$50.00"),
            Transaction("Transportation", "Oct 2, 2023", "-$15.00"),
            Transaction("Salary", "Oct 3, 2023", "+$2000.00")
        )

        // Set up adapter
        transactionAdapter = TransactionAdapter(transactionList)
        transactionRecyclerView.adapter = transactionAdapter
    }
}