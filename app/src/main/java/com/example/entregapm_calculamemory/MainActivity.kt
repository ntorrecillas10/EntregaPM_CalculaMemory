package com.example.entregapm_calculamemory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var botonMemory: AppCompatButton
    private lateinit var botonCalcula: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonMemory = findViewById(R.id.Memorytronboton)
        botonCalcula = findViewById(R.id.Calculatronboton)

        botonMemory.setOnClickListener {
            val intent = Intent(this, Memorytron1::class.java)
            startActivity(intent)
        }

        botonCalcula.setOnClickListener {
            val intent = Intent(this, Config_CalculaTron::class.java)
            startActivity(intent)
        }




    }
}