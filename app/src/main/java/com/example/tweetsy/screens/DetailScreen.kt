package com.example.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.viewmodels.CategoryViewModel
import com.example.tweetsy.viewmodels.TweetViewModel

//✅ STEP 6: Create the Screens
@Composable
fun detailScreen(){

    val tweetviewmodel: TweetViewModel = hiltViewModel()
    val tweets =tweetviewmodel.tweets.collectAsState()
    LazyColumn( verticalArrangement = Arrangement.SpaceEvenly,
        modifier=Modifier.padding(4.dp) ){
        items(tweets.value){
           tweetlistitem(tweet = it.text)  //.text prop is used to access the text of the item
        }
    }

}

@Composable
fun tweetlistitem(tweet:String){
    Card (modifier= Modifier
        .fillMaxWidth()
        .padding(8.dp),
        border = BorderStroke(2.dp, Color(0xFFCCCCCCC))
    ){
        Text(text = tweet,
            modifier=Modifier.padding(2.dp),
            style=MaterialTheme.typography.displaySmall)
    }

}