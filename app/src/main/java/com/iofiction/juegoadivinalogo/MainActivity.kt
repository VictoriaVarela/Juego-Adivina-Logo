package com.iofiction.juegoadivinalogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val Imagenes = arrayOf(R.drawable.cinemex,R.drawable.emperador,R.drawable.gatorade,R.drawable.spotify,R.drawable.teams,R.drawable.xbox,R.drawable.azteca,R.drawable.paypal,R.drawable.caesars,R.drawable.sonyericson,R.drawable.felicidades)
    val respuesta = arrayOf("cinemex","emperador","gatorade","spotify","teams","xbox","banco azteca","paypal","little caesars","sony ericson")
    var intentosRestantes : Int = 3
    var indice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
    }


    private fun setUI() {
        imagen.setImageResource(Imagenes[0])
        val Rcorrecta= Toast.makeText(applicationContext,"La Respuesta Es Correcta!", Toast.LENGTH_SHORT)
        val Rsinintentos= Toast.makeText(applicationContext,"Has Perdido No Te Quedan Mas Intentos", Toast.LENGTH_SHORT)



        enviar.setOnClickListener {
            if(palabra_ingresada.text.toString().toLowerCase() == respuesta[indice]) {
                palabra_ingresada.text.clear()
                Rcorrecta.show()

                if (indice >= Imagenes.size - 1)
                    indice = 0
                else
                    indice++                                       // cuando se presiona el botón, indice agrega 1 para inducir para que pueda mostrar la siguiente imagen en la matriz
                imagen.setImageResource(Imagenes[indice])

            } else {
                intentosRestantes--
                val Rincorrecta= Toast.makeText(applicationContext,"Respuesta Incorrecta Te Quedan $intentosRestantes Intentos Restantes", Toast.LENGTH_SHORT)

                palabra_ingresada.text.clear()
                if(intentosRestantes == 0) {
                    enviar.isEnabled = false
                    palabra_ingresada.isEnabled = false
                    Rsinintentos.show()
                } else {
                    Rincorrecta.show()
                }
            }
            if (indice==10){
                mensaje.text="Felicidades Lo has logrado"
                enviar.isEnabled = false
                palabra_ingresada.isEnabled = false
            }
        }


        reset.setOnClickListener {
            intentosRestantes = 3
            enviar.isEnabled = true
            palabra_ingresada.isEnabled = true
            palabra_ingresada.text.clear()
            imagen.setImageResource(Imagenes[0])
            respuesta[0]
            indice=0
            mensaje.text=""

        }

    }
}