package com.example.tweetsy.models


// retrofit data class
// ✅ STEP 1: Define the data model
// This represents one item coming from the API (like a tweet)
data class TweetListItem(
    val category: String,
    val text: String
)