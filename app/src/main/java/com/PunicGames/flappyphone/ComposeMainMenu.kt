package com.PunicGames.flappyphone

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
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

class ComposeMainMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContent {
            MainMenuContent()
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun MainMenuViewContainer(){

    Scaffold(
        content = { MainMenuContent()}
    )
}

@Composable
fun ImageBackground(){
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Fondo de madera",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun PlayButton(){


    val mContext = LocalContext.current

    Button( colors = ButtonDefaults.buttonColors(
        backgroundColor = Color(red = 0, green = 102, blue =255),contentColor = Color.White),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(60.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        ),
        onClick = { mContext.startActivity(Intent(mContext, ComposeLevelSelectionActivity::class.java)) }
    ) {
        Text(
            text = "Play",
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MainMenuContent(){

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
                .weight(5f)
                //.background(Color.Green)
        ) {

            //Hueco 1
            Row(modifier = Modifier
                .fillMaxSize()
                .weight(3f)
                //.background(Color.Blue)
            ){

            }

            //Imagen logo
            Row(modifier = Modifier
                .fillMaxSize()
                .weight(5f)
                //.background(Color.Green)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.menu_logo),
                    contentDescription = "Logo",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxSize()
                )

            }

            //Hueco 2
            Row(modifier = Modifier
                .fillMaxSize()
                .weight(2f)
                //.background(Color.Blue)
            ){

            }

            //Boton jugar
            Row(modifier = Modifier
                .fillMaxSize()
                .weight(2f)
                //.background(Color.Green)
            ){
                PlayButton()
            }

            //Hueco 3
            Row(modifier = Modifier
                .fillMaxSize()
                .weight(3f)
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