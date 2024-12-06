package com.example.entregapm_calculamemory

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
        val cuentaAtras = sharedPref.getString("cuentaAtras", "")
        val minimo = sharedPref.getString("minimo", "")
        val maximo = sharedPref.getString("maximo", "")
//        val sumaCheck = sharedPref.getString("sumaChecked", "")
//        val restaCheck = sharedPref.getString("restaChecked", "")
//        val multiplicacionCheck = sharedPref.getString("multiplicacionChecked", "")
        val animacionSeleccionada = sharedPref.getString("animacionSeleccionada", "")

        //La información recibida en cuentaAtras pasa a ser el numero de cuenta atras
        cuentaAtras.toString()
        cuentaAtrasText.text = cuentaAtras



        botonvolver.setOnClickListener {
            val intent = Intent(this, Config_CalculaTron::class.java)
            startActivity(intent)
        }


    }
}