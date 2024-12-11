package com.example.entregapm_calculamemory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
    private var contador: Long = 0


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
        val cuentaAtras = sharedPref.getInt("cuentaAtras", 0)
        val minimo = sharedPref.getInt("minimo", 0)
        val maximo = sharedPref.getInt("maximo", 0)
        val sumaCheck = sharedPref.getBoolean("sumaChecked", false)
        val restaCheck = sharedPref.getBoolean("restaChecked", false)
        val multiplicacionCheck = sharedPref.getBoolean("multiplicacionChecked", false)
        val animacionSeleccionada = sharedPref.getString("animacionSeleccionada", "")
        var arrayOperaciones = mutableListOf<String>()

        //La información recibida en cuentaAtras pasa a ser el numero de cuenta atras
        cuentaAtras.toString()
        cuentaAtrasText.text = cuentaAtras.toString()
        contador = cuentaAtras.toLong()
        minimo.toString()
        maximo.toString()
        animacionSeleccionada.toString()

        if (sumaCheck) {
            arrayOperaciones.add("+")
        }
        if (restaCheck) {
            arrayOperaciones.add("-")
        }
        if (multiplicacionCheck) {
            arrayOperaciones.add("*")
        }


        //Cada segundo que pasa se resta 1 a la cuenta atras
        ct = object : CountDownTimer(cuentaAtras.toLong() * 1000, 1000) {
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
        val num1 = (minimo..maximo).random()
        val num2 = (minimo..maximo).random()
        //Sacamos una operacion aleatoria de la lista de operaciones
        val operacion = arrayOperaciones.random()
        //Creamos una operacion aleatoria
        val operacionRandom = "$num1 $operacion $num2"
        val operacionAleatoria = operacionRandom
        //Mostramos la operacion aleatoria en la pantalla
        operacionActual.text = operacionAleatoria
        //Añadimos el resultado de la operacion a traves de los botones de numeros











        botonvolver.setOnClickListener {
            val intent = Intent(this, Config_CalculaTron::class.java)
            startActivity(intent)
        }


    }
}