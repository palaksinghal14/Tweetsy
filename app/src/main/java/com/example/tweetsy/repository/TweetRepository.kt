package com.example.tweetsy.repository

import com.example.tweetsy.api.TweetsyApi
import com.example.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.Thread.State
import javax.inject.Inject


// isme hum apne functions ko implement krdete h mtlb jo humne interface me function define kre ho unko yha implement krte h , jitne bhi ho sare
// ✅ STEP 3: Create the Repository
// This is the layer between ViewModel and ApiService
// We inject ApiService using constructor injection so Hilt can provide it automatically
class TweetRepository @Inject constructor( private val tweetsyApi: TweetsyApi) {

    // stateflow define krne se jo bhi unhe observe kr rhe honge unhe pta chljayega ki koi chnage h so they can update it
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>   // hum expose sirf read only object ko krenge so that no ome can change it
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets : StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategories(){
        val response = tweetsyApi.getCategories()
        if(response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)  // use of emit -It sends a new value to the flow.
                                                 // Any collector of the flow will get this updated value.
        }
    }

    suspend fun gettweets(category: String){
        val response = tweetsyApi.getTweets("tweets[?(@.category==\"$category\")]") // ye jo value h ye header me jake append hogi aur isiliye ise usi format me pass kr rhe h jisme humari header ko need h
        if(response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }
}