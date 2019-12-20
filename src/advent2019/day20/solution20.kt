package advent2019.day20

import utils.Coordinates
import utils.directions
import java.lang.Math.pow
import kotlin.math.sign
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val maze = (input.indices).flatMap { row ->
            (input[0].indices).map { col -> Coordinates(col, row) to input[row][col] }
        }.toMap()

        val allLetters = maze.filterValues { it.isLetter() }

        val portalsCoords = allLetters.map { l ->
            listOf(l, allLetters.filterKeys { it - l.key in directions }.entries.first())
                .sortedWith(compareBy({ it.key.column }, { it.key.row }))
        }.distinct().map { list ->
            val coord = list.flatMap { entry -> directions.map { it + entry.key } }.distinct()
                .first { maze.getOrDefault(it, ' ') == '.' }
            val name = list.map { it.value.toInt() }
                .mapIndexed { idx, i -> i * pow(100.0, idx.toDouble()).toInt() }.sum()
            coord to if (coord.column in listOf(2, input[0].length - 3) || coord.row in listOf(2, input.size - 3)) name
            else -name
        }.toMap()

        val portalsDist = portalsCoords.map { it.value to distances(listOf(Pair(it.key, it.key)), maze, portalsCoords) }
            .toMap()

        val part1 = shortestRoute(listOf(Portal(-6565, 0, 0.0)), portalsDist)
        val part2 = shortestRoute(listOf(Portal(-6565, 0, 0.0)), portalsDist, true)
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private data class Portal(val name: Int, val steps: Int, val level: Double)

private tailrec fun shortestRoute(
    current: List<Portal>, portals: Map<Int, List<Pair<Int, Int>>>, layers: Boolean = false, steps: Int = 1000000
): Int {
    return if (current.isEmpty()) steps - 1 else {
        var newSteps = steps
        val new = current.flatMap { node ->
            portals[-node.name]!!.mapNotNull {
                val newPortal = Portal(
                    it.first, it.second + node.steps + 1,
                    if (layers) node.level - sign(it.first.toDouble()) else 0.0
                )
                if (newPortal.steps < newSteps) {
                    if (newPortal.name != 9090) if (newPortal.level < 0) null else newPortal
                    else {
                        if (node.level == 0.0) newSteps = newPortal.steps
                        null
                    }
                } else null
            }

        }
        shortestRoute(new, portals, layers, newSteps)
    }
}

private tailrec fun distances(
    current: List<Pair<Coordinates, Coordinates>>, maze: Map<Coordinates, Char>, portals: Map<Coordinates, Int>,
    steps: Int = 0, dist: List<Pair<Int, Int>> = emptyList()
): List<Pair<Int, Int>> =
    if (current.isEmpty()) dist.filter { it.second != 0 && it.first != 6565 } else {
        val newDist = mutableListOf<Pair<Int, Int>>()
        val new = current.flatMap { node ->
            val valid = directions.map { it + node.first }
                .filterNot { coord -> "# ".any { it == maze.getValue(coord) } || coord == node.second }
            val newLet = valid.find { maze.getValue(it).isLetter() }
            (if (newLet == null) valid else {
                newDist.add(Pair(portals[node.first]!!, steps))
                valid - newLet
            }).map { it to node.first }
        }
        distances(new, maze, portals, steps.inc(), dist + newDist)
    }