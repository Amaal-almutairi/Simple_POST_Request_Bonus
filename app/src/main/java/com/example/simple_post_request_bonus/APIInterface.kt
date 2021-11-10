package com.example.simple_post_request_bonus


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIInterface {
    @Headers("Content-Type:application/json")
    @POST("/custom-people/")
    fun postAllusers(@Body named:Users):Call<Users?>

}