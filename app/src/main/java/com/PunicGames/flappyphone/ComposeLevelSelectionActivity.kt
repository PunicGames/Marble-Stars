package com.PunicGames.flappyphone

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.internal.ViewUtils.dpToPx


class ComposeLevelSelectionActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            LevelSelectionViewContainer()
        }
    }
}


@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun LevelSelectionViewContainer(){
    Scaffold(
        topBar = { LevelSelectionTopBar()},
        content = { LevelSelectionContent()},
    )
}

@Composable
fun LevelSelectionTopBar(){
    TopAppBar{
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Marble Stars",

                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                fontSize = 44.sp
            )
        }
    }
}

@Composable
fun Level1Button(){


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
        onClick = { mContext.startActivity(Intent(mContext, Level_1_Activity::class.java)) }
    ) {
        Text(
            text = "Level 1",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Level2Button(){

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
        onClick = { mContext.startActivity(Intent(mContext, Level_2_Activity::class.java)) }
    ) {
        Text(
            text = "Level 2",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Level3Button(){

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
        onClick = { mContext.startActivity(Intent(mContext, Level_3_Activity::class.java)) }
    ) {
        Text(
            text = "Level 3",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Level4Button(){

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
        onClick = { mContext.startActivity(Intent(mContext, Level_4_Activity::class.java)) }
    ) {
        Text(
            text = "Level 4",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BackButton(){

    val mContext = LocalContext.current

    Button(
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Gray
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        ),
        onClick = { mContext.startActivity(Intent(mContext, MainMenuActivity::class.java)) }
    ) {
        Text(
            text = "Back",
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LevelSelectionContent(){

    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Select Level",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            fontSize = 36.sp
        )

        /*
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Level1Button()

            Level2Button()

            Level3Button()

            Level4Button()

            BackButton()
        }
*/

        Row(
            modifier = Modifier
                //.background(Color.Red)
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Blue)

            ) {

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(3f)
                    .background(Color.Green)

            ) {
                //Hueco 1
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Blue)
                ) {

                }

                //Boton 1
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Level1Button()

                }

                //Hueco 2
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Blue)
                ) {

                }

                //Boton 2
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Level2Button()

                }

                //Hueco 3
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Blue)
                ) {

                }

                //Boton 3
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Level3Button()

                }

                //Hueco 4
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Blue)
                ) {

                }

                //Boton 4
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Level4Button()

                }

                //Hueco 5
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Blue)
                ) {

                }

                //Boton 5
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    BackButton()

                }

                //Hueco 6
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Blue)
                ) {

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Blue)

            ) {

            }

        }



    }


}