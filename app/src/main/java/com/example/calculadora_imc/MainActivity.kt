package com.example.calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
    private fun setListeners() {
        altura?.doAfterTextChanged { resultado ->
            Toast.makeText(this, resultado.toString(), Toast.LENGTH_SHORT).show()
        }
        peso?.doAfterTextChanged { resultado ->
            Toast.makeText(this, resultado.toString(), Toast.LENGTH_SHORT).show()
    }
        calcular.setOnClickListener {
            calcularIMC(peso.text.toString(), altura.text.toString())
        }
    }
        private fun calcularIMC(altura:String, peso:String){
            val altura = altura.toFloatOrNull()
            val peso = peso.toFloatOrNull()

            if (peso != null && altura != null) {
                val imc = altura / (peso * peso)
                textView.text = "O seu IMC é: \n%.2f".format(imc) //%.2f usado para deixar apenas com duas casas decimais
            }

        }
}
