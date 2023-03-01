package com.example.im_p2_30dias

import com.example.im_p2_30dias.model.Videojuego

class Datastore {
    companion object {
        fun videojuegos(): List<Videojuego>{
            val lista = mutableListOf<Videojuego>()
            lista.add(
                Videojuego(
                    "Grand Theft Auto V",
                    "Conviértete en un criminal en Los Santos y haz lo que quieras.",
                    listOf("Acción", "Aventura"),
                    R.drawable.gta))
                lista.add(Videojuego(
                    "The Legend of Zelda: Breath of the Wild",
                    "Explora el vasto mundo abierto de Hyrule y descubre sus misterios.",
                    listOf("Aventura", "Acción"),
                    R.drawable.zelda
                ))
            lista.add(Videojuego(
                "Super Mario Odyssey",
                "Únete a Mario en su emocionante aventura para rescatar a la princesa Peach.",
                listOf("Plataforma", "Acción","esto son", "más categorias de" , "prueba", "para probar el", "deslizamiento"),
                R.drawable.mario
            ))
            return lista
        }
    }
}