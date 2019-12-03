package utils

import kotlin.math.abs

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