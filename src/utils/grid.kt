package utils

import kotlin.math.abs
import kotlin.math.atan2

//direction 0 = North
val directions = listOf(Coordinates(0, 1), Coordinates(1, 0), Coordinates(0, -1), Coordinates(-1, 0))
val diagonals = listOf(Coordinates(-1, -1), Coordinates(-1, 1), Coordinates(1, 1), Coordinates(1, -1))


data class Coordinates(val column: Int, val row: Int) {

    operator fun plus(direction: Coordinates) =
        Coordinates(column + direction.column, row + direction.row)

    operator fun minus(direction: Coordinates) =
        Coordinates(column - direction.column, row - direction.row)
}

fun turnInDirection(direction: Int, action: Char) = when (action) {
    'S' -> direction//straight
    'R' -> (direction + 1) % 4//right
    'L' -> (direction - 1 + 4) % 4//left
    'B' -> (direction + 2) % 4//back
    else -> throw IllegalArgumentException("Unrecognized action: $action")
}

fun Coordinates.distance(target: Coordinates) = abs(this.row - target.row) + abs(this.column - target.column)

fun distance(star1: List<Int>, star2: List<Int>) = (0 until star1.size).sumBy { abs(star1[it] - star2[it]) }

//AoC19:10
//if a is 0, b is base than angle to c is: getAngle(base - Coordinates(0, 1), base, it)
fun getAngle(a: Coordinates, b: Coordinates, c: Coordinates): Double {
    val degr = Math.toDegrees(
        atan2((c.row - b.row).toDouble(), (c.column - b.column).toDouble()) -
                atan2((a.row - b.row).toDouble(), (a.column - b.column).toDouble())
    )
    return if (degr < 0) 360 + degr else degr
}