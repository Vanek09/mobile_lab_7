package com.chisw.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.chisw.lab7.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.clickButton.setOnClickListener {
            val num = binding.numberEditText.text.toString().toInt()
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    task1(num)
                    task2(num)
                    task3(num)
                }
            }
        }
    }

    private fun task1(num: Int) {
        for(i in 0..num) {
            Log.d("GG", "Fibonacci: $i - ${fibonacci(i)}")
        }
    }

    private fun task2(num: Int) {
        Log.d("GG", "Factorial: ${factorial(num)}")
    }

    private fun task3(num: Int) {
        var currentValue = num
        var res = 0
        while (currentValue > 0) {
            currentValue /= 10
            res++
        }
        Log.d("GG", "Count: $res")
    }

    private fun fibonacci(num: Int): Int {
        if (num <= 1)
            return num
        return fibonacci(num - 1) + fibonacci(num - 2)
    }

    fun factorial(num: Int): Int {
        if (num <= 1)
            return num
        return num * factorial(num - 1)
    }
}