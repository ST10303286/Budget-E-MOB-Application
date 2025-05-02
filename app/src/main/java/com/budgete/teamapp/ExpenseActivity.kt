package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ExpenseActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var nameInput: EditText
    private lateinit var amountInput: EditText
    private lateinit var dateInput: EditText
    private lateinit var invoiceEditText: EditText
    private lateinit var categorySpinner: Spinner
    private lateinit var addExpenseButton: Button
    private lateinit var historyText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        // Initialize input fields and buttons
        nameInput = findViewById(R.id.nameInput)
        amountInput = findViewById(R.id.amountInput)
        dateInput = findViewById(R.id.dateInput)
        invoiceEditText = findViewById(R.id.invoiceEditText)
        categorySpinner = findViewById(R.id.categorySpinner)
        addExpenseButton = findViewById(R.id.addExpenseButton)
        historyText = findViewById(R.id.textHistory)

        // Set up category spinner
        val categories = listOf("Food", "Transport", "Entertainment", "Utilities", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        // Add Expense button logic
        addExpenseButton.setOnClickListener {
            handleAddExpense()
        }

        // Navigate to Transaction History
        historyText.setOnClickListener {
            val intent = Intent(this, TransactionHistoryActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Handles the logic when the "Add Expense" button is clicked.
     */
    private fun handleAddExpense() {
        val name = nameInput.text.toString().trim()
        val amount = amountInput.text.toString().trim()
        val date = dateInput.text.toString().trim()
        val invoice = invoiceEditText.text.toString().trim()
        val category = categorySpinner.selectedItem.toString()

        if (name.isEmpty()) {
            showToast("Please enter a name.")
            return
        }
        if (amount.isEmpty()) {
            showToast("Please enter an amount.")
            return
        }
        if (date.isEmpty()) {
            showToast("Please enter a date.")
            return
        }

        val amountValue = amount.toDoubleOrNull()
        if (amountValue == null || amountValue <= 0) {
            showToast("Please enter a valid amount.")
            return
        }

        val expenseDetails = """
            Name: $name
            Amount: R$amountValue
            Date: $date
            Invoice: ${if (invoice.isNotEmpty()) invoice else "N/A"}
            Category: $category
        """.trimIndent()

        showToast("Expense added successfully!\n$expenseDetails")
        clearInputFields()
    }

    /**
     * Shows a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    /**
     * Clears all input fields after submission.
     */
    private fun clearInputFields() {
        nameInput.text.clear()
        amountInput.text.clear()
        dateInput.text.clear()
        invoiceEditText.text.clear()
        categorySpinner.setSelection(0)
    }
}
