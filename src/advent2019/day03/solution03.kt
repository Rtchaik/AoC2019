package advent2019.day03

import utils.Coordinates
import utils.directions
import utils.distance
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val intersections =
            input.flatMap { wire -> findWirePath(wire).withIndex().distinctBy { it.value } }.groupBy { it.value }
                .filter { it.value.size > 1 && it.key != Coordinates(0, 0) }
        val part1 = intersections.map { it.key.distance(Coordinates(0, 0)) }.min()
        val part2 = intersections.map { item -> item.value.map { it.index }.sum() }.min()
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private fun findWirePath(path: String): List<Coordinates> {
    val wire = mutableListOf(Coordinates(0, 0))
    path.split(",").forEach { current ->
        val turn = directions["RULD".indexOf(current[0])]
        repeat(current.drop(1).toInt()) { wire.add(wire.last() + turn) }
    }
    return wire
}