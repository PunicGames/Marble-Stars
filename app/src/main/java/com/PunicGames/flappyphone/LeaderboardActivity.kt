package com.PunicGames.flappyphone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.PunicGames.flappyphone.ui.theme.FlappyPhoneTheme
import java.time.format.TextStyle

class LeaderboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@Preview
@Composable
fun ViewContainer(){
    Scaffold(
        topBar = { TopBar()},
        content = { Content()},
        //bottomBar = { BottomBar()}
    )
}

@Composable
fun TopBar(){
    TopAppBar{

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()

        ) {



            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = "Ir hacia atrás"
                )
            }

            Text(
                text = "Leaderboard",

                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                fontSize = 42.sp
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_open_24),
                    contentDescription = "Abrir menú de niveles"
                )
            }
        }


    }

}

@Composable
fun BottomBar(){
    BottomAppBar() {
        IconButton(onClick = { /*TODO*/ }) { // (3)
            Icon(
                painter= painterResource(id = R.drawable.ic_baseline_arrow_back_24) ,
                contentDescription = "Volver atrás")
        }
    }
}

@Composable
fun Content(){

    var positionsStyle = androidx.compose.ui.text.TextStyle(
        color = Color.Magenta,
        fontSize = 22.sp

    )

    var namesStyle = androidx.compose.ui.text.TextStyle(
        color = Color.Magenta,
        fontSize = 22.sp

    )

    var scoresStyle = androidx.compose.ui.text.TextStyle(
        color = Color.Magenta,
        fontSize = 22.sp

    )

    Column(

    ) {
        Text(

            text = "Local top scores",
            fontSize = 24.sp,
            color = Color(red = 0f, green = 0f, blue = 1f),
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Level 1",
            fontSize = 24.sp,
            color = Color(red = 0f, green = 0f, blue = 1f),
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
        LazyColumn(){
            item{
                Column() {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "1º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "785467",
                            style = scoresStyle
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "2º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ){
                        Text(
                            text = "20º",
                            style = positionsStyle
                        )

                        Text(
                            text = "Lonflis",
                            style = namesStyle
                        )

                        Text(
                            text = "724585467",
                            style = scoresStyle
                        )
                    }

                }

            }
        }
    }



}