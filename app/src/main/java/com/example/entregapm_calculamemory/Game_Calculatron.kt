package com.example.entregapm_calculamemory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import com.example.entregapm_calculamemory.databinding.ActivityGameCalculatronBinding

class Game_Calculatron : AppCompatActivity() {

    private lateinit var binding: ActivityGameCalculatronBinding
    private lateinit var botonvolver: AppCompatImageButton
    private lateinit var acertadasText: TextView
    private lateinit var falladasText: TextView
    private lateinit var cuentaAtrasText: TextView
    private lateinit var resultadoAnterior: TextView
    private lateinit var operacionActual: TextView
    private lateinit var resultadoSiguiente: TextView
    private lateinit var botonnum1: AppCompatButton
    private lateinit var botonnum2: AppCompatButton
    private lateinit var botonnum3: AppCompatButton
    private lateinit var botonnum4: AppCompatButton
    private lateinit var botonnum5: AppCompatButton
    private lateinit var botonnum6: AppCompatButton
    private lateinit var botonnum7: AppCompatButton
    private lateinit var botonnum8: AppCompatButton
    private lateinit var botonnum9: AppCompatButton
    private lateinit var botonnum0: AppCompatButton
    private lateinit var botonReiniciarOperacion: AppCompatButton
    private lateinit var botonEliminar: AppCompatButton
    private lateinit var botonIgual: AppCompatButton
    private lateinit var ct: CountDownTimer
    private var contador: Long = 60
    private var numeroMinimo: Int = 1
    private var numeroMaximo: Int = 20
    private var userInput = ""
    private var acertadas = 0
    private var falladas = 0

    private var num1 = (numeroMinimo..numeroMaximo).random()
    private var num2 = (numeroMinimo..numeroMaximo).random()
    private var num3 = (numeroMinimo..numeroMaximo).random()
    private var num4 = (numeroMinimo..numeroMaximo).random()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameCalculatronBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botonvolver = binding.volver
        acertadasText = binding.acertadasCuenta
        falladasText = binding.falladasCuenta
        cuentaAtrasText = binding.cuentaAtrasgc
        resultadoAnterior = binding.resultadoAnterior
        operacionActual = binding.operacionActual
        resultadoSiguiente = binding.resultadoSiguiente
        botonnum1 = binding.botonNum1
        botonnum2 = binding.botonNum2
        botonnum3 = binding.botonNum3
        botonnum4 = binding.botonNum4
        botonnum5 = binding.botonNum5
        botonnum6 = binding.botonNum6
        botonnum7 = binding.botonNum7
        botonnum8 = binding.botonNum8
        botonnum9 = binding.botonNum9
        botonnum0 = binding.botonNum0
        botonReiniciarOperacion = binding.botonReinicarOperacion
        botonEliminar = binding.botonEliminarUltimoDigito
        botonIgual = binding.botonIgual


        val sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        val cuentaAtras = sharedPref.getString("cuentaAtras", "60") // Default to 60 if not found
        contador = if (cuentaAtras.isNullOrEmpty()) {
            60
        } else {
            cuentaAtras.toLong()
        }
        val minimo = sharedPref.getString("minimo", "1")
        numeroMinimo = if (minimo.isNullOrEmpty()) {
            1
        } else {
            minimo.toInt()
        }
        val maximo = sharedPref.getString("maximo", "20")
        numeroMaximo = if (maximo.isNullOrEmpty()) {
            20
        } else {
            maximo.toInt()
        }
        val sumaCheck = sharedPref.getBoolean("sumaChecked", true)
        val restaCheck = sharedPref.getBoolean("restaChecked", true)
        val multiplicacionCheck = sharedPref.getBoolean("multiplicacionChecked", false)
        val animacionSeleccionada = sharedPref.getString("animacionSeleccionada", "")
        var arrayOperaciones = mutableListOf<String>()

        //La información recibida en cuentaAtras pasa a ser el numero de cuenta atras
        cuentaAtras.toString()
        cuentaAtrasText.text = cuentaAtras
        animacionSeleccionada.toString()
        arrayOperaciones.add("+")
        arrayOperaciones.add("-")

        if (!sumaCheck) {
            arrayOperaciones.remove("+")
        }
        if (!restaCheck) {
            arrayOperaciones.remove("-")
        }
        if (multiplicacionCheck) {
            arrayOperaciones.add("*")
        }


        //Cada segundo que pasa se resta 1 a la cuenta atras
        ct = object : CountDownTimer(contador * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                contador--
                cuentaAtrasText.text = contador.toString()
            }

            override fun onFinish() {
                val intent = Intent(this@Game_Calculatron, Resume_CalculaTron::class.java)
                startActivity(intent)
            }
        }.start()

        //Sacamos dos numeros randoms entre el numero minimo y el numero maximo
        val operacion = arrayOperaciones.random()
        //Creamos una operacion aleatoria
        val operacionRandom = if (num1 > num2) {
            "$num1 $operacion $num2 ="
        } else {
            "$num2 $operacion $num1 ="
        }
        val operacionRandom2 = if (num3 > num4) {
            "$num3 $operacion $num4 ="
        } else {
            "$num4 $operacion $num3 ="
        }

        val operacionAleatoria = operacionRandom
        val operacionAleatoria2 = operacionRandom2
        //Mostramos la operacion aleatoria en la pantalla
        operacionActual.text = operacionAleatoria
        resultadoSiguiente.text = operacionAleatoria2

        //Añadimos el resultado de la operacion a traves de los botones de numeros


        configurarBotonNumero(botonnum1, "1")
        configurarBotonNumero(botonnum2, "2")
        configurarBotonNumero(botonnum3, "3")
        configurarBotonNumero(botonnum4, "4")
        configurarBotonNumero(botonnum5, "5")
        configurarBotonNumero(botonnum6, "6")
        configurarBotonNumero(botonnum7, "7")
        configurarBotonNumero(botonnum8, "8")
        configurarBotonNumero(botonnum9, "9")
        configurarBotonNumero(botonnum0, "0")

        botonIgual.setOnClickListener {
            var resultado = operacionActual.text.toString().split("=")
            val parts = operacionActual.text.toString().split(" ")
            val num1 = parts[0].toIntOrNull()
            val num2 = parts[2].toIntOrNull()
            val operator = parts[1]
            var expectedResult: Int? = null

            if (num1 != null && num2 != null) {
                expectedResult = when (operator) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    "/" -> num1 / num2 // Handle division by zero if needed
                    else -> null // Handle invalid operators
                }
            }

                //Si el resultado de la operacion es igual al resultado de la operacion aleatoria sumamos uno a la cuenta de aciertos
            if (resultado[1].toInt() == expectedResult) {
                acertadas++
                acertadasText.text = "Acertadas: $acertadas"
            } else {
                falladas++
                falladasText.text = "Falladas: $falladas"
                println(resultado[1].toInt())
            }
            //La cuenta actual se coloca en el resultado anterior
            resultadoAnterior.text = operacionActual.text.toString()
            //La cuenta siguiente se coloca en la operacion Actual
            operacionActual.text = resultadoSiguiente.text
            var numerito1 = (numeroMinimo..<numeroMaximo).random()
            var numerito2 = (numeroMinimo..<numeroMaximo).random()
            var operacioncita = arrayOperaciones.random()
            var operacionAleatoriaNueva = if (numerito1 > numerito2) {
                "$numerito1 $operacioncita $numerito2 ="
            } else {
                "$numerito2 $operacioncita $numerito1 ="
            }
            resultadoSiguiente.text = operacionAleatoriaNueva
            num3 = (numeroMinimo..<numeroMaximo).random()
            num4 = (numeroMinimo..<numeroMaximo).random()

        }











        botonvolver.setOnClickListener {
            finish()
        }


    }

    private fun configurarBotonNumero(boton: Button, numero: String) {
        boton.setOnClickListener {
            userInput = numero
            operacionActual.text = operacionActual.text.toString() + userInput
            userInput = ""
        }
    }

    override fun onStop() {
        super.onStop()
        ct.cancel()
    }
}