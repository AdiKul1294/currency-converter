package com.example.currencyconverter

import android.provider.ContactsContract
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/AED")
    fun getConversionAED(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/ANG")
    fun getConversionANG(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/AUD")
    fun getConversionAUD(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/BDT")
    fun getConversionBDT(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/CAD")
    fun getConversionCAD(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/CHF")
    fun getConversionCHF(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/CNY")
    fun getConversionCNY(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/EUR")
    fun getConversionEUR(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/HKD")
    fun getConversionHKD(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/IDR")
    fun getConversionIDR(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/INR")
    fun getConversionINR(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/JPY")
    fun getConversionJPY(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/LKR")
    fun getConversionLKR(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/MXN")
    fun getConversionMXN(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/NGN")
    fun getConversionNGN(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/RUB")
    fun getConversionRUB(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latestTHB")
    fun getConversionTHB(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/USD")
    fun getConversionUSD(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/VND")
    fun getConversionVND(): Call<Converter>

    @GET("v6/c7ae2f00f292916d125e5b3e/latest/ZWL")
    fun getConversionZWL(): Call<Converter>
}