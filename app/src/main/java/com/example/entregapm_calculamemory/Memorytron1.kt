package com.example.entregapm_calculamemory

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Memorytron1 : AppCompatActivity() {
    private lateinit var boton0: AppCompatImageButton
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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorytron1)

        boton0 = findViewById(R.id.imagen00)
        boton1 = findViewById(R.id.imagen01)
        boton2 = findViewById(R.id.imagen02)
        boton3 = findViewById(R.id.imagen10)
        boton4 = findViewById(R.id.imagen11)
        boton5 = findViewById(R.id.imagen12)
        boton6 = findViewById(R.id.imagen20)
        boton7 = findViewById(R.id.imagen21)
        boton8 = findViewById(R.id.imagen22)
        boton9 = findViewById(R.id.imagen30)
        boton10 = findViewById(R.id.imagen31)
        boton11 = findViewById(R.id.imagen32)

        //Guardamos si la carta esta dada la vuelta en un array
        val cartasVueltas = arrayOf(false, false, false, false, false, false, false, false, false, false, false, false)
        //Guardamos los valores de las cartas en un array
        val cartasValues = arrayOf(0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5)

        val valorboton0 = cartasValues[0]
        val valorboton1 = cartasValues[1]
        val valorboton2 = cartasValues[2]
        val valorboton3 = cartasValues[3]
        val valorboton4 = cartasValues[4]
        val valorboton5 = cartasValues[5]
        val valorboton6 = cartasValues[6]
        val valorboton7 = cartasValues[7]
        val valorboton8 = cartasValues[8]
        val valorboton9 = cartasValues[9]
        val valorboton10 = cartasValues[10]
        val valorboton11 = cartasValues[11]

        val cartaDefecto = R.drawable.anotaci_n_2024_12_02_180644
        val cartabatman = R.drawable.carta1_batman

        boton0.setOnClickListener {
            boton0.setImageResource(cartabatman)
            //Si hay una carta dada la vuelta y coincide con el mismo value, se dejan dadas la vuelta, si no, se dan la vuelta al paso de dos segundos
            if (cartasVueltas[0] && valorboton0 == valorboton1) {
                cartasVueltas[0] = true
                cartasVueltas[1] = true
            } else {
                cartasVueltas[0] = false
                cartasVueltas[1] = false
                boton0.setImageResource(cartaDefecto)
                boton1.setImageResource(cartaDefecto)

            }
        }


    }
}