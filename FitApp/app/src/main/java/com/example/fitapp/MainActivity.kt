package com.example.fitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Attribute declaration
    private lateinit var laps_Button: Button
    private lateinit var refresh_button: Button
    lateinit var Image: ImageView
    private var lap = 0 //indicates the current lap
    private var maxlap= 20 //indicates the max of lap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Values
        laps_Button = findViewById(R.id.laps_Button)
        refresh_button = findViewById(R.id.refresh_button)
        Image = findViewById(R.id.transparent)

        //laps
        laps_Button.setOnClickListener{
            addLap()
            showImage()
        }
        //Refresh
         refresh_button.setOnClickListener {
             refreshAll()
         }
        laps_Button.setOnLongClickListener {
            Toast.makeText(this,"Faltan ${maxlap - lap} vueltas para el objetivo", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    //Show actuality
    private fun addLap(){
        //allow to add whenever it's less than the maximum
        if(lap <20){
            if(this.lap == (this.maxlap -1)) { //If lap
                lap++ //Add one lap every time
                //Congratulate on the first objective
                Toast.makeText(this@MainActivity, "¡Felicitaciones", Toast.LENGTH_SHORT).show()
            }else{
                this.lap++ //Add one lap every time
                //show missing laps
                Toast.makeText(this@MainActivity, "Faltan ${maxlap - lap} vueltas para el objetivo", Toast.LENGTH_SHORT).show()
            }
            conta_text.text = lap.toString()
        }
    }

    //Reset everything
    private fun refreshAll(){
        lap = 0
        conta_text.text = lap.toString()
        this.Image.setImageResource(R.drawable.transparente)
        Toast.makeText(this@MainActivity, "Vuelve a iniciar", Toast.LENGTH_SHORT).show()
    }
    //Showing showImage
    private fun showImage(){
        if(lap == 10){
            this.Image.setImageResource(R.drawable.medalla)
            Toast.makeText(this@MainActivity, "¡Felicitaciones", Toast.LENGTH_SHORT).show()
        }else if(lap == 20){
            this.Image.setImageResource(R.drawable.trofeo)
        }else{
            this.Image.setImageResource(R.drawable.transparente)
        }
    }
}
