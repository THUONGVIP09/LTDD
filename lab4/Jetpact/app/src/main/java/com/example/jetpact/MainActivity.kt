package com.example.jetpact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpact.ui.theme.JetpactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpactTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingImage(
                        "Jetpack Compose tutorial",
                        "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                        "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, from1: String, modifier: Modifier=Modifier){
    val image= painterResource(R.drawable.bg_compose_background)
    Column {



            Image(painter = image, contentDescription = null,


                modifier = Modifier.fillMaxWidth()
                )


            GreetingText(message = message, from = from,from1=from1, modifier = modifier)



    }



}
@Composable
fun GreetingText(message: String, from:String,from1:String,  modifier: Modifier=Modifier){

    Column( verticalArrangement = Arrangement.Center,
        modifier = modifier) {
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier.padding(
                16.dp
            ),
            textAlign = TextAlign.Justify

        )
        Text(
            text = from, textAlign = TextAlign.Justify,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = from1, textAlign = TextAlign.Justify,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
        )
    }

}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpactTheme {
        GreetingImage("Jetpack Compose tutorial",
            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = Modifier)
    }
}