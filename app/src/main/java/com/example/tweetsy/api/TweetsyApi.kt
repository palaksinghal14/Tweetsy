package com.example.tweetsy.api

import com.example.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

// defines the methods of endpoints for which we are calling the api
// ✅ STEP 2: Define the API interface (Retrofit)
// Retrofit creates the implementation automatically at runtime
interface TweetsyApi
{
    @GET("v3/b/68524efa8960c979a5abde9f?meta=false") // get request aur hume konse endpoint ko call krna h

    // header ke andar har baar jo category ho uske acc tweets lane ke lie hume use kuch is tarah se bhejna hoga ki wo chnage hojaye apne aap
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>> // function ka jo parameter h jo as a input milra h wo header ke sath append hoga aur wohi value pass hojayegi
    // input api call me header me pass krna h isiliye retrofit ka ye funtion use kiya h
    // jisme header annotation lagake header ki key jo h wo define krdenge aur value append krdenge

    @GET("v3/b/68524efa8960c979a5abde9f?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>
}
