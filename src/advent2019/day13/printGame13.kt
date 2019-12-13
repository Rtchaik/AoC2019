package advent2019.day13

import utils.Coordinates

//    In runGame:
//    printGame(outputs.toList().flatMap { listOf(it.first.column, it.first.row, it.second).map { it.toLong() } })
fun printGame(outputs: List<Long>) {
    val points = outputs.map { it.toInt() }.chunked(3).associate { Coordinates(it[0], it[1]) to it[2] }
    val xMax = points.keys.map { it.column }.max()!!
    val yMax = points.keys.map { it.row }.max()!!
    println("Score: ${points.getOrDefault(Coordinates(-1, 0), 0)}")
    (0..yMax).forEach { y ->
        (0..xMax).forEach { x ->
            val current = points.getOrDefault(Coordinates(x, y), ' ')
            print(if (current == 0) ' ' else current)
        }
        println()
    }
}