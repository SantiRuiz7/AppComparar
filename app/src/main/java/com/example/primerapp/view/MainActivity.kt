package com.example.primerapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.primerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainCompareViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.compare.observe(this) { comparisonResult ->
            comparisonResult?.let {
                val resultText = if (it.areEqual) {
                    "Son iguales"
                } else {
                    "No son iguales"
                }
                binding.showResult.text = resultText
            }
        }

        binding.btnCompare.setOnClickListener {
            val firstInput = binding.inputText1.text.toString()
            val secondInput = binding.inputText2.text.toString()
            mainViewModel.compareStrings(firstInput, secondInput)
        }
    }
}