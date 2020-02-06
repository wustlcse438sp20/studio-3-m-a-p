package com.example.cse438_rest_studio.data

import android.service.voice.VoiceInteractionSession


//TODO #3: Generate a data class to represent a brewery based on the JSON output from the API
    data class Brewery(
        val id : Int,
        val name : String,
        val brewery_type : String,
        val city : String
    )