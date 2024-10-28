package com.example.bizcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow.Companion.Clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizCardAppTheme {
                CreateBizCard()
            }
        }
    }
}

@Composable
fun CreateBizCard(modifier: Modifier = Modifier){
    var buttonClickedState by remember { mutableStateOf(false) }

    Surface (
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .safeDrawingPadding()
    ){
        ElevatedCard (
            modifier = modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(15.dp),
        ) {
            Column (
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ){
                ProfileImage(modifier = modifier.size(150.dp))
                Spacer(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray)
                )
                Info()
                Button(
                    onClick = {
                        buttonClickedState = !buttonClickedState
                    },
                ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                if(buttonClickedState){
                    PortfolioList()
                }
            }
        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(R.drawable.profile_image_white),
        contentDescription = "profile image",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun Info(modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .padding(5.dp)
    ){
        Text(
            text = "Choimingyu",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
        )
        Text(
            text = "Android Compose Programmer",
            modifier = modifier.padding(3.dp)
        )
        Text(
            text = "@themilesCompose",
            modifier = modifier.padding(3.dp),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun PortfolioList(modifier: Modifier = Modifier){
    val portfolioList = listOf(
        "Project 1" to "A",
        "Project 2" to "B",
        "Project 3" to "C"
    )
    Surface (
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(3.dp, Color.LightGray)
    ){
        LazyColumn (
            modifier = modifier.padding(5.dp)
        ){
            items(portfolioList){portfolio ->
                PortfolioCard(title = portfolio.first, description = portfolio.second)
            }
        }
    }
}

@Composable
fun PortfolioCard(title: String, description: String, modifier: Modifier = Modifier){
    Card (
        modifier = modifier
            .padding(3.dp),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp)
        ){
            ProfileImage(modifier = modifier.size(50.dp))
            Column (
                modifier = modifier.padding(5.dp)
            ){
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CreateBizCardPreview() {
    BizCardAppTheme {
        CreateBizCard()
    }
}

@Preview(showBackground = true)
@Composable
fun PortfolioPreview() {
    BizCardAppTheme {
        PortfolioList()
    }
}