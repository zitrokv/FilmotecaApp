package com.example.filmotecaapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.filmotecaapp.R
import com.example.filmotecaapp.adapters.PeliculasProvider
import com.example.filmotecaapp.data.PeliculasApiService
import com.example.filmotecaapp.data.PeliculasListResponseT
import com.example.filmotecaapp.data.PeliculasResponseT
import com.example.filmotecaapp.utils.RetrofitUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    //lateinit var adapter: PeliculasAdapter
    lateinit var peliculasList: List<PeliculasResponseT> //PeliculasListResponseT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //searchByName(PeliculasProvider.textoBuscar)

        searchByTitle(PeliculasProvider.textoBuscar)
    }

    private fun searchByName(query: String){
        //segundo plano ó hilo secundario paralelo
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = RetrofitUtils.getRetrofit().create(PeliculasApiService::class.java)
                val  result = apiService.getByName(query)

                runOnUiThread {
                    if (result.response == "True") {
                        //peliculasList = mutableListOf<PeliculasResponse>( result )
                        peliculasList = result.results
                    } else {
                        peliculasList = emptyList()
                    }
                    //adapter.updateData(peliculasList, query)
                    Log.i("pruebas", result.results.toString())
                }

            }catch (e: Exception){
                e.printStackTrace()
            }
        }

    }

    private fun searchByTitle(query: String){
        //segundo plano ó hilo secundario paralelo
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = RetrofitUtils.getRetrofit().create(PeliculasApiService::class.java)
                //val  result = apiService.getByName(query)
                val  result = apiService.getByTitle(query)

                runOnUiThread {
                    if (result.first().responseT == "True") {
                        //peliculasList = mutableListOf<PeliculasResponse>( result )
                        peliculasList = result
                    } else {
                        searchByName("Terminator")
                    }
                    //adapter.updateData(peliculasList, query)
                    Log.i("pruebas", result.toString())
                    Log.i("pruebas", peliculasList.toString())
                }

            }catch (e: Exception){
                e.printStackTrace()
            }
        }

    }
}