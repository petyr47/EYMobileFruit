package com.aneke.peter.eymobilefruit.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aneke.peter.eymobilefruit.models.Fruit
import com.aneke.peter.eymobilefruit.ui.theme.BottomSheetShape
import com.aneke.peter.eymobilefruit.ui.theme.EYMobileFruitTheme
import com.aneke.peter.eymobilefruit.utils.loadDataFromJson
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EYMobileFruitTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    App(viewModel)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun App(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        // Main Screen
        composable("main_screen") {
            MainScreen(viewModel)
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    val selectedFruit = remember{ mutableStateOf<Fruit>(loadDataFromJson()[0])}

    val closeSheet: (Fruit) -> Unit = {
        scope.launch {
            selectedFruit.value = it
            scaffoldState.bottomSheetState.collapse()
        }
    }


    val openSheet: () -> Unit = {
        scope.launch {
            scaffoldState.bottomSheetState.expand() }
    }

    BottomSheetScaffold(
        sheetPeekHeight = 48.dp,
        scaffoldState = scaffoldState,
        sheetShape = BottomSheetShape,
        sheetContent =  {
            DetailLayout(selectedFruit.value)
        }
    ) {

        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    color = Color.Black,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Fruits"
                )

                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    itemsIndexed(viewModel.fruits) { row, item ->
                        FruitCard({ open ->
                            selectedFruit.value = item
                            if (open){
                                openSheet()
                            }
                        }, item)
                    }
                }
            }

        }
    }

}


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EYMobileFruitTheme() {

    }
}