package com.example.imccalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularImc(view: View) {

        val textResultado = findViewById<TextView>(R.id.textResultado)
        val editPeso = findViewById<EditText>(R.id.editPeso)
        val editAltura = findViewById<EditText>(R.id.editAltura)

        val peso = editPeso.getText().toString()
        val altura = editAltura.getText().toString()

        val pesoConvertido = peso.toDouble()
        val alturaConvertido = altura.toDouble()

        val resultadoImc = pesoConvertido / (alturaConvertido * alturaConvertido)

        val imcFormatado = String.format("%.2f", resultadoImc)

        textResultado.setText("O seu IMC é: $imcFormatado")

    }
}