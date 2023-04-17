package com.example.meuprimeiroprojeto

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView

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

            val altura: Float = edtAltura.text.toString().toFloat()
            val alturaFinal: Float = altura * altura
            val peso: Float = edtPeso.text.toString().toFloat()
            val result: Float = peso/alturaFinal


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

    }
}