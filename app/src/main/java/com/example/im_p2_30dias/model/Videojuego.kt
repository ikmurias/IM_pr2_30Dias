package com.example.im_p2_30dias.model

import androidx.annotation.DrawableRes

data class Videojuego(
    val titulo: String,
    val descripcion: String,
    val generos: List<String>,
    @DrawableRes val imagen: Int,
)
