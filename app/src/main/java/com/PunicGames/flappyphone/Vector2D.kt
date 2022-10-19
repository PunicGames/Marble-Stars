package com.PunicGames.flappyphone

import kotlin.math.*

class Vector2D (
    var x: Float,
    var y: Float
){
    var magnitude: Float = 0.0f
        get() = sqrt(x.pow(2) + y.pow(2))
        private set

    fun normalize(){
        if (magnitude != 0f) {
            this / magnitude
        }
    }

    operator fun plus(that: Vector2D): Vector2D {
        this.x += that.x
        this.y += that.y
        return this
    }

    operator fun minus(that: Vector2D): Vector2D {
        this.x -= that.x
        this.y -= that.y
        return this
    }

    operator fun times(that: Vector2D): Vector2D{
        this.x *= that.x
        this.y *= that.y
        return this
    }

    operator fun times(k: Float): Vector2D{
        this.x *= k
        this.y *= k
        return this
    }

    operator fun div(that: Vector2D):Vector2D{
        this.x /= that.x
        this.y /= that.y
        return this
    }
    operator fun div(k: Float): Vector2D{
        this.x /= k
        this.y /= k
        return this
    }
}