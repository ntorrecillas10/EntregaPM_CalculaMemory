package com.example.entregapm_calculamemory

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.entregapm_calculamemory.databinding.ActivityResumeCalculaTronBinding

class Resume_CalculaTron : AppCompatActivity() {

    private lateinit var binding: ActivityResumeCalculaTronBinding
    private lateinit var botonVolver: AppCompatImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumeCalculaTronBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botonVolver = binding.volver

        botonVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}