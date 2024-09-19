package com.example.artwork

import android.os.Bundle
import android.util.Pair
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artwork.ui.theme.ArtworkTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtworkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Art(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
data class Art(val imageRes: Int, val title: String, val year: String)
@Composable
fun Art(modifier: Modifier=Modifier){
    val artworks = listOf(
        Art(R.drawable.mona_lisa, "Mona Lisa", "Leonardo da Vinc - 1519"),
        Art(R.drawable.the_last_supper, "The Last Supper", "Leonardo da Vinc - 1498"),
        Art(R.drawable.the_starry_night, "The Starry Night", "Van Gogh - 1889"),
        Art(R.drawable.girl_with_a_pearl_earring, "Girl With a Pearl Earring ", "Johannes Vermeer - 1665")

    )
    var curent by remember {
        mutableStateOf(0)
    }
    Column(modifier= Modifier
        .padding(start = 20.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        val image:Painter= painterResource(id = artworks[curent].imageRes)
      Row(modifier = Modifier.shadow(8.dp, shape = RoundedCornerShape(16.dp))) {
          Image(painter = image , contentDescription = null,modifier=Modifier.size(320.dp)
              .padding( 8.dp )
              )
      }
        Spacer(modifier = Modifier.height(30.dp))
      Row(modifier = Modifier.background(Color(0xFFEADDFF)), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
          ) {
          Column(modifier=Modifier) {
              Text(
                  text = artworks[curent].title,
                  fontSize = 30.sp,
                  textAlign = TextAlign.Center,
                  fontWeight = FontWeight.Bold
              )

              // Hiển thị năm sáng tác
              Text(
                  text = artworks[curent].year,
                  fontSize = 18.sp,
                  textAlign = TextAlign.Center
              )
          }

        }
        Spacer(modifier = Modifier.height(30.dp))
      Row( horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth(0.5f)){
          Column {
              Button(
                  onClick = {
                      if (curent > 0) {
                          curent--
                      }
                  }
              ) {
                  Text("Trước", fontSize = 20.sp)
              }

          }
          Button(
              onClick = {
                  if (curent < artworks.size - 1) {
                      curent++
                  }
              }
          ) {
              Text("Sau", fontSize = 20.sp)

          }
      }



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtworkTheme {
        Art(Modifier)
    }
}