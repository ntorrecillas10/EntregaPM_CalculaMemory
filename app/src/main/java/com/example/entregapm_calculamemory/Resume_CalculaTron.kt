package com.example.entregapm_calculamemory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.entregapm_calculamemory.databinding.ActivityResumeCalculaTronBinding

class Resume_CalculaTron : AppCompatActivity() {

    private lateinit var binding: ActivityResumeCalculaTronBinding
    private lateinit var botonVolver: AppCompatImageButton
    private lateinit var acertadasAnterior: TextView
    private lateinit var falladasAnterior: TextView
    private lateinit var porcentajesAnterior: TextView
    private lateinit var acertadas: TextView
    private lateinit var falladas: TextView
    private lateinit var porcentajes: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumeCalculaTronBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acertadas = binding.acertadasFinalTexto
        falladas = binding.fallidasFinalTexto
        porcentajes = binding.porcentajesTexto
        acertadasAnterior = binding.acertadasAnteriorTexto
        falladasAnterior = binding.falladasAnteriorTexto
        porcentajesAnterior = binding.porcentajesAnteriorTexto


        //Recuperar los datos del intent
        val sharedPrefResume = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        val acertadasTexto = sharedPrefResume.getInt("acertadasEnviadas", 0)
        val falladasTexto = sharedPrefResume.getInt("falladasEnviadas", 0)


        //Mostrar los datos en las vistas correspondientes
        //Calcular el porcentaje de aciertos
        val totalIntentos = (acertadasTexto) + (falladasTexto)
        val porcentajeAciertos = if (totalIntentos > 0) {
            ((acertadasTexto) * 100) / totalIntentos
        } else {
            0
        }
        acertadas.text = "Acertadas: $acertadasTexto"
        falladas.text = "Falladas: $falladasTexto"
        porcentajes.text = "Porcentaje de aciertos: $porcentajeAciertos%"

        //Cuando se juegue una partida nueva, la información se pasa a partida Anterior y se setea la nueva en Total






        botonVolver = binding.volver

        botonVolver.setOnClickListener {
            val intent = Intent(this, Config_CalculaTron::class.java)
            startActivity(intent)
            if (acertadasTexto != 0 || falladasTexto != 0) {
                val sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
                val acertadasAnteriorValue = sharedPref.getInt("acertadasAnterior", 0)
                val falladasAnteriorValue = sharedPref.getInt("falladasAnterior", 0)
                val porcentajeAnteriorValue = sharedPref.getInt("porcentajeAnterior", 0)

                acertadasAnterior.text = "Acertadas Anterior: $acertadasAnteriorValue"
                falladasAnterior.text = "Falladas Anterior: $falladasAnteriorValue"
                porcentajesAnterior.text = "Porcentaje de aciertos Anterior: $porcentajeAnteriorValue%"
            }


        }


    }
}