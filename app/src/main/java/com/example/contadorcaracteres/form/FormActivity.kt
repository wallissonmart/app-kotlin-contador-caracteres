package com.example.contadorcaracteres.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.example.contadorcaracteres.R
import com.example.contadorcaracteres.ResultActivity
import com.google.android.material.textfield.TextInputEditText

class FormActivity : AppCompatActivity() {

    private val viewModel: FormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        setupInputChangeListener()
        setupButtonClickedListener()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.onUserSentForm.observe(this, Observer {
            startActivity(ResultActivity.createIntent(this, it))
        })
    }

    private fun setupButtonClickedListener() {
        val buttonSend = findViewById<Button>(R.id.buttonEnviar)

        buttonSend.setOnClickListener {
            viewModel.onUserRequestedToSendForm()
        }
    }

    private fun setupInputChangeListener() {
        val textInputEdit = findViewById<TextInputEditText>(R.id.textInputEdit)

        textInputEdit.addTextChangedListener {
            viewModel.onUserChangedInput(it.toString())
        }
    }
}
