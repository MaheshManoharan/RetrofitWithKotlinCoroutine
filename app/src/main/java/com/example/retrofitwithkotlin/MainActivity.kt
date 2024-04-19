package com.example.retrofitwithkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Results
import com.example.retrofitwithkotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    var list = ArrayList<Results>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val recyclerView = binding.recyclerView

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        //launching new coroutine
        GlobalScope.launch {
            val result =  quotesApi.getQuotes()

            if(result != null){
                //
                Log.d("Mahi", "onCreate: ${result.body().toString()}")
                Log.d("Mahi", result.body()?.results?.first().toString() )

                list = result.body()?.results!!

                Log.d("Mahi", "onCreate: list count ${list.size}")
if(list.size != 0){
    withContext(Dispatchers.Main) {
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = RecyclerViewAdapter(this@MainActivity, list)
    }

}


            }
        }
    }
}