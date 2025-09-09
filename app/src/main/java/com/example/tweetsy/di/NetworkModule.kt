package com.example.tweetsy.di

import com.example.tweetsy.api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.jetbrains.annotations.ApiStatus
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.firebase.auth.FirebaseAuth // import this for firebase

// ✅ STEP 3: Define the API instance (Retrofit)
//isme hum dependencies create krte h using hilt for api , retrofit
@Module
@InstallIn(SingletonComponent::class )
object NetworkModule {

    // Retrofit instance
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTweetsyApi(retrofit: Retrofit): TweetsyApi{
        return retrofit.create(TweetsyApi::class.java)
    }

    // FirebaseAuth instance
      @Provides
      @Singleton
      fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
}

