package com.example.entregapm_calculamemory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
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
            val cuentaAtrasText = cuentaAtras.text?.trimStart('0').toString()

            //Si el contador es 0 no se puede jugar
            if (cuentaAtrasText.contains("0") && cuentaAtrasText< 1.toString()){
                cuentaAtras.error = "El contador no puede ser menor a 1"
                return@setOnClickListener
            }



            var maximoText = maximo.text?.toString()
            if (maximo.text.toString().length>1 && maximo.text.toString().first()== '0') {
                maximoText = maximo.text?.removePrefix("0").toString()
            } else if (maximoText!!.isEmpty()){
                maximoText = "20"
            }
            var minimoText = minimo.text?.toString()
            if (minimo.text.toString().length>1 && minimo.text.toString().first()== '0') {
                minimoText = minimo.text?.removePrefix("0").toString()
            } else if (minimoText!!.isEmpty()){
                minimoText = "1"
            }

            //Si el maximo es 0 no se puede jugar
            if (maximoText.contains("0") && maximoText< 1.toString()){
                maximo.error = "El maximo no puede ser 0"
                return@setOnClickListener
            }

            if (minimoText.contains(".") || maximoText.contains(".") || cuentaAtrasText.contains(".") || cuentaAtrasText.contains(",") || minimoText.contains(",") || maximoText.contains(",")){
                Toast.makeText(this, "Las operaciones no pueden contener decimales", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (minimoText>maximoText){
                minimo.error = "El minimo no puede ser mayor que el maximo"
                return@setOnClickListener
            }

            // Obtener los valores de los checkboxes
            val sumaChecked = checkSuma.isChecked
            val restaChecked = checkResta.isChecked
            val multiplicacionChecked = checkMultiplicacion.isChecked

            //Si no se ha seleccionado ninguna operacion no se puede jugar
            if (!sumaChecked && !restaChecked && !multiplicacionChecked){
                Toast.makeText(this, "Debes seleccionar al menos una operacion", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

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