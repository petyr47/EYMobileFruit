package com.aneke.peter.eymobilefruit.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aneke.peter.eymobilefruit.models.Fruit


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun DetailLayout(fruit: Fruit?) {

    Box(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()
    ){

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = fruit?.image.toString(),
                fontSize = 120.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(24.dp)
            )

            Text(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                text = "Name: ${fruit?.productName}")

            Text(
                modifier = Modifier.padding(8.dp),
                color = Color.DarkGray,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                text = "Description: \n${fruit?.description}")

            Column(
                modifier= Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start) {

                Text(
                    modifier = Modifier.padding(8.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    text = "Origin: ${fruit?.from}")

                Text(
                    modifier = Modifier.padding(8.dp),
                    color = Color.Blue,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    text = "Nutrients: ${fruit?.nutrients}")

                Text(
                    modifier = Modifier.padding(8.dp),
                    color = Color.Red,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    text = "Quantity: ${fruit?.quantity}")

                Text(
                    modifier = Modifier.padding(8.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    text = "Price: $${fruit?.price}")
            }
        }
    }

}


