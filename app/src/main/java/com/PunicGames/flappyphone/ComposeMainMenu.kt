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

class ComposeMainMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainMenuViewContainer()
        }
    }
}

@Preview
@Composable
fun MainMenuViewContainer(){
    /*
    Scaffold(
        //topBar = { LevelSelectionTopBar()},
        //content = { LevelSelectionContent()}
    )*/
}

@Composable
fun MainMenuTopBar(){
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
fun MainMenuBottomBar(){

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
fun MainMenuContent(){



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