package com.budgete.teamapp.helpers

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

object AuthHelper {

    private lateinit var auth: FirebaseAuth

    fun initAuth() {
        auth = FirebaseAuth.getInstance()
    }

    fun registerUser(context: Context, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Register failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun loginUser(context: Context, email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun logout() {
        auth.signOut()
    }
}
