package com.example.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// as we know viewmodel use repository to access data

// ✅ STEP 4: Create the ViewModel
@HiltViewModel  // Tells Hilt to generate code to inject dependencies in ViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetRepository) :ViewModel()
{
    val categories: StateFlow<List<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}