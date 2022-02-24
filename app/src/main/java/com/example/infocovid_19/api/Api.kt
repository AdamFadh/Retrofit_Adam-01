package com.example.infocovid_19.api

import com.example.infocovid_19.model.IndonesiaResponse
import com.example.infocovid_19.model.ProvinsiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api{
    @GET ("casenumber.json")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET ("casenumberprovince.json")
    fun getProvince(): Call<ArrayList<ProvinsiResponse>>
}