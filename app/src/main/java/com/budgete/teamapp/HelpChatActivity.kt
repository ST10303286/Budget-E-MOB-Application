package com.budgete.teamapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HelpChatActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var messageInput: EditText
    private lateinit var chatMessages: LinearLayout
    private lateinit var videoCallIcon: View
    private lateinit var voiceCallIcon: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_chat)

        // Initialize UI elements
        messageInput = findViewById(R.id.messageInput)
        chatMessages = findViewById(R.id.chatMessages)
        videoCallIcon = findViewById(R.id.video_call_icon)
        voiceCallIcon = findViewById(R.id.voice_call_icon)

        // Set up click listeners for call icons
        videoCallIcon.setOnClickListener {
            showToast("Video Call Initiated")
        }

        voiceCallIcon.setOnClickListener {
            showToast("Voice Call Initiated")
        }

        // Set up the "Send" action (triggered by pressing Enter on the keyboard)
        messageInput.setOnEditorActionListener { _, _, _ ->
            sendMessage()
            true
        }
    }

    /**
     * Sends a message entered by the user.
     */
    private fun sendMessage() {
        val messageText = messageInput.text.toString().trim()

        if (messageText.isNotEmpty()) {
            // Add the outgoing message to the chat
            addMessageToChat(messageText, isOutgoing = true)

            // Simulate an incoming response after a short delay
            simulateIncomingResponse(messageText)

            // Clear the input field
            messageInput.text.clear()
        } else {
            showToast("Please enter a message.")
        }
    }

    /**
     * Adds a message to the chat view.
     */
    private fun addMessageToChat(message: String, isOutgoing: Boolean) {
        val textView = TextView(this).apply {
            text = message
            textSize = 14f
            setPadding(12, 12, 12, 12)

            if (isOutgoing) {
                background = getDrawable(R.drawable.outgoing_message_bg)
                setTextColor(getColor(android.R.color.white))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = android.view.Gravity.END
                    setMargins(0, 8, 0, 8)
                }
            } else {
                background = getDrawable(R.drawable.incoming_message_bg)
                setTextColor(getColor(android.R.color.black))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = android.view.Gravity.START
                    setMargins(0, 8, 0, 8)
                }
            }
        }

        // Add the message to the chatMessages container
        chatMessages.addView(textView)

        // Scroll to the bottom of the chat
        scrollChatToBottom()
    }

    /**
     * Simulates an incoming response after a short delay.
     */
    private fun simulateIncomingResponse(userMessage: String) {
        // Simulate a simple AI-like response
        val response = when {
            userMessage.contains("help", ignoreCase = true) -> "How can I assist you today?"
            userMessage.contains("issue", ignoreCase = true) -> "Please describe the issue in detail."
            else -> "Thank you for your message!"
        }

        // Post the response to the chat after a delay
        chatMessages.postDelayed({
            addMessageToChat(response, isOutgoing = false)
        }, 1000) // 1-second delay
    }

    /**
     * Scrolls the chat to the bottom.
     */
    private fun scrollChatToBottom() {
        chatMessages.post {
            chatMessages.scrollTo(0, chatMessages.bottom)
        }
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
}