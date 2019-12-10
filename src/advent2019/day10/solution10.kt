package advent2019.day10

import utils.Coordinates
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val current = input
        val asteroids = current.mapIndexed { rowIdx, row ->
            row.mapIndexedNotNull { colIdx, c -> if (c == '#') Coordinates(colIdx, rowIdx) else null }
        }.flatten()
        val limits = Pair(current[0].length, current.size)
        val monStation = asteroids.map { it to scan360(asteroids, it, limits) }.maxBy { it.second.size }!!.second
        val part1 = monStation.size
        val maxDepth = monStation.maxBy { it.size }!!.size
        val bet =
            (0 until maxDepth).flatMap { idx -> monStation.mapNotNull { if (it.size > idx) it[idx] else null } }[199]
        val part2 = bet.column * 100 + bet.row

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun scan360(
    asteroids: List<Coordinates>,
    base: Coordinates,
    limits: Pair<Int, Int>
): List<List<Coordinates>> {
    val q1 = asteroids.filter { it.column in base.column until limits.first && it.row in 0 until base.row }
        .associateWith { Pair(it.column - base.column, base.row - it.row) }
    val q2 =
        asteroids.filter { it.column in base.column + 1 until limits.first && it.row in base.row until limits.second }
            .associateWith { Pair(it.row - base.row, it.column - base.column) }
    val q3 =
        asteroids.filter { it.column in 0 until base.column + 1 && it.row in base.row + 1 until limits.second }
            .associateWith { Pair(base.column - it.column, it.row - base.row) }
    val q4 = asteroids.filter { it.column in 0 until base.column && it.row in 0 until base.row + 1 }
        .associateWith { Pair(base.row - it.row, base.column - it.column) }
    return radar(q1) + radar(q2) + radar(q3) + radar(q4)
}

private fun radar(currentMap: Map<Coordinates, Pair<Int, Int>>): List<List<Coordinates>> {
    if (currentMap.isEmpty()) return emptyList() else {
        val aggregate = currentMap.values.map { it.second.toBigInteger() }.distinct().reduce { acc, i -> acc * i }
        return currentMap.mapValues { aggregate / it.value.second.toBigInteger() * it.value.first.toBigInteger() }
            .toList().groupBy { it.second }.mapValues {
                it.value.map { it.first }.sortedBy { currentMap[it]!!.first + currentMap[it]!!.second }
            }.toSortedMap().values.toList()
    }
}