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
        var cartasEnPulsacion = mutableListOf<Int>()
        var cartasAcertadas = mutableListOf<Int>()


        boton0.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton0.setImageResource(R.drawable.carta1_batman)
                boton0.isEnabled = false
                cartasEnPulsacion.add(valorboton0)
            }else {
                boton0.setImageResource(R.drawable.carta1_batman)
                boton0.isEnabled = false
                cartasEnPulsacion.add(valorboton0)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()

                } else {
                    boton0.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton0.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton1.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton1.setImageResource(R.drawable.carta1_batman)
                boton1.isEnabled = false
                cartasEnPulsacion.add(valorboton1)
            }else {
                boton1.setImageResource(R.drawable.carta1_batman)
                boton1.isEnabled = false
                cartasEnPulsacion.add(valorboton1)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()

                } else {
                    boton1.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton1.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton2.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton2.setImageResource(R.drawable.carta1_batman)
                boton2.isEnabled = false
                cartasEnPulsacion.add(valorboton2)
            }else {
                boton2.setImageResource(R.drawable.carta1_batman)
                boton2.isEnabled = false
                cartasEnPulsacion.add(valorboton2)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()

                } else {
                    boton2.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton2.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton3.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton3.setImageResource(R.drawable.carta1_batman)
                boton3.isEnabled = false
                cartasEnPulsacion.add(valorboton3)
            }else {
                boton3.setImageResource(R.drawable.carta1_batman)
                boton3.isEnabled = false
                cartasEnPulsacion.add(valorboton3)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()

                } else {
                    boton3.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton3.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton4.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton4.setImageResource(R.drawable.carta1_batman)
                boton4.isEnabled = false
                cartasEnPulsacion.add(valorboton4)
            }else {
                boton4.setImageResource(R.drawable.carta1_batman)
                boton4.isEnabled = false
                cartasEnPulsacion.add(valorboton4)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
                }else{
                    boton4.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton4.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton5.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton5.setImageResource(R.drawable.carta1_batman)
                boton5.isEnabled = false
                cartasEnPulsacion.add(valorboton5)
            } else {
                boton5.setImageResource(R.drawable.carta1_batman)
                boton5.isEnabled = false
                cartasEnPulsacion.add(valorboton5)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
                } else {
                    boton5.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton5.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton6.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton6.setImageResource(R.drawable.carta1_batman)
                boton6.isEnabled = false
                cartasEnPulsacion.add(valorboton6)
            } else {
                boton6.setImageResource(R.drawable.carta1_batman)
                boton6.isEnabled = false
                cartasEnPulsacion.add(valorboton6)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
                }else{
                    boton6.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton6.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton7.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton7.setImageResource(R.drawable.carta1_batman)
                boton7.isEnabled = false
                cartasEnPulsacion.add(valorboton7)
            } else {
                boton7.setImageResource(R.drawable.carta1_batman)
                boton7.isEnabled = false
                cartasEnPulsacion.add(valorboton7)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
                } else {
                    boton7.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton7.isEnabled = true
                    cartasEnPulsacion.clear()

                }
            }
        }
        boton8.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton8.setImageResource(R.drawable.carta1_batman)
                boton8.isEnabled = false
                cartasEnPulsacion.add(valorboton8)
            } else {
                boton8.setImageResource(R.drawable.carta1_batman)
                boton8.isEnabled = false
                cartasEnPulsacion.add(valorboton8)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
                } else {
                    boton8.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton8.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton9.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton9.setImageResource(R.drawable.carta1_batman)
                boton9.isEnabled = false
                cartasEnPulsacion.add(valorboton9)
            } else {
                boton9.setImageResource(R.drawable.carta1_batman)
                boton9.isEnabled = false
                cartasEnPulsacion.add(valorboton9)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
                } else {
                    boton9.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton9.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton10.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton10.setImageResource(R.drawable.carta1_batman)
                boton10.isEnabled = false
                cartasEnPulsacion.add(valorboton10)
            } else {
                boton10.setImageResource(R.drawable.carta1_batman)
                boton10.isEnabled = false
                cartasEnPulsacion.add(valorboton10)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
            }else{
                    boton10.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton10.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
        boton11.setOnClickListener {
            if (cartasEnPulsacion.size == 0) {
                boton11.setImageResource(R.drawable.carta1_batman)
                boton11.isEnabled = false
                cartasEnPulsacion.add(valorboton11)
            } else {
                boton11.setImageResource(R.drawable.carta1_batman)
                boton11.isEnabled = false
                cartasEnPulsacion.add(valorboton11)
                if (cartasEnPulsacion.size == 2 && cartasEnPulsacion[0] == cartasEnPulsacion[1]) {
                    cartasAcertadas.add(cartasEnPulsacion[0])
                    cartasAcertadas.add(cartasEnPulsacion[1])
                    cartasEnPulsacion.clear()
                }else{
                    boton11.setImageResource(R.drawable.anotaci_n_2024_12_02_180644)
                    boton11.isEnabled = true
                    cartasEnPulsacion.clear()
                }
            }
        }
    }
}
