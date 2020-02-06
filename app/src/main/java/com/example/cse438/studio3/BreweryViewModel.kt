package com.example.cse438.studio3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.Network.BreweryRepository
import com.example.cse438_rest_studio.data.Brewery


class BreweryViewModel(application: Application): AndroidViewModel(application) {

    //TODO #8: Create a livedata object for tracking breweries
    public var breweryTracker : MutableLiveData<List<Brewery>> = MutableLiveData()
    public var breweryRepository : BreweryRepository = BreweryRepository()

    //TODO #9: Write functions to access the two brewery API calls from the repository
    fun findByCity(city: String) {
        breweryRepository.findByCity(breweryTracker, city)
    }

    fun findByTerm(term: String) {
        breweryRepository.findByTerm(breweryTracker, term)
    }

}