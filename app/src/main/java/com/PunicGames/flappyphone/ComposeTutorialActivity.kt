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

class ComposeTutorialActivity : ComponentActivity() {

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
            TutorialContent()
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
    fun TutorialViewContainer(){

        Scaffold(
            content = { TutorialContent()}
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Tuto1(){

        Box(modifier = Modifier.fillMaxSize()){

            val aux = 70f

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
                            "Tilt your device to move",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Tilt your device to move",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaint
                        )
                    }
                }
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Tuto2(){

        Box(modifier = Modifier.fillMaxSize()){

            val aux = 70f

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
                            "Avoid walls and holes",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Avoid walls and holes",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaint
                        )
                    }
                }
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Tuto3(){

        Box(modifier = Modifier.fillMaxSize()){

            val aux = 70f

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
                            "Collect stars",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Collect stars",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaint
                        )
                    }
                }
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Tuto4(){

        Box(modifier = Modifier.fillMaxSize()){

            val aux = 70f

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
                            "Complete the level",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Complete the level",
                            size.width / 2,
                            size.height / 2 + aux / 2,
                            textPaint
                        )
                    }
                }
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun BackButton(){

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
                                    ComposeMainMenu::class.java
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
                            "Back",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Back",
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
    fun TutorialContent(){

        ImageBackground()

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(5f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Hueco 1
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                }
                //Tuto 1
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Tuto1()
                }
                //Hueco 2
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    //Imagen bola
                    Image(
                        painter = painterResource(id = R.drawable.ball),
                        contentDescription = "bola",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                //Tuto 2
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Tuto2()
                }
                //Hueco 3
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //Imagen pared
                        Image(
                            painter = painterResource(id = R.drawable.woodwall),
                            contentDescription = "bola",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //Imagen agujero
                        Image(
                            painter = painterResource(id = R.drawable.hole),
                            contentDescription = "bola",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                //Tuto 3
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Tuto3()
                }
                //Hueco 4
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    //Imagen estrella
                    Image(
                        painter = painterResource(id = R.drawable.estrella),
                        contentDescription = "bola",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                //Tuto 4
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Tuto4()
                }
                //Hueco 5
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    //Imagen meta
                    Image(
                        painter = painterResource(id = R.drawable.goal),
                        contentDescription = "bola",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ){
                }
                //Boton back
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    BackButton()
                }
                //Hueco 6
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
            }
        }
    }

}