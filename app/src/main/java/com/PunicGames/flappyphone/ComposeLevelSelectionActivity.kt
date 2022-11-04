package com.PunicGames.flappyphone

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.PunicGames.flappyphone.ui.theme.FlappyPhoneTheme
import java.time.format.TextStyle

class ComposeLevelSelectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LevelSelectionViewContainer()
        }
    }
}

@Preview
@Composable
fun LevelSelectionViewContainer(){
    Scaffold(
        topBar = { LevelSelectionTopBar()},
        content = { LevelSelectionContent()},
        bottomBar = { LevelSelectionBottomBar()}
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
fun LevelSelectionBottomBar(){

    val mContext = LocalContext.current

    BottomAppBar() {
        IconButton(onClick = {
            mContext.startActivity(Intent(mContext, MainMenuActivity::class.java))
        }) {
            Icon(
                painter= painterResource(id = R.drawable.ic_baseline_arrow_back_24) ,
                contentDescription = "Volver atrás")
        }
    }
}

@Composable
fun Level1Button(){

    val mContext = LocalContext.current

    Button(
        modifier = Modifier
            .padding(vertical = 40.dp)
            .height(70.dp)
            .width(200.dp),
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
            .padding(vertical = 40.dp)
            .height(70.dp)
            .width(200.dp),
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
            .padding(vertical = 40.dp)
            .height(70.dp)
            .width(200.dp),
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
            .padding(vertical = 40.dp)
            .height(70.dp)
            .width(200.dp),
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
fun LevelSelectionContent(){



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Select Level",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            fontSize = 36.sp
        )

        Level1Button()

        Level2Button()

        Level3Button()

        Level4Button()

    }


}