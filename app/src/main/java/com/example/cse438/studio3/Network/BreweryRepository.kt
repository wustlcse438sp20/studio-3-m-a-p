package com.example.cse438_rest_studio.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.data.Brewery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class BreweryRepository {

    //TODO #6: Create a function that launches a coroutine for searching by city
    val service = ApiClient.makeRetrofitService()

    fun findByCity(resBody: MutableLiveData<List<Brewery>>, city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.findByCity(city)

            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }


    //TODO #7: Create a function that launches a coroutine for searching by a generic term
    fun findByTerm(resBody: MutableLiveData<List<Brewery>>, term : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.searchTerm(term)

            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }
}