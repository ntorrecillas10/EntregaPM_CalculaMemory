package com.example.entregapm_calculamemory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import com.example.entregapm_calculamemory.databinding.ActivityConfigCalculatronBinding
import com.google.android.material.textfield.TextInputEditText

class Config_CalculaTron : AppCompatActivity() {

    private lateinit var binding: ActivityConfigCalculatronBinding
    private lateinit var botonVolver: AppCompatImageButton
    private lateinit var cuentaAtras: TextInputEditText
    private lateinit var minimo: TextInputEditText
    private lateinit var maximo: TextInputEditText
    private lateinit var checkSuma: CheckBox
    private lateinit var checkResta: CheckBox
    private lateinit var checkMultiplicacion: CheckBox
    private lateinit var spinnerAnimaciones: Spinner
    private lateinit var botonGuardar: AppCompatButton




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigCalculatronBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botonVolver = binding.volver
        cuentaAtras = binding.cuentaAtras
        minimo = binding.minimoEdit
        maximo = binding.maximoEdit
        checkSuma = binding.checkSuma
        checkResta = binding.checkResta
        checkMultiplicacion = binding.checkMultiplicacion
        spinnerAnimaciones = binding.spinnerAnimaciones
        botonGuardar = binding.guardar
        val sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)




        val opciones = arrayOf("Sin animaciones", "Colores cambiantes", "Movimiento")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

        // Especifica el diseño a usar cuando se despliega la lista.
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Aplica el adaptador al Spinner.
                val spinner = findViewById<Spinner>(R.id.spinnerAnimaciones)
                spinner.adapter = adaptador








        botonGuardar.setOnClickListener {
            // Obtener los valores de los campos de texto
            val cuentaAtrasText = cuentaAtras.text.toString()

            var minimoText = minimo.text.toString()

            var maximoText = maximo.text.toString()

            if (minimoText.isEmpty()){
                minimoText = 1.toString()
            }
            if (maximoText.isEmpty()){
                maximoText = 20.toString()
            }

            if (minimoText>maximoText){
                minimo.error = "El minimo no puede ser mayor que el maximo"
                return@setOnClickListener
            }

            // Obtener los valores de los checkboxes
            val sumaChecked = checkSuma.isChecked
            val restaChecked = checkResta.isChecked
            val multiplicacionChecked = checkMultiplicacion.isChecked

            // Obtener el valor seleccionado en el Spinner
            val animacionSeleccionada = spinnerAnimaciones.selectedItem.toString()
            // Guardar los valores en SharedPreferences
            val editor = sharedPref.edit()
            editor.putString("cuentaAtras", cuentaAtrasText)
            editor.putString("minimo", minimoText)
            editor.putString("maximo", maximoText)
            editor.putBoolean("sumaChecked", sumaChecked)
            editor.putBoolean("restaChecked", restaChecked)
            editor.putBoolean("multiplicacionChecked", multiplicacionChecked)
            editor.putString("animacionSeleccionada", animacionSeleccionada)
            editor.apply()

            val intent = Intent(this, Game_Calculatron::class.java)
            startActivity(intent)

        }

        botonVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }

    override fun onResume() {
        super.onResume()

        //seteamos el contador a 60
        val sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("cuentaAtras", "60")
        editor.apply()


    }

}