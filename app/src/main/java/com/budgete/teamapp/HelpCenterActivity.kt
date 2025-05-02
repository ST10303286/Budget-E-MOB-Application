package com.budgete.teamapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HelpCenterActivity : AppCompatActivity() {

    private lateinit var faqTab: TextView
    private lateinit var contactUsTab: TextView
    private lateinit var contactOptions: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_center)

        faqTab = findViewById(R.id.faqTab)
        contactUsTab = findViewById(R.id.contactUsTab)
        contactOptions = findViewById(R.id.contactOptions)

        faqTab.setOnClickListener { switchToFAQ() }
        contactUsTab.setOnClickListener { switchToContactUs() }

        setupContactOptionListeners()
    }

    private fun switchToFAQ() {
        faqTab.setTextColor(getColor(android.R.color.black))
        contactUsTab.setTextColor(getColor(R.color.inactive_tab_color))
        contactOptions.visibility = LinearLayout.GONE
        showToast("Switched to FAQ section")
    }

    private fun switchToContactUs() {
        faqTab.setTextColor(getColor(R.color.inactive_tab_color))
        contactUsTab.setTextColor(getColor(R.color.active_tab_color))
        contactOptions.visibility = LinearLayout.VISIBLE
        showToast("Switched to Contact Us section")
    }

    private fun setupContactOptionListeners() {
        findViewById<LinearLayout>(R.id.customerServiceRow).setOnClickListener {
            startActivity(Intent(this, HelpChatActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.whatsappRow).setOnClickListener {
            openWhatsApp("1234567890")
        }

        findViewById<LinearLayout>(R.id.facebookRow).setOnClickListener {
            openWebPage("https://www.facebook.com/example")
        }

        findViewById<LinearLayout>(R.id.twitterRow).setOnClickListener {
            openWebPage("https://twitter.com/example")
        }

        findViewById<LinearLayout>(R.id.instagramRow).setOnClickListener {
            openWebPage("https://www.instagram.com/example")
        }
    }

    private fun openWebPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun openWhatsApp(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://wa.me/$phoneNumber")
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
