package com.PunicGames.flappyphone

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.internal.ViewUtils.dpToPx


class ComposeLevelSelectionActivity : ComponentActivity() {

    private lateinit var selectorMusic: MediaPlayer
    private lateinit var buttonEffect: MediaPlayer

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            LevelSelectionViewContainer()
        }

        // Music
        selectorMusic = MediaPlayer.create(this, R.raw.selector_song);
        selectorMusic.start()
        selectorMusic.isLooping = true;
        selectorMusic.setVolume(0.2f, 0.2f);

        buttonEffect = MediaPlayer.create(this, R.raw.button);
        buttonEffect.setVolume(0.6f, 0.6f)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @Preview(showBackground = true, widthDp = 400, heightDp = 800)
    @Composable
    fun LevelSelectionViewContainer(){
        Scaffold(
            content = { LevelSelectionContent()},
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Level1Button(){


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
                                    Level_1_Activity::class.java
                                )
                            );
                            selectorMusic.stop()
                            selectorMusic.release()

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
                            "Level 1",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Level 1",
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
    fun Level2Button(){

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
                                    Level_2_Activity::class.java
                                )
                            );
                            selectorMusic.stop()
                            selectorMusic.release()

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
                            "Level 2",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Level 2",
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
    fun Level3Button(){

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
                                    Level_3_Activity::class.java
                                )
                            );
                            selectorMusic.stop()
                            selectorMusic.release()

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
                            "Level 3",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Level 3",
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
    fun Level4Button(){

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
                                    Level_4_Activity::class.java
                                )
                            );
                            selectorMusic.stop()
                            selectorMusic.release()

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
                            "Level 4",
                            size.width / 2,
                            size.height / 2 + aux / 3,
                            textPaintStroke
                        )
                        it.nativeCanvas.drawText(
                            "Level 4",
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
                            selectorMusic.stop()
                            selectorMusic.release()

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
    fun LevelSelectionContent(){

        ImageBackground()

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {



            Row(
                modifier = Modifier
                    //.background(Color.Red)
                    .fillMaxSize()
            ){
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
                        .weight(3f)
                    //.background(Color.Green)

                ) {
                    //Hueco 1
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Blue)
                    ) {

                    }

                    //Logo menu
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Green)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.select_level),
                            contentDescription = "Logo",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    //Hueco 2
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Blue)
                    ) {

                    }

                    //Boton 1
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Green)
                    ) {
                        Level1Button()

                    }

                    //Hueco 3
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Blue)
                    ) {

                    }

                    //Boton 2
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Green)
                    ) {
                        Level2Button()

                    }

                    //Hueco 4
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Blue)
                    ) {

                    }

                    //Boton 3
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Green)
                    ) {
                        Level3Button()

                    }

                    //Hueco 5
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Blue)
                    ) {

                    }

                    //Boton 4
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Green)
                    ) {
                        Level4Button()

                    }

                    //Hueco 6
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Blue)
                    ) {

                    }

                    //Boton 5
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Green)
                    ) {
                        BackButton()

                    }

                    //Hueco 7
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                        //.background(Color.Blue)
                    ) {

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

}


