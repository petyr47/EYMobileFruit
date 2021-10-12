package com.aneke.peter.eymobilefruit.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.aneke.peter.eymobilefruit.models.Fruit
import com.aneke.peter.eymobilefruit.ui.theme.EYMobileFruitTheme
import com.aneke.peter.eymobilefruit.utils.loadDataFromJson

@SuppressLint("UnrememberedMutableState")
@ExperimentalMaterialApi
@Composable
fun FruitCard( onClick : (Boolean) -> Unit ,fruit: Fruit) {

    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        onClick = { onClick(true) }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = fruit.image,
                fontSize = 64.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(24.dp)
            )
            Text(
                modifier = Modifier
                    .height(64.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = fruit.productName
            )
        }
    }
}
