package com.emircankirez.kotlinsimplecalculatorapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.emircankirez.kotlinsimplecalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //to access this way, we add the buildFeatures part to the android part of the build.gradle app
    private lateinit var binding: ActivityMainBinding
    private lateinit var firstNumber: String
    private lateinit var secondNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //When we add these 3 lines, we can now access our objects in Xml file.
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    /*
    I set the length of the textView to a maximum of 9 this way I avoid the invalid int exception and wrong result. Max Int = 10 digits
     */
    fun sum(view : View) {
        firstNumber = binding.txtFirstNumber.text.toString()
        secondNumber = binding.txtSecondNumber.text.toString()

        if(firstNumber.isEmpty() || secondNumber.isEmpty()){
            binding.txtViewResult.text = "No number!"
        }else{
            val result = firstNumber.toInt() + secondNumber.toInt()
            binding.txtViewResult.text = "Result: $result"
        }
    }

    fun sub(view : View){
        firstNumber = binding.txtFirstNumber.text.toString()
        secondNumber = binding.txtSecondNumber.text.toString()

        if(firstNumber.isEmpty() || secondNumber.isEmpty()){
            binding.txtViewResult.text = "No number!"
        }else{
            val result = firstNumber.toInt() - secondNumber.toInt()
            binding.txtViewResult.text = "Result: $result"
        }
    }

    fun mul(view : View){
        firstNumber = binding.txtFirstNumber.text.toString()
        secondNumber = binding.txtSecondNumber.text.toString()

        if(firstNumber.isEmpty() || secondNumber.isEmpty()){
            binding.txtViewResult.text = "No number!"
        }else{
            val result: Long = firstNumber.toLong() * secondNumber.toInt() //to avoid to generate wrong number due to int limit, I use long type so that it can store the value that will be generated
            binding.txtViewResult.text = "Result: $result"
        }
    }

    fun div(view : View){
        firstNumber = binding.txtFirstNumber.text.toString()
        secondNumber = binding.txtSecondNumber.text.toString()

        if(firstNumber.isEmpty() || secondNumber.isEmpty()){
            binding.txtViewResult.text = "No number!"
        }else if(firstNumber.toInt() == 0){
            binding.txtViewResult.text = "Unsolvable"
        }else{
            val result = firstNumber.toDouble() / secondNumber.toInt()
            binding.txtViewResult.text = "Result: ${String.format("%.2f", result)}"
        }
    }
}