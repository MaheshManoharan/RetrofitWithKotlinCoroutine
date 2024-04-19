package com.example.retrofitwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        //launching new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes()

            if(result != null){
                //
                Log.d("Mahi", "onCreate: ${result.body().toString()}")
                Log.d("Mahi", result.body()?.results?.first().toString() )
            }
        }
    }
}