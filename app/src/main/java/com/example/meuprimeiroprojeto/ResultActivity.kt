package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result: Float =  intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text=result.toString()

    /*.toString pq o intent é um float
     e precisa ser convertido em uma String
      para ser apresentado ao usuario
     */

    var classificacao ="Classificação: "

        if(result<18.5f){
            classificacao +="ABAIXO DO PESO"
        }
        else if(result >= 18.5f && result <= 24.9){
            classificacao="NORMAL"
        }
        else if (result >=25f && result<=29.9f){
            classificacao +="SOBREPESO I"

        }
        else if(result >=30f && result <=39.9f){
            classificacao += "OBESIDADE II"
        }
        else{
            classificacao +="OBESIDADE GRAVE III"
        }

    tvClassificacao.text = classificacao
    }
}