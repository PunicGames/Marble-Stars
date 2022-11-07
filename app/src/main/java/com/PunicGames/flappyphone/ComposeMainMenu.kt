package com.PunicGames.flappyphone

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.PunicGames.flappyphone.ui.theme.FlappyPhoneTheme
import com.PunicGames.flappyphone.ui.theme.Typography
import com.PunicGames.flappyphone.ui.theme.marble
import java.time.format.TextStyle

class ComposeMainMenu : ComponentActivity() {

    private lateinit var mainMusic: MediaPlayer
    private lateinit var buttonEffect: MediaPlayer

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            MainMenuContent()
        }

        // Music
        mainMusic = MediaPlayer.create(this, R.raw.main_song);
        mainMusic.start()
        mainMusic.isLooping = true;
        mainMusic.setVolume(0.2f, 0.2f);

        buttonEffect = MediaPlayer.create(this, R.raw.button);
        buttonEffect.setVolume(0.6f, 0.6f)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @Preview(showBackground = true, widthDp = 400, heightDp = 800)
    @Composable
    fun MainMenuViewContainer(){

        Scaffold(
            content = { MainMenuContent()}
        )
    }



    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun PlayButton(){

        val mContext = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.btn),
                contentDescription = "Boton",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(40))
                    .border(2.dp, Color.Black, RoundedCornerShape(40))
                    .clickable(
                        onClick = {
                            mContext.startActivity(
                                Intent(
                                    mContext,
                                    ComposeLevelSelectionActivity::class.java
                                )
                            );
                            mainMusic.stop()
                            mainMusic.release()

                            buttonEffect.seekTo(0)
                            buttonEffect.start()
                        }
                    )
            )

            val aux = 150f

            val customTypeface = LocalContext.current.resources.getFont(R.font.marblefont)

            val textPaintStroke = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.STROKE
                textSize = aux
                color = android.graphics.Color.BLACK
                strokeWidth = 13f
                strokeMiter= 10f
                strokeJoin = android.graphics.Paint.Join.ROUND
                textAlign = android.graphics.Paint.Align.CENTER
                typeface = customTypeface
            }

            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = aux
                color = android.graphics.Color.WHITE
                textAlign = android.graphics.Paint.Align.CENTER
                typeface = customTypeface
            }

            Canvas(
                modifier = Modifier
                    .fillMaxSize(),
                onDraw = {
                    drawIntoCanvas {
                        it.nativeCanvas.drawText(
                            "Play",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Play",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaint
                        )
                    }
                }
            )

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun TutorialButton(){

        val mContext = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.btn),
                contentDescription = "Boton",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(40))
                    .border(2.dp, Color.Black, RoundedCornerShape(40))
                    .clickable(
                        onClick = {
                            mContext.startActivity(
                                Intent(
                                    mContext,
                                    ComposeTutorialActivity::class.java
                                )
                            );
                            mainMusic.stop()
                            mainMusic.release()

                            buttonEffect.seekTo(0)
                            buttonEffect.start()
                        }
                    )
            )

            val aux = 100f

            val customTypeface = LocalContext.current.resources.getFont(R.font.marblefont)

            val textPaintStroke = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.STROKE
                textSize = aux
                color = android.graphics.Color.BLACK
                strokeWidth = 13f
                strokeMiter= 10f
                strokeJoin = android.graphics.Paint.Join.ROUND
                textAlign = android.graphics.Paint.Align.CENTER
                typeface = customTypeface
            }

            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = aux
                color = android.graphics.Color.WHITE
                textAlign = android.graphics.Paint.Align.CENTER
                typeface = customTypeface
            }

            Canvas(
                modifier = Modifier
                    .fillMaxSize(),
                onDraw = {
                    drawIntoCanvas {
                        it.nativeCanvas.drawText(
                            "Tutorial",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Tutorial",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaint
                        )
                    }
                }
            )

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
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
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )

                }

                //Hueco 2
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(3f)
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
                    .weight(1f)
                    //.background(Color.Blue)
                ){

                }

                //Boton tutorial
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(2f)
                    //.background(Color.Green)
                ){
                    Box(modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)){
                        TutorialButton()
                    }


                }

                //Hueco 4
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



@Composable
fun ImageBackground(){
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Fondo de madera",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}