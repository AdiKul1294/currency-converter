
package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get reference to the string array that we just created
        val currencies = resources.getStringArray(R.array.currencies)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, currencies)
        // get reference to the autocomplete text view
        val autocompleteTV = binding.inputCurrActvMain
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)

        val autocompleteTV2 = binding.outputCurrActvMain
        autocompleteTV2.setAdapter(arrayAdapter)

        binding.swapBtnMain.setOnClickListener {
            autocompleteTV.text = autocompleteTV2.text
        }
    }
}