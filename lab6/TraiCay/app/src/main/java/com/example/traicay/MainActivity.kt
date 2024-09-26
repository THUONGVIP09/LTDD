package com.example.traicay

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.traicay.data.Traicay
import com.example.traicay.data.traicays
import com.example.traicay.ui.theme.TraiCayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TraiCayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TraiCayApp(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun TraiCayApp(modifier: Modifier=Modifier) {
    Scaffold(
        topBar = {
            TraiCayTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(traicays) {
                TraiCayItem(
                    traicay = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TraiCayTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "30 ngày với Trái Cây",
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun TraiCayItem(    traicay: Traicay ,
    modifier: Modifier = Modifier
    ) {
        var expanded by remember { mutableStateOf(false) }
        val color by animateColorAsState(
            targetValue = if(expanded) MaterialTheme.colorScheme.tertiaryContainer
            else MaterialTheme.colorScheme.primaryContainer )
    TraiCayCard(traicay = traicay, expanded = expanded, onClick = { expanded = !expanded })
}
@Composable
fun TraiCayCard(
    traicay: Traicay,
    expanded: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit // Đảm bảo rằng bạn truyền đúng hàm onClick

) {

    Card(modifier = modifier.padding(8.dp)) { // Thêm padding cho Card để có khoảng cách hợp lý
        Column(modifier = Modifier.fillMaxWidth()) {
            // Hiển thị ngày
            Text(
                text = "Day " + traicay.day,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

            // Hiển thị tên trái cây
            Text(
                text = stringResource(id = traicay.name),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            IconButton(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(197.dp)
                    .padding(16.dp)
            ) {
                // Nội dung của nút hình ảnh
                Image(
                    painter = painterResource(id = traicay.imageResourceId),
                    contentDescription = "Image of ${traicay.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop

                )
            }
            if(expanded){
                Text(text = stringResource(id = traicay.gia), modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.bodyMedium)

            }


            // ImageButton để hiển thị hình ảnh trái cây

        }
    }
}






@Preview()
@Composable
fun GreetingPreview() {
    TraiCayTheme {
        TraiCayApp(modifier = Modifier)
    }
}