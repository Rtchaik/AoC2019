package advent2019.day10

import utils.Coordinates
import utils.distance
import utils.getAngle
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val asteroids = input.mapIndexed { rowIdx, row ->
            row.mapIndexedNotNull { colIdx, c -> if (c == '#') Coordinates(colIdx, rowIdx) else null }
        }.flatten()
        val maxAster = asteroids.map { curr ->
            curr to (asteroids - curr).map { it to getAngle(curr - Coordinates(0, 1), curr, it) }
                .groupBy { it.second }
        }.maxBy { it.second.values.size }!!
        val monStation =
            maxAster.second.toSortedMap().values.toList()
                .map { curr -> curr.map { it.first }.sortedBy { it.distance(maxAster.first) } }
        val part1 = monStation.size
        val maxDepth = monStation.maxBy { it.size }!!.size
        val bet =
            (0 until maxDepth).flatMap { idx -> monStation.mapNotNull { if (it.size > idx) it[idx] else null } }[199]
        val part2 = bet.column * 100 + bet.row
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}
