package com.captaindeer.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operation: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cero.setOnClickListener { numPress("0") }
        uno.setOnClickListener { numPress("1") }
        dos.setOnClickListener { numPress("2") }
        tres.setOnClickListener { numPress("3") }
        cuatro.setOnClickListener { numPress("4") }
        cinco.setOnClickListener { numPress("5") }
        seis.setOnClickListener { numPress("6") }
        siete.setOnClickListener { numPress("7") }
        ocho.setOnClickListener { numPress("8") }
        nueve.setOnClickListener { numPress("9") }
        punto.setOnClickListener { numPress(".") }


        mas.setOnClickListener { operationPressed(SUMA) }
        menos.setOnClickListener { operationPressed(RESTA) }
        por.setOnClickListener { operationPressed(MULTIP) }
        div.setOnClickListener { operationPressed(DIVI) }

        clear.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            tvResultado.text = " "
            operation = NO_OPERATION
        }

        igual.setOnClickListener {
            var result = when(operation){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIP -> num1 * num2
                DIVI -> num1 / num2
                else -> 0
            }
            tvResultado.text = result.toString()
            num1 = result.toDouble()
        }
    }

    private fun numPress(digit : String){
        tvResultado.text = "${tvResultado.text}$digit"
        if (operation == NO_OPERATION)
            num1 = tvResultado.text.toString().toDouble()
        else
            num2 = tvResultado.text.toString().toDouble()
    }

    private fun operationPressed(operation : Int){
        this.operation = operation
        tvResultado.text = " "
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIP = 3
        const val DIVI = 4
        const val NO_OPERATION = 0
    }
}