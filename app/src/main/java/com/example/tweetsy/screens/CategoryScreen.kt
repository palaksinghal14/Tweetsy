package com.example.tweetsy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.viewmodels.CategoryViewModel

//✅ STEP 6: Create the Screens

    @Composable

    // basically jaise hum screen pe alag alag category ke item rakhenge
    fun CategoryScreen(onClick:(category:String)-> Unit) {
        // API CALLL
        val categoryviewmodel: CategoryViewModel = hiltViewModel() // here we making a object of categoryviewmodel class using hiltviewmodel because navigation is craeting a object for viewmodel through hilt
        val categories = categoryviewmodel.categories.collectAsState() // state define kr rhe h jo flowse milegi

        // same as lazycolumn just to render column grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // items ki list jo h wo viewmodel se milegi
            items(categories.value.distinct()) {
                CategoryItem(it,onClick)
            }
        }
    }

    // wo ek particular item kaisa hoga
    @Composable
    fun CategoryItem(category:String , onClick:(category:String)-> Unit){
     Box(modifier = Modifier
         .size(160.dp)
         .padding(8.dp)
         .clip(RoundedCornerShape(8.dp))
         .border(width=4.dp, color = Color.Black, shape = RectangleShape)
         .background(color = Color.LightGray)
         .clickable {
                    onClick(category)
         },
         contentAlignment = Alignment.BottomCenter
     ){
         Text(text = category,
             fontSize = 30.sp,
             fontStyle = FontStyle.Normal,
             fontWeight = FontWeight.ExtraBold,
             style=MaterialTheme.typography.displayMedium,
             color = Color.Black)
     }
    }