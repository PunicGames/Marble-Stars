package com.PunicGames.flappyphone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.PunicGames.flappyphone.ui.theme.FlappyPhoneTheme
import java.time.format.TextStyle

class ComposeResumeLevelActivity : ComponentActivity() {

    var puntos = 0
    var minutos = 1
    var segundos = 1

    var star1Alpha = 0.2f
    var star2Alpha = 0.2f
    var star3Alpha = 0.2f
    var star4Alpha = 0.2f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var bundle = intent.extras
            puntos = bundle?.getInt("points")!!;
            minutos = bundle?.getInt("minutes")!!;
            segundos = bundle?.getInt("seconds")!!;

            when(puntos){
                1 -> Star1()
                2 -> Star2()
                3 -> Star3()
                4 -> Star4()
            }

            ResumeLevelViewContainer()
        }


    }

    fun Star1(){
        star1Alpha = 1f
    }

    fun Star2(){
        star1Alpha = 1f
        star2Alpha = 1f
    }

    fun Star3(){
        star1Alpha = 1f
        star2Alpha = 1f
        star3Alpha = 1f
    }

    fun Star4(){
        star1Alpha = 1f
        star2Alpha = 1f
        star3Alpha = 1f
        star4Alpha = 1f
    }

    @Preview(showBackground = true, widthDp = 400, heightDp = 800)
    @Composable
    fun ResumeLevelViewContainer(){

        Scaffold(
            content = { ResumeLevelContent()}
        )
    }

    @Composable
    fun TimeText(){
        Text(
            modifier = Modifier.fillMaxSize(),
            //text = "1:54", //placeholder
            text = minutos.toString() + " : " + segundos.toString(),
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun ExitButton(){


        val mContext = LocalContext.current

        Button(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(30.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ),
            onClick = { mContext.startActivity(Intent(mContext, ComposeMainMenu::class.java)) }
        ) {
            Text(
                text = "Exit",
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun ResumeLevelContent(){

        ImageBackground()

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Blue)
            ) {

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(4f)
                    //.background(Color.Green)
            ) {

                //Hueco 1
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Blue)
                ){

                }

                //Imagen logo
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Green)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.level_resume),
                        contentDescription = "Logo",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxSize()
                    )


                }

                //Hueco 2
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Blue)
                ){

                }

                //Estrellas
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Green)
                ){
                    //Estrella 1
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            //.background(Color.Yellow)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize(),
                            alpha = star1Alpha
                        )

                    }

                    //Estrella 2
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            //.background(Color.Red)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize(),
                            alpha = star2Alpha
                        )

                    }

                    //Estrella 3
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            //.background(Color.Yellow)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize(),
                            alpha = star3Alpha
                        )

                    }

                    //Estrella 4
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            //.background(Color.Red)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize(),
                            alpha = star4Alpha
                        )

                    }
                }

                //Hueco 3
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Blue)
                ){

                }

                //Tiempo
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Green)
                ){
                    TimeText()

                }

                //Hueco 4
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Blue)
                ){

                }

                //Boton exit
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Green)
                ){
                    ExitButton()
                }

                //Hueco 5
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Blue)
                ){

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    //.background(Color.Blue)
            ) {

            }
        }

    }

}

