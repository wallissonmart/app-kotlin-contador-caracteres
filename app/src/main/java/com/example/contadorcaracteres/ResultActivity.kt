package com.example.contadorcaracteres

import BaseActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class ResultActivity : BaseActivity() {

    private val text by lazy { intent.getStringExtra(TEXT)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupUI()
    }

    private fun setupUI() {
        val caracteresContados = text.replace("\\s".toRegex(), "").length
        findViewById<TextView>(R.id.textResult).text = caracteresContados.toString()
    }

    companion object {
        private const val TEXT = "text"

        fun createIntent(context: Context, text: String): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putExtra(TEXT, text)
            }
        }
    }
}