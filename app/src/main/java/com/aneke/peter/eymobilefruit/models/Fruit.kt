package com.aneke.peter.eymobilefruit.models

import com.squareup.moshi.JsonClass

data class Fruit(
    val description: String = "",
    val from: String = "",
    val id: Int = 0,
    val image: String = "",
    val nutrients: String = "",
    val organic: Boolean = false,
    val price: String = "",
    val productName: String = "",
    val quantity: String = ""
)