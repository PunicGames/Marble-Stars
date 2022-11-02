package com.PunicGames.flappyphone

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color

//Porque? Pa no repetir esto en cada game view
class Level(
    view: GameView,
    c: Int,
    r: Int,
    screenWidth: Int,
    screenHeight: Int,
    _backgroundImageID: Int,
    _wallTileID: Int,
    _goalTileID: Int,
    _starTileID: Int,
    _holeTileID: Int
) {

    var v: GameView = view

    //TO BE IMPLEMENTED
    var w: Int = v.width
    var h: Int = v.height
    val col: Int = c //18
    val row: Int = r //32
    val numberOfCells: Int = c * r


    val cells = ArrayList<Cell>()
    val colliders = ArrayList<BoxCollider>()
    val cellSize: Float = 60f

    var backGround: Bitmap
    var wall: Bitmap
    var goal: Bitmap
    var star: Bitmap
    var hole: Bitmap


    init {

        backGround = BitmapFactory.decodeResource(v.resources, _backgroundImageID)
        backGround = Bitmap.createScaledBitmap(backGround, screenHeight, screenWidth, false)

        wall = BitmapFactory.decodeResource(v.resources, _wallTileID)
        wall = Bitmap.createScaledBitmap(wall, cellSize.toInt(), cellSize.toInt(), true)

        goal = BitmapFactory.decodeResource(v.resources, _goalTileID)
        goal = Bitmap.createScaledBitmap(goal, cellSize.toInt(), cellSize.toInt(), true)

        star = BitmapFactory.decodeResource(v.resources, _starTileID)
        star = Bitmap.createScaledBitmap(star, cellSize.toInt(), cellSize.toInt(), true)

        hole = BitmapFactory.decodeResource(v.resources, _holeTileID)
        hole = Bitmap.createScaledBitmap(hole, cellSize.toInt(), cellSize.toInt(), true)

    }

    fun setTWallBlock(
        _colInit: Int,
        _rowInit: Int,
        _colFinalExclusive: Int,
        _rowFinalExclusive: Int
    ) {

        //Bitmap tile

        for (i in _rowInit.._rowFinalExclusive - 1) {
            for (j in _colInit.._colFinalExclusive - 1) {

                var wallTile = Cell(
                    wall,
                    i,
                    j,
                    j * cellSize,
                    i * cellSize,

                    )

                cells.add(wallTile)
            }

        }


        //Collider

        var collider = BoxCollider(
            Type.wall,
            _colInit * cellSize,
            _colFinalExclusive * cellSize,
            _rowInit * cellSize,
            _rowFinalExclusive * cellSize
        )

        colliders.add(collider)
    }

    fun setGoal(_row: Int, _col: Int) {

        //Bitmap tile
        var goalTile = Cell(
            goal,
            _row,
            _col,
            _col * cellSize,
            _row * cellSize,

            )

        cells.add(goalTile)
        //Collider
        var collider = BoxCollider(
            Type.goal,
            _col * cellSize,
            _col * cellSize,
            _row * cellSize,
            _row * cellSize
        )

        colliders.add(collider)
    }
    fun setStar(_row: Int, _col: Int) {

        //Bitmap tile
        var starTile = Cell(
            star,
            _row,
            _col,
            _col * cellSize,
            _row * cellSize,

            )

        cells.add(starTile)
        //Collider
        var collider = BoxCollider(
            Type.star,
            _col * cellSize,
            _col * cellSize,
            _row * cellSize,
            _row * cellSize
        )

        colliders.add(collider)
    }

    fun setHole(_row: Int, _col: Int) {

        //Bitmap tile
        var holeTile = Cell(
            hole,
            _row,
            _col,
            _col * cellSize,
            _row * cellSize,

            )
        cells.add(holeTile)

        //Collider
        var collider = BoxCollider(
            Type.hole,
            _col * cellSize,
            _col * cellSize,
            _row * cellSize,
            _row * cellSize
        )

        colliders.add(collider)
    }

    fun setBallStartPos(_x: Float, _y: Float) {
        v.ball.move(_x, _y)
    }

    fun draw(canvas: Canvas?) {

        //canvas?.drawBitmap(walkable, 0f, 0f, null)
        canvas?.drawColor(Color.WHITE)

        for (i in 0..cells.size - 1) {
            canvas?.drawBitmap(cells[i].bitmap, cells[i].posX, cells[i].posY, null)
        }
    }

}