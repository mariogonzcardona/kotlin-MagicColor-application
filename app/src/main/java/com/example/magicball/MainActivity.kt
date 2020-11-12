package com.example.magicball


import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonSetColor: Button
    private lateinit var phraseTextView: TextView
    val color="color"
    val texto="texto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.- Click listener
        //2.- Generar un color aleatorio
        //3.- Generar una frase aleatoria

        buttonSetColor= findViewById<Button>(R.id.pressMeButton)
        phraseTextView= findViewById<TextView>(R.id.phrase_textView)

        buttonSetColor?.setOnClickListener{
            val colors=resources.getIntArray(R.array.phrasesColors)
            val phrases=resources.getStringArray(R.array.phrases)

            val randomColor=colors.getRandomElement()
            phraseTextView.text=phrases.getRandomElement()
            phraseTextView.setTextColor(randomColor)
            buttonSetColor.setBackgroundColor(randomColor)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        with(savedInstanceState){
            phraseTextView.text=getString(texto)
            phraseTextView.setTextColor(getInt(color))
            buttonSetColor.setBackgroundColor(getInt(color))
        }
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(color,phraseTextView.currentTextColor)
        outState.putString(texto,phraseTextView.text.toString())
    }

    //    private fun getRandomNum(max:Int) = (Math.random()*max).toInt()
}
fun IntArray.getRandomElement():Int=this[(Math.random()* this.size).toInt()]
fun <T>Array<T>.getRandomElement():T=this[(Math.random()* this.size).toInt()]