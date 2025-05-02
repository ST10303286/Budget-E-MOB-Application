package com.budgete.teamapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CreatePlanActivity : AppCompatActivity() {

    private lateinit var editGoalTitle: EditText
    private lateinit var editTargetAmount: EditText
    private lateinit var editDeadline: EditText
    private lateinit var buttonSaveGoal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_plan)

        // Initialise views
        editGoalTitle = findViewById(R.id.editGoalTitle)
        editTargetAmount = findViewById(R.id.editTargetAmount)
        editDeadline = findViewById(R.id.editDeadline)
        buttonSaveGoal = findViewById(R.id.buttonSaveGoal)

        // Date picker trigger
        editDeadline.setOnClickListener {
            showDatePickerDialog()
        }

        // Save button click
        buttonSaveGoal.setOnClickListener {
            handleSaveGoal()
        }

        // (Optional) retrieve intent data
        val planType = intent.getStringExtra("PLAN_TYPE")
        planType?.let {
            // Use planType as needed
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                editDeadline.setText(formatter.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }

    private fun handleSaveGoal() {
        val title = editGoalTitle.text.toString().trim()
        val amountText = editTargetAmount.text.toString().trim()
        val deadline = editDeadline.text.toString().trim()

        if (title.isEmpty()) {
            showToast("Please enter a goal title.")
            return
        }

        val amount = amountText.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            showToast("Please enter a valid target amount.")
            return
        }

        if (deadline.isEmpty()) {
            showToast("Please select a goal deadline.")
            return
        }

        showToast("Goal Saved:\n$title\nTarget: R$amount\nDeadline: $deadline")

        // TODO: Save goal to RoomDB or Firebase here
        clearInputs()
    }

    private fun clearInputs() {
        editGoalTitle.text.clear()
        editTargetAmount.text.clear()
        editDeadline.text.clear()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
