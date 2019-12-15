package advent2019.day15

import advent2019.day09.runProgram
import utils.Coordinates
import utils.directions
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val oxSystem = repairDroid(mapOf(Coordinates(0, 0) to program))
        val part1 = oxSystem.first
        val part2 = repairDroid(mapOf(oxSystem.second)).first
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private tailrec fun repairDroid(
    currentPos: Map<Coordinates, Map<Long, Long>>,
    locations: Map<Coordinates, Map<Long, Long>> = currentPos, steps: Int = 0
): Pair<Int, Pair<Coordinates, Map<Long, Long>>> {
    val newLoc = currentPos.flatMap { current ->
        "1423".mapIndexedNotNull { idx, dir ->
            val new = current.key + directions[idx]
            if (locations.getOrDefault(new, '0') == '0') {
                val status = runProgram(
                    current.value.toMutableMap(), mutableListOf(dir.toString().toLong()), Pair(0L, 0L)
                )
                when (status.second.first()) {
                    0L -> null
                    1L -> new to status.first
                    2L -> return steps + 1 to (new to status.first)
                    else -> throw IllegalStateException("Wrong status code -> $status")
                }
            } else null
        }
    }.toMap()
    return if (newLoc.isEmpty()) steps to (Coordinates(0, 0) to emptyMap()) else repairDroid(
        newLoc, locations + newLoc, steps.inc()
    )
}