package br.com.albertoyoshiyuki.nacdado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    var vitorias = 0
    var derrotas = 0
    var empates = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btPlay.setOnClickListener{
            jogar()
        }

    }

    fun jogar(){

        val gerador = Random()
        val numeroPlayer = gerador.nextInt(6) + 1
        val numeroPC = gerador.nextInt(6) + 1

        configuraJogada(numeroPlayer, ivPlayer)
        configuraJogada(numeroPC, ivPC)

        if(numeroPlayer < numeroPC){
            derrotas++
            tvDerrotas.text = derrotas.toString()
        }
        else if(numeroPlayer > numeroPC){
            vitorias++
            tvVitorias.text = vitorias.toString()
        }
        else{
            empates++
            tvEmpates.text = empates.toString()
        }

    }

    fun configuraJogada(numero: Int, imageView: ImageView){
        when(numero){
            1-> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice1))
            2-> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice2))
            3-> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice3))
            4-> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice4))
            5-> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice5))
            6-> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice6))
        }
    }

}
