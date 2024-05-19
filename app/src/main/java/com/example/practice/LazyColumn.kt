package com.example.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyItems(){
    //Lazy column for fixed number of items - loads items while scrolling
    val languages = listOf("Kotlin", "Python", "JS", "C#", "C++")

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn {
            items(3){index ->
                Box (
                    modifier = Modifier.padding(vertical = 10.dp)
                ){
                    Text(
                        text = "Item: $index",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                    )
                }
            }
        }

        //With a list
        LazyColumn {
            items(languages){language ->
                Text(text = language)
            }
        }

        //Another way
        LazyColumn {
            itemsIndexed(
                listOf("Diese", "kalte", "nacht :(")
            ){ _, string -> //"_" or "index"
                Text(
                    text = string,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold

                )
            }
        }
    }

    //Scrollable column - Loads all items at once
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier.verticalScroll(scrollState)
    ){
        for (i in 1..50){
            Text(
                text = "Item $i",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyPreview(){
    LazyItems()
}