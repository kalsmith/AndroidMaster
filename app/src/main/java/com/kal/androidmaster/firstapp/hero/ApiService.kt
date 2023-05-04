package com.kal.androidmaster.firstapp.hero

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/api/625318262798797/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName : String):Response<SuperHeroDataResponse>

    @GET("api/625318262798797/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId: String): Response<SuperHeroDetailResponse>




}