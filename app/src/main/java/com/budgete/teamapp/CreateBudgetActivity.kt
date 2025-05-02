package com.budgete.teamapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CreateBudgetActivity : AppCompatActivity() {

    // Declare UI elements as global variables
    private lateinit var spinnerBudgetType: Spinner
    private lateinit var startDateInput: EditText
    private lateinit var amountInput: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var endDateInput: EditText
    private lateinit var buttonCreateBudget: Button

    // Calendar instances for date selection
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_budget) // Set the layout for this activity

        // Initialize UI elements
        spinnerBudgetType = findViewById(R.id.spinnerBudgetType)
        startDateInput = findViewById(R.id.startDateInput)
        amountInput = findViewById(R.id.amountInput)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        endDateInput = findViewById(R.id.endDateInput)
        buttonCreateBudget = findViewById(R.id.buttonCreateBudget)

        // Populate Spinners with predefined options
        populateSpinners()

        // Set up date pickers for start and end dates
        setupDatePicker(startDateInput)
        setupDatePicker(endDateInput)

        // Set up the button click listener
        buttonCreateBudget.setOnClickListener {
            handleCreateBudget()
        }
    }

    /**
     * Populates the Spinners with predefined options.
     */
    private fun populateSpinners() {
        // Budget Type Spinner
        val budgetTypes = listOf("Monthly", "Weekly", "Yearly", "Custom")
        val budgetTypeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, budgetTypes)
        budgetTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBudgetType.adapter = budgetTypeAdapter

        // Category Spinner
        val categories = listOf("Food", "Transport", "Entertainment", "Utilities", "Other")
        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = categoryAdapter
    }

    /**
     * Sets up a DatePickerDialog for an EditText field.
     */
    private fun setupDatePicker(editText: EditText) {
        editText.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Show DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    calendar.set(Calendar.YEAR, selectedYear)
                    calendar.set(Calendar.MONTH, selectedMonth)
                    calendar.set(Calendar.DAY_OF_MONTH, selectedDay)

                    // Format the selected date
                    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    editText.setText(sdf.format(calendar.time))
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }

    /**
     * Handles the logic when the "Create Budget" button is clicked.
     */
    private fun handleCreateBudget() {
        // Retrieve user input
        val budgetType = spinnerBudgetType.selectedItem.toString()
        val startDate = startDateInput.text.toString().trim()
        val amount = amountInput.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()
        val endDate = endDateInput.text.toString().trim()

        // Validate input fields
        if (startDate.isEmpty()) {
            showToast("Please select a start date.")
            return
        }
        if (endDate.isEmpty()) {
            showToast("Please select an end date.")
            return
        }
        if (amount.isEmpty()) {
            showToast("Please enter an amount.")
            return
        }

        // Convert amount to a numeric value
        val amountValue = amount.toDoubleOrNull()
        if (amountValue == null || amountValue <= 0) {
            showToast("Please enter a valid amount.")
            return
        }

        // If all validations pass, process the budget creation
        val budgetDetails = """
            Budget Type: $budgetType
            Start Date: $startDate
            End Date: $endDate
            Amount: $$amountValue
            Category: $category
        """.trimIndent()

        // Display the budget details (for now, using a Toast)
        showToast("Budget Created:\n$budgetDetails")

        // Clear input fields after successful submission
        clearInputFields()
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    /**
     * Clears all input fields after successful submission.
     */
    private fun clearInputFields() {
        spinnerBudgetType.setSelection(0) // Reset Spinner to the first item
        startDateInput.text.clear()
        amountInput.text.clear()
        spinnerCategory.setSelection(0) // Reset Spinner to the first item
        endDateInput.text.clear()
    }
}