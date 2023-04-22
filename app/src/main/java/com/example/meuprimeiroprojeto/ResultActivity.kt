package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)  // Habilita o botão no app
        supportActionBar?.setDisplayHomeAsUpEnabled(true)   //Mostra o botão


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result: Float =  intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text=result.toString()

    /*.toString pq o intent é um float
     e precisa ser convertido em uma String
      para ser apresentado ao usuario
     */

    val classificacao = if (result < 18.5f){
            "ABAIXO DO PESO"
        }
        else if (result in 18.5f..24.9f){
            "NORMAL"
        }
        else if (result in 25f..29.9f){
            "SOBREPESO I"
        }
        else if (result in 30f..39.9f){
            "OBESIDADE II"
        }
        else{
            "OBESIDADE GRAVE III"
        }

    tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish() //Necessário encerrar a tela atual. Já que nao será mais preciso
        return super.onOptionsItemSelected(item) //Ação de trocar de tela.
    }
}