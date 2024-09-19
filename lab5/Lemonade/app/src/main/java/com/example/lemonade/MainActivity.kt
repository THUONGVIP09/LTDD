package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonApp(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier ) {
    var currentStep by remember {
        mutableStateOf(1)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(currentStep){
            1->{
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(text = stringResource(R.string.mot))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_tree), 
                        contentDescription = stringResource(id = R.string.lemon_tree_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 2 })

                }
            }
            2->{
                var tapCount by remember { mutableStateOf(0) }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(text = stringResource(R.string.hai))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(id = R.string.lemon_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { tapCount++
                                if (tapCount == 3) {
                                    currentStep = 3
                                    tapCount = 0 // Reset tap count after triggering
                                } }
                            )

                }
            }
            3->{
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(text = stringResource(R.string.ba))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(id = R.string.Glass_of_lemonade_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 4 }
                    )

                }
            }
            4->{
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(text = stringResource(R.string.bon))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(id = R.string.Empty_glass_content_description),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 1 }
                    )

                }
            }
        }
    }



}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonApp(Modifier)
    }
}