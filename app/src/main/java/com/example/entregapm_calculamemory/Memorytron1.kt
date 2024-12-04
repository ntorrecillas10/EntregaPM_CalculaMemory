package com.example.entregapm_calculamemory

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton

class Memorytron1 : AppCompatActivity() {
    private lateinit var boton1: AppCompatImageButton
    private lateinit var boton2: AppCompatImageButton
    private lateinit var boton3: AppCompatImageButton
    private lateinit var boton4: AppCompatImageButton
    private lateinit var boton5: AppCompatImageButton
    private lateinit var boton6: AppCompatImageButton
    private lateinit var boton7: AppCompatImageButton
    private lateinit var boton8: AppCompatImageButton
    private lateinit var boton9: AppCompatImageButton
    private lateinit var boton10: AppCompatImageButton
    private lateinit var boton11: AppCompatImageButton
    private lateinit var boton12: AppCompatImageButton
    private lateinit var botonVolver: AppCompatImageButton
    private lateinit var botonJugarDeNuevo: AppCompatImageButton
    private var cartaActualGirada: Int? = null
    private var cartaActualGirada2: Int? = null
    private lateinit var numVidas: TextView
    private lateinit var juegoGanado: TextView


    //Guardamos los valores de las cartas en un array
    val array = arrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)
    val arrayCartas = array.toList().shuffled().toIntArray()



    //Creamos un array de boleanos con 12 posiciones en false
    val arrayBooleanos = BooleanArray(12) { false }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorytron1)



        boton1 = findViewById(R.id.imagen0)
        boton2 = findViewById(R.id.imagen1)
        boton3 = findViewById(R.id.imagen2)
        boton4 = findViewById(R.id.imagen3)
        boton5 = findViewById(R.id.imagen4)
        boton6 = findViewById(R.id.imagen5)
        boton7 = findViewById(R.id.imagen6)
        boton8 = findViewById(R.id.imagen7)
        boton9 = findViewById(R.id.imagen8)
        boton10 = findViewById(R.id.imagen9)
        boton11 = findViewById(R.id.imagen10)
        boton12 = findViewById(R.id.imagen11)
        botonVolver = findViewById(R.id.volver)
        botonJugarDeNuevo = findViewById(R.id.jugarDeNuevo)
        numVidas = findViewById(R.id.numVidas)
        juegoGanado = findViewById(R.id.juegoGanado)

        boton1.setOnClickListener {
            handleCardClick(boton1, 0)
        }
        boton2.setOnClickListener {
            handleCardClick(boton2, 1)
        }
        boton3.setOnClickListener {
            handleCardClick(boton3, 2)
        }
        boton4.setOnClickListener {
            handleCardClick(boton4, 3)
        }
        boton5.setOnClickListener {
            handleCardClick(boton5, 4)
        }
        boton6.setOnClickListener {
            handleCardClick(boton6, 5)
        }
        boton7.setOnClickListener {
            handleCardClick(boton7, 6)
        }
        boton8.setOnClickListener {
            handleCardClick(boton8, 7)
        }
        boton9.setOnClickListener {
            handleCardClick(boton9, 8)
        }
        boton10.setOnClickListener {
            handleCardClick(boton10, 9)
        }
        boton11.setOnClickListener {
            handleCardClick(boton11, 10)
        }
        boton12.setOnClickListener {
            handleCardClick(boton12, 11)
        }

        botonVolver.setOnClickListener {
            finish()
        }
        botonJugarDeNuevo.setOnClickListener {
            recreate()
        }
    }

    private fun handleCardClick(button: AppCompatImageButton, value: Int) {
        if (cartaActualGirada == null) {
            // Primera carta girada
            cartaActualGirada = value
            button.setImageResource(when (arrayCartas[value]) {
                1 -> R.drawable.carta1_batman
                2 -> R.drawable.superman_carta
                3 -> R.drawable.joker2
                4 -> R.drawable.joker_carta
                5 -> R.drawable.hq2
                6 -> R.drawable.harleyquinn_carta
                else -> R.drawable.carta_dorso
            })
            button.isEnabled = false
        } else if (cartaActualGirada2 == null) {
            // Segunda carta girada
            cartaActualGirada2 = value
            button.setImageResource(when (arrayCartas[value]) {
                1 -> R.drawable.carta1_batman
                2 -> R.drawable.superman_carta
                3 -> R.drawable.joker2
                4 -> R.drawable.joker_carta
                5 -> R.drawable.hq2
                6 -> R.drawable.harleyquinn_carta
                else -> R.drawable.carta_dorso
            })
            button.isEnabled = false

            // Comprobar si las cartas coinciden
            if (arrayCartas[cartaActualGirada!!] == arrayCartas[cartaActualGirada2!!]) {
                // Las cartas coinciden
                arrayBooleanos[cartaActualGirada!!] = true
                arrayBooleanos[cartaActualGirada2!!] = true
                cartaActualGirada = null
                cartaActualGirada2 = null
            } else {
                // Las cartas no coinciden
                // Esperamos un momento antes de voltear las cartas de nuevo
                Handler(Looper.getMainLooper()).postDelayed({
                    // Aquí se voltea la carta que fue girada (tanto carta 1 como carta 2)
                    val carta1 = findViewById<AppCompatImageButton>(resources.getIdentifier("imagen$cartaActualGirada", "id", packageName))
                    val carta2 = findViewById<AppCompatImageButton>(resources.getIdentifier("imagen$cartaActualGirada2", "id", packageName))

                    // Volver a poner las cartas en su estado de dorso
                    carta1.setImageResource(R.drawable.carta_dorso)
                    carta1.isEnabled = true
                    carta2.setImageResource(R.drawable.carta_dorso)
                    carta2.isEnabled = true
                    numVidas.text = (numVidas.text.toString().toInt() - 1).toString()
                        if (numVidas.text.toString().toInt() == 0) {
                            if (numVidas.text.toString().toInt() == 0) {
                            juegoGanado.text = "Has perdido"
                            numVidas.text = "!!!"
                            //Deshabilitamos todas las cartas
                            for (i in 0..11) {
                                val carta = findViewById<AppCompatImageButton>(resources.getIdentifier("imagen$i", "id", packageName))
                                carta.isEnabled = false
                            }


                            // Esperar 2 segundos antes de recrear la actividad para mostrar el mensaje
                            Handler(Looper.getMainLooper()).postDelayed({
                                recreate()
                            }, 2000) // 2 segundos de espera
                        }
                    }

                    cartaActualGirada = null
                    cartaActualGirada2 = null
                }, 1000)  // 1 segundo de retraso antes de restaurar las cartas
            }
        }

        // Verificar si el juego ha terminado
        if (arrayBooleanos.all { it }) {
            juegoGanado.text = "Has ganado"
            numVidas.text = "!!!"
        }
    }


}
