package com.aneke.peter.eymobilefruit.main

import androidx.lifecycle.ViewModel
import com.aneke.peter.eymobilefruit.utils.loadDataFromJson

class MainViewModel : ViewModel() {

    val fruits = loadDataFromJson()
}