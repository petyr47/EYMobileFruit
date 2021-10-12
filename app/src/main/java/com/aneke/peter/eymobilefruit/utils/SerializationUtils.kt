package com.aneke.peter.eymobilefruit.utils

import com.aneke.peter.eymobilefruit.App
import com.aneke.peter.eymobilefruit.models.Fruit
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException
import java.nio.charset.Charset

fun loadDataFromJson() : List<Fruit> {
    try {
        val content = loadAssetsFile()
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val type = Types.newParameterizedType(List::class.java, Fruit::class.java)
        val adapter = moshi.adapter<List<Fruit>>(type)
        return adapter.fromJson(content) ?: emptyList()
    } catch (e : Exception){
        e.printStackTrace()
        return emptyList()
    }
}

private fun loadAssetsFile() : String {
    try {
        val ist = App.instance.assets.open("data.json")
        val size = ist.available()
        val buffer = ByteArray(size)
        ist.read(buffer)
        ist.close()
        return String(buffer, Charset.defaultCharset())
    } catch (ex: IOException) {
        ex.printStackTrace()
        return ""
    }
}