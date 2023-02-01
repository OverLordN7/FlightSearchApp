package com.example.flightsearchapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun FlightSearchApp(
    modifier: Modifier = Modifier,
    viewModel: AirportViewModel = viewModel(factory = AirportViewModel.factory)
){

    Scaffold(modifier = Modifier.padding(8.dp)) { innerPadding->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(8.dp),
        ) {
            SearchRecord()
            RecordCard(Modifier.padding(innerPadding))
            RecordCard(Modifier.padding(innerPadding))
            RecordCard(Modifier.padding(innerPadding))
            RecordCard(Modifier.padding(innerPadding))
        }


    }

}

@Composable
fun SearchRecord(modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        var record by remember {
            mutableStateOf("")
        }
        TextField(
            value = record,
            onValueChange ={record = it},
            placeholder = { Text(text = "Enter flight record") },
            singleLine = true,
        )
    }
}


@Composable
fun RecordCard(modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
            ) {
            Text(
                text = "SVO",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "Sheremetyevo - A.S. Pushkin international")
        }
    }
}


@Preview
@Composable
fun DefaultPreview(){
    FlightSearchApp()
}