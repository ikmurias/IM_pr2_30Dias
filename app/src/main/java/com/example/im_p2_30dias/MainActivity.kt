package com.example.im_p2_30dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.im_p2_30dias.model.Videojuego
import com.example.im_p2_30dias.ui.theme.IM_p2_30DiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IM_p2_30DiasTheme {
                // A surface container using the 'background' color from the theme
                app30Dias(videojuegos = Datastore.videojuegos())
            }
        }
    }
}



@Composable
fun topBar(){
    Row{
        Text(text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.h4,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun cardPreview() {
    cardVideojuego(
        videojuego = Videojuego(
            titulo = "hola",
            descripcion = "que tal",
            generos = listOf("acción", "violencia", "aventura", "riesgo", "paneles solares"),
            imagen = R.drawable.ic_launcher_background
        )
    )
}

@Composable
fun cardVideojuego(videojuego: Videojuego) {
    Card(modifier = Modifier.padding(8.dp), elevation = 3.dp) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(videojuego.titulo, style = MaterialTheme.typography.h4, modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)

            Image(
                painter = painterResource(id = videojuego.imagen),
                contentDescription = videojuego.titulo + " imagen",
                modifier = Modifier.fillMaxWidth()
            )
            Text(videojuego.descripcion, style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))


            LazyRow {
                items(videojuego.generos) {
                    Card(
                        elevation = 3.dp, modifier = Modifier
                            .padding(start = 3.dp, end = 3.dp)
                            .background(color = MaterialTheme.colors.surface),
                        shape = RoundedCornerShape(100)
                    ) {
                        Text(
                            text = it, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun app30Dias(videojuegos: List<Videojuego>) {
    Scaffold(topBar = { topBar()}) {
        LazyColumn {
            items(videojuegos) {
                cardVideojuego(videojuego = it)
            }
        }
    }
}
