
package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.lang.StringBuilder

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

        autocompleteTV.setOnClickListener {
            autocompleteTV.text.clear()
        }

        autocompleteTV2.setOnClickListener {
            autocompleteTV2.text.clear()
        }

        binding.swapBtnMain.setOnClickListener {
            val s = autocompleteTV.text
            autocompleteTV.text = autocompleteTV2.text
            autocompleteTV2.text = s
        }

        binding.convertBtnCvMain.setOnClickListener {
            if(autocompleteTV.text.isNotEmpty() && autocompleteTV2.text.isNotEmpty()){
                val retrofitBuilder = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://v6.exchangerate-api.com/")
                    .build()
                    .create(ApiInterface::class.java)

                val retrofitData: Call<Converter> = (
                if(autocompleteTV.text.toString().equals("AED - UAE Dirham")){
                    retrofitBuilder.getConversionAED()
                }
                else if(autocompleteTV.text.toString().equals("ANG - Netherlands Antillian Guilder")){
                    retrofitBuilder.getConversionANG()
                }
                else if(autocompleteTV.text.toString().equals("AUD - Australian Dollar")){
                    retrofitBuilder.getConversionAUD()
                }
                else if(autocompleteTV.text.toString().equals("BDT - Bangladeshi Taka")){
                    retrofitBuilder.getConversionBDT()
                }
                else if(autocompleteTV.text.toString().equals("CAD - Canadian Dollar")){
                    retrofitBuilder.getConversionCAD()
                }
                else if(autocompleteTV.text.toString().equals("CHF - Swiss Franc")){
                    retrofitBuilder.getConversionCHF()
                }
                else if(autocompleteTV.text.toString().equals("CNY - Chinese Renminbi")){
                    retrofitBuilder.getConversionCNY()
                }
                else if(autocompleteTV.text.toString().equals("EUR - Euro")){
                    retrofitBuilder.getConversionEUR()
                }
                else if(autocompleteTV.text.toString().equals("HKD - Hong Kong Dollar")){
                    retrofitBuilder.getConversionHKD()
                }
                else if(autocompleteTV.text.toString().equals("IDR - Indonesian Rupiah")){
                    retrofitBuilder.getConversionIDR()
                }
                else if(autocompleteTV.text.toString().equals("INR - Indian Rupee")){
                    retrofitBuilder.getConversionINR()
                }
                else if(autocompleteTV.text.toString().equals("JPY - Japanese Yen")){
                    retrofitBuilder.getConversionJPY()
                }
                else if(autocompleteTV.text.toString().equals("LKR - Sri Lankan Rupee")){
                    retrofitBuilder.getConversionLKR()
                }
                else if(autocompleteTV.text.toString().equals("MXN - Mexican Peso")){
                    retrofitBuilder.getConversionMXN()
                }
                else if(autocompleteTV.text.toString().equals("NGN - Nigerian Naira")){
                    retrofitBuilder.getConversionNGN()
                }
                else if(autocompleteTV.text.toString().equals("RUB - Russian Ruble")){
                    retrofitBuilder.getConversionRUB()
                }
                else if(autocompleteTV.text.toString().equals("THB - Thai Baht")){
                    retrofitBuilder.getConversionTHB()
                }
                else if(autocompleteTV.text.toString().equals("USD - United States Dollar")){
                    retrofitBuilder.getConversionUSD()
                }
                else if(autocompleteTV.text.toString().equals("VND - Vietnamese Dong")){
                    retrofitBuilder.getConversionVND()
                }
                else {
                    retrofitBuilder.getConversionZWL()
                }
                        )

                val rates = hashMapOf<String, Double>()
                var cf = 0.0
                retrofitData.enqueue(object : Callback<Converter> {
                    override fun onResponse(
                        call: Call<Converter>,
                        response: Response<Converter>
                    ) {
                        val responseBody = response.body()!!

                           /* rates.put("AED", responseBody.conversion_rates.AED)
                            rates.put("ANG", responseBody.conversion_rates.ANG)
                            rates.put("AUD", responseBody.conversion_rates.AUD)
                            rates.put("BDT", responseBody.conversion_rates.BDT)
                            rates.put("CAD", responseBody.conversion_rates.CAD)
                            rates.put("CHF", responseBody.conversion_rates.CHF)
                            rates.put("CNY", responseBody.conversion_rates.CNY)
                            rates.put("EUR", responseBody.conversion_rates.EUR)
                            rates.put("HKD", responseBody.conversion_rates.HKD)
                            rates.put("IDR", responseBody.conversion_rates.IDR)
                            rates.put("INR", responseBody.conversion_rates.INR)
                            rates.put("JPY", responseBody.conversion_rates.JPY)
                            rates.put("LKR", responseBody.conversion_rates.LKR)
                            rates.put("MXN", responseBody.conversion_rates.MXN)
                            rates.put("NGN", responseBody.conversion_rates.NGN)
                            rates.put("RUB", responseBody.conversion_rates.RUB)
                            rates.put("THB", responseBody.conversion_rates.THB)
                            rates.put("USD", responseBody.conversion_rates.USD)
                            rates.put("VND", responseBody.conversion_rates.VND)
                            rates.put("ZWL", responseBody.conversion_rates.ZWL) */

                        cf = responseBody.conversion_rates.get(autocompleteTV2.text.toString().substring(0, 3))!!
                        binding.outputAmtTxtMain.text = (binding.inputAmtTxtMain.text.toString().toDouble() * cf).toString()
                    }

                    override fun onFailure(call: Call<Converter>, t: Throwable) {
                        Log.d("Main Activity", "onFailure: "+t.message)
                    }
                })


            }
            else{
                Toast.makeText(
                    this@MainActivity,
                    "Please choose currency",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}