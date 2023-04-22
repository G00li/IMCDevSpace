package com.example.meuprimeiroprojeto

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        //recuperando o botão -> Basicamente chamando a função Botão que criei no activity.main.xml

        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)

        btnCalcular.setOnClickListener {
          //  val message : String = edtPeso.text.toString()

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()


            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {            //tratando a exceção. para que o programe so apresente um resultado se todos os campos forem preenchidos. (ou não estiverem vazios)
                val altura: Float = alturaStr.toFloat()
                val alturaFinal: Float = altura * altura
                val peso: Float = pesoStr.toFloat()
                val result: Float = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java)
                    //Ação que queremos que o programa faça ao clicar no botao.
                    .apply {
                        putExtra("EXTRA_RESULT", result)

                        /*Envia o valor que o Intent busca para a outra tela.
                Caso seja preciso chamar esse valor na outra tela,
                basta usar a Chave definida (EXTRA_RESULT) na outra tela.  */

                    }
                startActivity(intent) //Toma a atitude de trocar da tela 1 para a tela 2
            }
            else{                       //Caso algum campo esteja vazio.
                   Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()    //mostrar uma mensagem flutuante no app, caso algum campo nao seja preenchido.

            }
        }

    }
}